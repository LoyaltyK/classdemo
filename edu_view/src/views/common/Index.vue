<template>

    <!-- <div class="common-layout"> -->
    <el-container>
        <el-header>
            <header>
                <div @click="logout">登出</div>
                用户{{ user.username }}<br>
                id {{ user.userid }}<br>
                权限{{ user.role }}<br>
            </header>

        </el-header>
        <el-container>
            <el-aside width="200px">
                <menuVue/>
            </el-aside>
            <el-main>Main</el-main>
        </el-container>
    </el-container>
    <!-- </div> -->


</template>


<script lang="ts" setup>
import { onMounted, reactive } from 'vue';
import router from '../../router';
import menuVue from '../../components/home/Menu.vue'

const user = reactive({
    userid: "",
    username: "",
    role: ""
})

const menus = reactive({})

onMounted(() => {
    user.userid = JSON.parse(localStorage.getItem("user") || "").id
    user.username = JSON.parse(localStorage.getItem("user") || "").userName
    user.role = JSON.parse(localStorage.getItem("user") || "").role
    // menus = JSON.parse(router.)
})

const logout = () => {
    localStorage.removeItem("token")
    localStorage.removeItem("user")
    router.push("/login")
}
</script>


<style scoped lang="scss">
.el-container{
    height: 100%;

    *{
        padding: 0;
        margin: 0;
    }
}
</style>