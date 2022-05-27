<template>
    <el-menu default-active="2" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose">
       
        <el-menu-item v-for="menu in menus" :key="menu.path" :index="menu.name">
            <el-icon>
                <icon-menu />
            </el-icon>
            <span> {{ menu.name }} </span>
        </el-menu-item>
        
    </el-menu>
</template>



<script lang="ts" setup>
import {
    Document,
    Menu as IconMenu,
    Location,
    Setting,
} from '@element-plus/icons-vue'
import { onMounted, reactive } from 'vue';
import { useRoute } from 'vue-router';

const route = useRoute()
let menus = reactive([{
    name: "",
    path: "",
}])

const handleOpen = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}
const handleClose = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}

onMounted(()=>{
    // menus = route.params.menus
    menus = JSON.parse(localStorage.getItem("menus") || "").menus
    console.log(menus)
})

</script>



<style lang="scss" scoped>
.el-menu{
    height: 100%;
}

</style>