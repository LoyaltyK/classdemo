import { createRouter, createWebHashHistory } from 'vue-router'
import HelloWorldVue from '../components/HelloWorld.vue'
import LoginVue from '../views/common/Login.vue'


const routes = [
    {
        path: '/',  //主页 
        component: HelloWorldVue,
    },
    {
        path: "/login",
        component: LoginVue,
    }
    
]

const router = createRouter({
    routes,
    history: createWebHashHistory()
})

export default router