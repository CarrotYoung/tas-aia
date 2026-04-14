<template>
  <section class="panel">
    <h2>表单区</h2>
    <label>
      标题
      <input v-model="title" />
    </label>
    <label>
      金额
      <input v-model="amount" />
    </label>
    <label>
      原因
      <textarea v-model="reason"></textarea>
    </label>

    <div v-if="store.validateErrors.length" class="errors">
      <p v-for="err in store.validateErrors" :key="err">{{ err }}</p>
    </div>

    <div class="actions">
      <button @click="store.doValidate">校验</button>
      <button @click="store.doSave">保存</button>
    </div>

    <p v-if="store.savedId">已保存，ID：{{ store.savedId }}</p>
  </section>
</template>

<script setup lang="ts">
import { computed } from 'vue';
import { useSessionStore } from '../store/session';

const store = useSessionStore();

const title = computed({
  get: () => String(store.formData.title ?? ''),
  set: (value: string) => {
    store.formData.title = value;
  },
});

const amount = computed({
  get: () => String(store.formData.amount ?? ''),
  set: (value: string) => {
    store.formData.amount = value;
  },
});

const reason = computed({
  get: () => String(store.formData.reason ?? ''),
  set: (value: string) => {
    store.formData.reason = value;
  },
});
</script>

<style scoped>
.panel {
  background: white;
  border-radius: 12px;
  padding: 16px;
}

label {
  display: block;
  margin-bottom: 8px;
}

input,
textarea {
  width: 100%;
}

.actions {
  margin-top: 12px;
  display: flex;
  gap: 8px;
}

.errors {
  background: #fef2f2;
  color: #dc2626;
  padding: 8px;
  border-radius: 8px;
}
</style>
