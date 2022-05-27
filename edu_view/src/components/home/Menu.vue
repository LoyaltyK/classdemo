<template>
    <el-menu :default-active="route.path" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose" router="true">
       
        <el-menu-item v-for="menu in menus" :key="menu.path" :index="menu.path">
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
import { onMounted, reactive, ref } from 'vue';
import { useRoute } from 'vue-router';


onMounted(()=>{
    let menus1 = JSON.parse(localStorage.getItem("menus") || "").menus
    for(let i=0; i< menus1.length; i++ ){
        menus[i] = menus1[i] 
    }
    
    console.log(menus)
})

const route = useRoute()

class menu {
    name= "";
    path= "";
}

let menus: Array<menu> = reactive([])



const handleOpen = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}
const handleClose = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}



</script>



<style lang="scss" scoped>
.el-menu{
    height: 100%;
}

</style>