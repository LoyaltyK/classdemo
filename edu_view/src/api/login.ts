import { api } from "./api"
import qs from 'qs'

const login = (account: String, password: String) => {
    var data = {"a": account, "password": password}
    api.post("/login",qs.stringify(data))
        .then(res => {
            if (res.status == 200) {
                console.log("200")
            }
        })
}


export { login }