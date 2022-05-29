import { api } from "./api"
import qs from 'qs'
import { ElMessage } from 'element-plus'
import router from "../router"

async function login(account: String, password: String) {
    var data = {"account": account, "password": password}
    api.post("/login",qs.stringify(data))
        .then(res => {
            console.log(res.data)
            localStorage.setItem("token",res.data.data.token)
            localStorage.setItem("user",JSON.stringify(res.data.data.user))
            let menus = {}
            if(res.data.data.user.role === "student"){
                menus = {
                    menus: [
                        {
                            name: "成绩查询",
                            path: "/student/scores",
                        },
                        {
                            name: "奖罚查询",
                            path: "/student/reward"
                        }
                    ]
                }
            } else if(res.data.data.user.role === "teacher"){
                menus = {
                    menus: [
                        {
                            name: "选课申请",
                            path: "/student/scores",
                        },
                        {
                            name: "选课情况",
                            path: "/student/reward"
                        }
                    ]
                }
            }
            // route.
            ElMessage({type: "success",message: "登录成功"})
            localStorage.setItem("menus",JSON.stringify(menus))
            router.push("/")
        })
}


export { login }