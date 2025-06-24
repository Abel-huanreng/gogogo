<template>
  <div class="user-management">
    <el-card>
      <template #header>
        <div class="card-header">
          <span>用户管理</span>
          <el-button type="primary" @click="showAddDialog = true">
            <el-icon><Plus /></el-icon>
            添加用户
          </el-button>
        </div>
      </template>
      
      <el-table :data="users" v-loading="loading" style="width: 100%">
        <el-table-column prop="id" label="ID" width="80" />
        <el-table-column prop="username" label="用户名" width="150" />
        <el-table-column prop="email" label="邮箱" width="200" />
        <el-table-column prop="fullName" label="姓名" width="150" />
        <el-table-column prop="status" label="状态" width="100">
          <template #default="scope">
            <el-tag :type="getStatusType(scope.row.status)">
              {{ scope.row.status }}
            </el-tag>
          </template>
        </el-table-column>
        <el-table-column label="操作" width="200">
          <template #default="scope">
            <el-button size="small" @click="editUser(scope.row)">
              编辑
            </el-button>
            <el-button size="small" type="danger" @click="deleteUser(scope.row.id)">
              删除
            </el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-card>

    <!-- 添加/编辑用户对话框 -->
    <el-dialog
      v-model="showAddDialog"
      :title="editingUser ? '编辑用户' : '添加用户'"
      width="500px"
    >
      <el-form
        ref="userFormRef"
        :model="userForm"
        :rules="userRules"
        label-width="80px"
      >
        <el-form-item label="用户名" prop="username">
          <el-input v-model="userForm.username" placeholder="请输入用户名" />
        </el-form-item>
        <el-form-item label="邮箱" prop="email">
          <el-input v-model="userForm.email" placeholder="请输入邮箱" />
        </el-form-item>
        <el-form-item label="密码" prop="password" v-if="!editingUser">
          <el-input
            v-model="userForm.password"
            type="password"
            placeholder="请输入密码"
            show-password
          />
        </el-form-item>
        <el-form-item label="姓名" prop="fullName">
          <el-input v-model="userForm.fullName" placeholder="请输入姓名" />
        </el-form-item>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="showAddDialog = false">取消</el-button>
          <el-button type="primary" @click="saveUser" :loading="saving">
            确定
          </el-button>
        </span>
      </template>
    </el-dialog>
  </div>
</template>

<script>
import { ref, reactive, onMounted } from 'vue'
import { ElMessage, ElMessageBox } from 'element-plus'
import { Plus } from '@element-plus/icons-vue'
import axios from 'axios'

export default {
  name: 'UserManagement',
  components: {
    Plus
  },
  setup() {
    const users = ref([])
    const loading = ref(false)
    const saving = ref(false)
    const showAddDialog = ref(false)
    const editingUser = ref(null)
    const userFormRef = ref()

    const userForm = reactive({
      username: '',
      email: '',
      password: '',
      fullName: ''
    })

    const userRules = {
      username: [
        { required: true, message: '请输入用户名', trigger: 'blur' },
        { min: 3, max: 20, message: '长度在 3 到 20 个字符', trigger: 'blur' }
      ],
      email: [
        { required: true, message: '请输入邮箱地址', trigger: 'blur' },
        { type: 'email', message: '请输入正确的邮箱地址', trigger: 'blur' }
      ],
      password: [
        { required: true, message: '请输入密码', trigger: 'blur' },
        { min: 6, message: '密码长度不能少于6个字符', trigger: 'blur' }
      ],
      fullName: [
        { required: true, message: '请输入姓名', trigger: 'blur' }
      ]
    }

    const loadUsers = async () => {
      loading.value = true
      try {
        const response = await axios.get('/api/users')
        users.value = response.data
      } catch (error) {
        ElMessage.error('加载用户列表失败')
        console.error('Error loading users:', error)
      } finally {
        loading.value = false
      }
    }

    const saveUser = async () => {
      if (!userFormRef.value) return
      
      await userFormRef.value.validate(async (valid) => {
        if (valid) {
          saving.value = true
          try {
            if (editingUser.value) {
              await axios.put(`/api/users/${editingUser.value.id}`, userForm)
              ElMessage.success('用户更新成功')
            } else {
              await axios.post('/api/users', userForm)
              ElMessage.success('用户添加成功')
            }
            showAddDialog.value = false
            resetForm()
            loadUsers()
          } catch (error) {
            ElMessage.error(editingUser.value ? '更新用户失败' : '添加用户失败')
            console.error('Error saving user:', error)
          } finally {
            saving.value = false
          }
        }
      })
    }

    const editUser = (user) => {
      editingUser.value = user
      Object.assign(userForm, {
        username: user.username,
        email: user.email,
        password: '',
        fullName: user.fullName
      })
      showAddDialog.value = true
    }

    const deleteUser = async (id) => {
      try {
        await ElMessageBox.confirm('确定要删除这个用户吗？', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        })
        
        await axios.delete(`/api/users/${id}`)
        ElMessage.success('删除成功')
        loadUsers()
      } catch (error) {
        if (error !== 'cancel') {
          ElMessage.error('删除失败')
          console.error('Error deleting user:', error)
        }
      }
    }

    const resetForm = () => {
      editingUser.value = null
      Object.assign(userForm, {
        username: '',
        email: '',
        password: '',
        fullName: ''
      })
      if (userFormRef.value) {
        userFormRef.value.resetFields()
      }
    }

    const getStatusType = (status) => {
      switch (status) {
        case 'ACTIVE':
          return 'success'
        case 'INACTIVE':
          return 'warning'
        case 'DELETED':
          return 'danger'
        default:
          return 'info'
      }
    }

    onMounted(() => {
      loadUsers()
    })

    return {
      users,
      loading,
      saving,
      showAddDialog,
      editingUser,
      userForm,
      userFormRef,
      userRules,
      saveUser,
      editUser,
      deleteUser,
      getStatusType
    }
  }
}
</script>

<style scoped>
.user-management {
  max-width: 1200px;
  margin: 0 auto;
}

.card-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.dialog-footer {
  display: flex;
  justify-content: flex-end;
  gap: 10px;
}
</style> 