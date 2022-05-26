import { createRouter, createWebHashHistory } from 'vue-router'
import IndexVue from '../views/common/Index.vue'
import LoginVue from '../views/common/Login.vue'


const routes = [
    {
        path: "/",
        redirect: "/index",
    },
    {
        path: '/index',  
        component: IndexVue,
        meta: {
            isCheck: true
        },
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

router.beforeEach((to, from, next)=>{
    console.log("to: " + to.fullPath)
    if (to.meta.isCheck) {
        if (localStorage.getItem("token")) {
            next()
        } else {
            next({
                path: "/login",
                query: {
                    repath: to.fullPath
                }
            })
        }
    } else {
        next()
    }
})

export default router