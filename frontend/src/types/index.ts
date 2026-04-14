export interface Skill {
  code: string;
  name: string;
  description: string;
}

export interface ApiResponse<T> {
  success: boolean;
  data: T;
  message: string;
}

export interface ChatPayload {
  sessionId: string;
  skillCode: string;
  message: string;
}

export interface FormPayload {
  sessionId: string;
  skillCode: string;
  payload: Record<string, unknown>;
}

export interface ValidationResult {
  valid: boolean;
  errors: string[];
}
