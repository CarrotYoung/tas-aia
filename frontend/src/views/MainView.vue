<template>
  <div class="grid">
    <ChatPanel />
    <FormPanel />
  </div>
</template>

<script setup lang="ts">
import { onMounted } from 'vue';
import ChatPanel from '../components/ChatPanel.vue';
import FormPanel from '../components/FormPanel.vue';
import { useSessionStore } from '../store/session';

const store = useSessionStore();

onMounted(() => {
  store.initSkills();
});
</script>

<style scoped>
.grid {
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 16px;
}
</style>
