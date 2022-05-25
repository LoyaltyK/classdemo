import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import element_plus from 'element-plus'
import 'element-plus/dist/index.css'
import './assets/css/index.css'

const app = createApp(App)
app.use(router).use(element_plus)
app.mount('#app')
