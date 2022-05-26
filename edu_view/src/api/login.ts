import { api } from "./api"
import qs from 'qs'
import { ElMessage } from 'element-plus'
import router from "../router"

// const login1 = (account: String, password: String) => {
//     var data = {"account": account, "password": password}
//     api.post("/login",qs.stringify(data))
//         .then(res => {
//             console.log(res.data)
//             localStorage.setItem("token",res.data.data.token)
//             localStorage.setItem("user",res.data.data.user)
//             // ElMessage(res.data.message)
//             router.push("/")
//         })
// }

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
                    "成绩查询": "/",
                    "奖罚查询": "/"
                }
            }
            ElMessage({type: "success",message: "登录成功"})
            router.push({path: "/",params: menus})
        })
}


export { login }