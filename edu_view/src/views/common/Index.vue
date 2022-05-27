<template>

    <el-container>
        <el-aside width="200px">
            <menuVue />
        </el-aside>
        <el-container>
            <el-header>
                <div class="header">教务管理系统</div>
            </el-header>
            <el-main>
                <router-view />
            </el-main>
        </el-container>
    </el-container>


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

</script>


<style scoped lang="scss">
.el-container {
    height: 100%;

    * {
        padding: 0;
        margin: 0;
    }

    .el-header {
        // border-bottom: 1px solid #333;
        box-shadow: 0 2px 4px 0 rgb(0 0 0 / 5%);
    }

    .el-main{
        padding-left: 35px;
        padding-top: 35px;
    }

    .header {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100%;
    }

    .el-main {
        display: flex;
        justify-content: center;
        // align-items: center;
        width: 90%;
    }

}
</style>