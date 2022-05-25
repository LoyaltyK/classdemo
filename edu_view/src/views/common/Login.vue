<template>
  <div class="main">

    <el-form ref="ruleFormRef" :model="ruleForm" status-icon :rules="rules" label-width="120px" class="demo-ruleForm">
      <el-form-item label="账号" prop="pass">
        <el-input v-model="ruleForm.account" autocomplete="off" />
      </el-form-item>
      <el-form-item label="密码" prop="checkPass">
        <el-input v-model="ruleForm.password" type="password" autocomplete="off" />
      </el-form-item>
  
      <el-form-item>
        <el-button type="primary" @click="submitForm(ruleFormRef)">Submit</el-button>
        <el-button @click="resetForm(ruleFormRef)">Reset</el-button>
      </el-form-item>
    </el-form>

  </div>
</template>

<script lang="ts" setup>
import { reactive, ref } from 'vue'
import type { FormInstance } from 'element-plus'
import router from '../../router';

const ruleFormRef = ref<FormInstance>()


const validateAccount = (rule: any, value: any, callback: any) => {
  if (value === '') {
    callback(new Error('请输入账号'))
  } else {
    if (ruleForm.account !== '') {
      if (!ruleFormRef.value) return
      ruleFormRef.value.validateField('', (account) => null)
    }
    callback()
  }
}
const validatePassWord = (rule: any, value: any, callback: any) => {
  if (value === '') {
    callback(new Error('请输入密码'))
  } else {
    callback()
  }
}

const ruleForm = reactive({
  account: '',
  password: '',
})

const rules = reactive({
  pass: [{ validator: validateAccount, trigger: 'blur' }],
  checkPass: [{ validator: validatePassWord, trigger: 'blur' }],
})

const submitForm = (formEl: FormInstance | undefined) => {
  if (!formEl) return
  formEl.validate((valid) => {
    if (valid) {
      console.log('submit!')
      router.push("/")
    } else {
      console.log('error submit!')
      return false
    }
  })
}

const resetForm = (formEl: FormInstance | undefined) => {
  if (!formEl) return
  formEl.resetFields()
}
</script>


<style scoped lang="scss">
.main {
  height: 100%;
  width: 100%;
  display: flex;
  background-color: aquamarine;
  justify-content: center;
  align-items: center;
}

.el-form {
  height: 50%;
  width: 40%;
  background-color: rgba(255, 255, 255, 0.5);
  // display: flex;
  // align-items: center;
  // justify-content:left;
}
</style>