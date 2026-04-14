# AI Skills 驱动的对话式表单生成系统

## 当前进度（Step 2）

已完成前后端可运行骨架代码：

- `backend/`：Spring Boot API（skills/chat stream/validate/save/detail）
- `frontend/`：Vue3 + Pinia 双栏页面（对话区 + 表单区）
- `docs/`：架构说明

## 启动方式

### 后端

```bash
cd backend
mvn spring-boot:run
```

默认端口：`8080`

### 前端

```bash
cd frontend
npm install
npm run dev
```

默认端口：`5173`（已代理 `/api` 到后端）
