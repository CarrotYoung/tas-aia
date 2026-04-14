import type { ChatPayload } from '../types';

export async function readChatStream(
  payload: ChatPayload,
  onChunk: (chunk: string) => void,
): Promise<void> {
  const response = await fetch('/api/chat/stream', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(payload),
  });

  if (!response.body) {
    throw new Error('No stream body received');
  }

  const reader = response.body.getReader();
  const decoder = new TextDecoder();

  while (true) {
    const { done, value } = await reader.read();
    if (done) {
      break;
    }

    const text = decoder.decode(value, { stream: true });
    text
      .split('\n')
      .filter((line) => line.startsWith('data: '))
      .forEach((line) => onChunk(line.slice(6)));
  }
}
