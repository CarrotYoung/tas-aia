import { defineStore } from 'pinia';
import { fetchSkills, saveForm, validateForm } from '../api';
import { readChatStream } from '../utils/stream';
import type { Skill } from '../types';

const defaultForm = {
  title: '',
  amount: '',
  reason: '',
};

export const useSessionStore = defineStore('session', {
  state: () => ({
    sessionId: crypto.randomUUID(),
    skills: [] as Skill[],
    selectedSkill: '',
    chatInput: '',
    chatLogs: [] as string[],
    loading: false,
    formData: { ...defaultForm } as Record<string, unknown>,
    validateErrors: [] as string[],
    savedId: '',
  }),
  actions: {
    async initSkills() {
      const res = await fetchSkills();
      this.skills = res.data;
      this.selectedSkill = this.skills[0]?.code ?? '';
    },

    async sendChat() {
      if (!this.chatInput || !this.selectedSkill) {
        return;
      }
      this.loading = true;
      this.chatLogs.push(`👤 ${this.chatInput}`);
      await readChatStream(
        {
          sessionId: this.sessionId,
          skillCode: this.selectedSkill,
          message: this.chatInput,
        },
        (chunk) => this.chatLogs.push(`🤖 ${chunk}`),
      );
      this.chatInput = '';
      this.loading = false;
    },

    async doValidate() {
      const res = await validateForm({
        sessionId: this.sessionId,
        skillCode: this.selectedSkill,
        payload: this.formData,
      });
      this.validateErrors = res.data.errors;
      return res.data.valid;
    },

    async doSave() {
      const valid = await this.doValidate();
      if (!valid) {
        return;
      }

      const res = await saveForm({
        sessionId: this.sessionId,
        skillCode: this.selectedSkill,
        payload: this.formData,
      });
      this.savedId = res.data.id;
    },
  },
});
