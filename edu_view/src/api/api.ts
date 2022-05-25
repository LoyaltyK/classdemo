import axios from 'axios'

const api = axios.create({
    baseURL: '/api',
    timeout: 2000,
    headers: {
        "token": localStorage.getItem("token") || ""
    }
})

export {api}