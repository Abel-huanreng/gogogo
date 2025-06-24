import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import UserManagement from '../views/UserManagement.vue'

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/users',
    name: 'UserManagement',
    component: UserManagement
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router 