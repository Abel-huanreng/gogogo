<template>
  <div class="home">
    <el-row :gutter="20">
      <el-col :span="24">
        <el-card class="welcome-card">
          <template #header>
            <div class="card-header">
              <span>欢迎使用 GoGoGo 应用</span>
            </div>
          </template>
          <div class="welcome-content">
            <el-row :gutter="20">
              <el-col :span="8">
                <el-card class="feature-card">
                  <el-icon size="40" color="#409EFF"><User /></el-icon>
                  <h3>用户管理</h3>
                  <p>完整的用户CRUD操作，支持增删改查</p>
                  <el-button type="primary" @click="$router.push('/users')">
                    进入用户管理
                  </el-button>
                </el-card>
              </el-col>
              <el-col :span="8">
                <el-card class="feature-card">
                  <el-icon size="40" color="#67C23A"><DataBoard /></el-icon>
                  <h3>数据展示</h3>
                  <p>现代化的数据展示界面，支持表格和图表</p>
                  <el-button type="success">查看数据</el-button>
                </el-card>
              </el-col>
              <el-col :span="8">
                <el-card class="feature-card">
                  <el-icon size="40" color="#E6A23C"><Setting /></el-icon>
                  <h3>系统设置</h3>
                  <p>灵活的系统配置选项，满足各种需求</p>
                  <el-button type="warning">系统设置</el-button>
                </el-card>
              </el-col>
            </el-row>
          </div>
        </el-card>
      </el-col>
    </el-row>
    
    <el-row :gutter="20" style="margin-top: 20px;">
      <el-col :span="12">
        <el-card>
          <template #header>
            <div class="card-header">
              <span>技术栈</span>
            </div>
          </template>
          <el-descriptions :column="1" border>
            <el-descriptions-item label="后端框架">Spring Boot 3.2.x</el-descriptions-item>
            <el-descriptions-item label="前端框架">Vue 3 + Vite</el-descriptions-item>
            <el-descriptions-item label="UI组件库">Element Plus</el-descriptions-item>
            <el-descriptions-item label="数据库">H2 (开发环境)</el-descriptions-item>
            <el-descriptions-item label="构建工具">Maven + Vite</el-descriptions-item>
          </el-descriptions>
        </el-card>
      </el-col>
      <el-col :span="12">
        <el-card>
          <template #header>
            <div class="card-header">
              <span>快速开始</span>
            </div>
          </template>
          <el-steps direction="vertical" :active="1">
            <el-step title="启动后端" description="cd backend && mvn spring-boot:run" />
            <el-step title="启动前端" description="cd frontend && npm install && npm run dev" />
            <el-step title="访问应用" description="打开浏览器访问 http://localhost:5173" />
          </el-steps>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import { User, DataBoard, Setting } from '@element-plus/icons-vue'

export default {
  name: 'Home',
  components: {
    User,
    DataBoard,
    Setting
  }
}
</script>

<style scoped>
.home {
  max-width: 1200px;
  margin: 0 auto;
}

.welcome-card {
  margin-bottom: 20px;
}

.card-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.welcome-content {
  text-align: center;
}

.feature-card {
  text-align: center;
  padding: 20px;
  height: 200px;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}

.feature-card h3 {
  margin: 15px 0 10px 0;
  color: #303133;
}

.feature-card p {
  color: #606266;
  margin-bottom: 20px;
  flex-grow: 1;
}
</style> 