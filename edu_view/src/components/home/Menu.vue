<template>
    <el-menu :default-active="route.path" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose"
        active-text-color="#ffd04b" background-color="#545c64" router="true" :collapse="isCollapse">

        <h1>
            {{ user.username }}
        </h1>

        <el-menu-item v-for="menu in menus" :key="menu.path" :index="menu.path">
            <el-icon>
                <icon-menu />
            </el-icon>
            <span> {{ menu.name }} </span>
        </el-menu-item>


        <div class="logout">
            <div @click="logout">登出</div>
            <!-- 用户{{ user.username }}<br>
            id {{ user.userid }}<br>
            权限{{ user.role }}<br> -->
        </div>

    </el-menu>
</template>



<script lang="ts" setup>
import {
    Document,
    Menu as IconMenu,
    Location,
    Setting,
} from '@element-plus/icons-vue'
import { onMounted, reactive, ref } from 'vue';
import { useRoute } from 'vue-router';
import router from '../../router';


onMounted(() => {


    user.userid = JSON.parse(localStorage.getItem("user") || "").id
    user.username = JSON.parse(localStorage.getItem("user") || "").userName
    user.role = JSON.parse(localStorage.getItem("user") || "").role

    let menus1 = JSON.parse(localStorage.getItem("menus") || "").menus
    for (let i = 0; i < menus1.length; i++) {
        menus[i] = menus1[i]
    }

    console.log(menus)
})

const route = useRoute()

class menu {
    name = "";
    path = "";
}

let menus: Array<menu> = reactive([])

let isCollapse = ref(false)


const user = reactive({
    userid: "",
    username: "",
    role: ""
})


const handleOpen = (key: string, keyPath: string[]) => {
    console.log(key, keyPath)
}
const handleClose = (key: string, keyPath: string[]) => {
    console.log(key, keyPath)
}




const logout = () => {
    localStorage.removeItem("token")
    localStorage.removeItem("user")
    localStorage.removeItem("menus")
    router.push("/login")
}


</script>



<style lang="scss" scoped>
.el-menu {
    height: 100%;
    width: 199px;


    h1{
        height: 56px;
        width: 198px;
        display: flex;
        justify-content: center;
        align-items: center;
        color: rgb(255, 255, 255);
        background-color: rgba(0,0,0,0.5);
    }


    .logout{
        color: #ffd04b;
        width: 198px;
        height: 56px;
        position: fixed;
        bottom: 0;
        background-color: #545c64;
        display: flex;
        justify-content: center;
        align-items: center;
    }
}
</style>