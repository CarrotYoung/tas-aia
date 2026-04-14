# AI Skills 驱动的对话式表单生成系统

## Step 1 - 项目整体结构

本仓库采用前后端分离结构：

- `backend/`：Spring Boot + Spring AI Alibaba + MyBatis Plus
- `frontend/`：Vue3 + Pinia + SSE/fetch stream
- `docs/`：设计与接口文档

## 目录草图

```text
backend/
  src/main/java/com/example/aia/
    config/
    controller/
    dto/
    engine/
    entity/
    mapper/
    service/
      impl/
    tool/
    validator/
  src/main/resources/
frontend/
  src/
    api/
    components/
    store/
    views/
    types/
    utils/
  public/
docs/
```
