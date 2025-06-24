<template>
  <div id="app">
    <el-container>
      <el-header>
        <el-menu
          :default-active="activeIndex"
          class="el-menu-demo"
          mode="horizontal"
          router
        >
          <el-menu-item index="/">
            <el-icon><HomeFilled /></el-icon>
            <span>首页</span>
          </el-menu-item>
          <el-menu-item index="/users">
            <el-icon><User /></el-icon>
            <span>用户管理</span>
          </el-menu-item>
        </el-menu>
      </el-header>
      
      <el-main>
        <router-view />
      </el-main>
      
      <el-footer>
        <p>&copy; 2024 GoGoGo 应用. All rights reserved.</p>
      </el-footer>
    </el-container>
  </div>
</template>

<script>
import { ref, computed } from 'vue'
import { useRoute } from 'vue-router'
import { HomeFilled, User } from '@element-plus/icons-vue'

export default {
  name: 'App',
  components: {
    HomeFilled,
    User
  },
  setup() {
    const route = useRoute()
    
    const activeIndex = computed(() => route.path)
    
    return {
      activeIndex
    }
  }
}
</script>

<style>
#app {
  font-family: 'Helvetica Neue', Helvetica, 'PingFang SC', 'Hiragino Sans GB', 'Microsoft YaHei', '微软雅黑', Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  height: 100vh;
}

.el-container {
  height: 100vh;
}

.el-header {
  background-color: #fff;
  border-bottom: 1px solid #e6e6e6;
  padding: 0;
}

.el-menu-demo {
  border-bottom: none;
}

.el-main {
  background-color: #f5f5f5;
  padding: 20px;
}

.el-footer {
  background-color: #fff;
  border-top: 1px solid #e6e6e6;
  text-align: center;
  color: #666;
  padding: 20px;
}
</style> 