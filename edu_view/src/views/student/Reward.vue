<template>
    <el-table :data="rewards" stripe boder>
        <el-table-column fixed prop="type" label="类型" />
        <el-table-column prop="name" label="奖励" />
        <el-table-column prop="time" label="时间" />
    </el-table>
    <el-pagination layout="prev, pager, next" :total="50" />

</template>

<script lang="ts" setup>
import { Comment, onMounted, reactive, renderSlot } from 'vue';
import { api } from '../../api/api';

interface Reward {
    id: number,
    uid: number,
    type: String,
    name: String,
    time: Date
}

var rewards: Array<Reward> = reactive([])

onMounted(() => {
    let user = JSON.parse(localStorage.getItem("user") || "")

    var data = { "id": user.id }
    api.get("/getStudentReward", { params: data })
        .then(res => {
            for (let i = 0; i < res.data.length; i++) {
                rewards[i] = res.data[i]
            }
        })

})
</script>


<style>
</style>