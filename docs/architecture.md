# 架构分层（Step 1）

## 后端模块规划

1. `controller`：对外 API（skills、chat stream、validate、save、detail）
2. `service`：业务编排（对话、校验、保存）
3. `engine`：SkillEngine（技能装配 + 提示词 + DTO + tool 配置）
4. `tool`：ToolExecutor（HTTP/MCP统一调用，透传 token）
5. `validator`：JSON -> DTO -> JSR303 校验
6. `dto/entity/mapper`：数据结构与持久化

## 前端模块规划

1. `views`：左右布局页面（对话 + 表单）
2. `components`：聊天窗口、动态表单、上传组件
3. `store`：会话状态、流式状态、重试计数
4. `api`：skills/chat stream/validate/save/detail 接口
5. `types`：Skill、StreamChunk、FormData 类型
6. `utils`：SSE/fetch stream 解析、重试策略
