<template>
  <section class="panel">
    <h2>对话区</h2>
    <select v-model="store.selectedSkill">
      <option v-for="item in store.skills" :key="item.code" :value="item.code">
        {{ item.name }}
      </option>
    </select>

    <div class="logs">
      <p v-for="(line, idx) in store.chatLogs" :key="idx">{{ line }}</p>
    </div>

    <textarea v-model="store.chatInput" placeholder="描述你要生成的表单内容"></textarea>
    <button :disabled="store.loading" @click="store.sendChat">发送</button>
  </section>
</template>

<script setup lang="ts">
import { useSessionStore } from '../store/session';

const store = useSessionStore();
</script>

<style scoped>
.panel {
  background: white;
  border-radius: 12px;
  padding: 16px;
}

.logs {
  border: 1px solid #e5e7eb;
  border-radius: 8px;
  height: 300px;
  padding: 8px;
  overflow: auto;
  margin: 12px 0;
}

textarea {
  width: 100%;
  min-height: 88px;
}

button {
  margin-top: 8px;
}
</style>
