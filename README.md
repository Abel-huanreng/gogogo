# GoGoGo 全栈应用

这是一个使用 Spring Boot + Vue.js 的单体应用项目。

## 项目结构

```
gogogo/
├── backend/          # Spring Boot 后端
├── frontend/         # Vue.js 前端
├── docs/            # 项目文档
└── README.md        # 项目说明
```

## 技术栈

### 后端
- Spring Boot 3.2.x
- Spring Web
- Spring Data JPA
- H2 Database (开发环境)
- Maven

### 前端
- Vue 3
- Vite
- Element Plus
- Axios
- Vue Router

## 快速开始

### 后端启动
```bash
cd backend
mvn spring-boot:run
```

### 前端启动
```bash
cd frontend
npm install
npm run dev
```

## 开发环境

- JDK 17+
- Node.js 18+
- Maven 3.8+ 