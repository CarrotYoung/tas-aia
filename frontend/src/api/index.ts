import { http } from './http';
import type { ApiResponse, FormPayload, Skill, ValidationResult } from '../types';

export function fetchSkills() {
  return http<ApiResponse<Skill[]>>('/api/skills');
}

export function validateForm(payload: FormPayload) {
  return http<ApiResponse<ValidationResult>>('/api/forms/validate', {
    method: 'POST',
    body: JSON.stringify(payload),
  });
}

export function saveForm(payload: FormPayload) {
  return http<ApiResponse<{ id: string; message: string }>>('/api/forms/save', {
    method: 'POST',
    body: JSON.stringify(payload),
  });
}
