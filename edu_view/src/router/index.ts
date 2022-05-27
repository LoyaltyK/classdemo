import { createRouter, createWebHashHistory } from 'vue-router'
import IndexVue from '../views/common/Index.vue'
import LoginVue from '../views/common/Login.vue'
import scoresVue from '../views/student/Scores.vue'
import rewardVue from '../views/student/Reward.vue'


const routes = [
    {
        path: "/",
        redirect: "/index",
    },
    {
        path: '/index',  
        component: IndexVue,
        redirect: "/student/scores",
        meta: {
            isCheck: true
        },
        children: [
            {
                path: "/student/scores",
                component: scoresVue
            },
            {
                path: "/student/reward",
                component: rewardVue
            }
        ]
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