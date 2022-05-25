import axios from 'axios'

const api = axios.create({
    baseURL: "/api",
    headers: {
        "token": localStorage.getItem("token") || ""
    }
})

export {api}