<template>
    <el-table :data="scores" stripe boder >
        <el-table-column fixed prop="year" label="时间" width="180" />
        <el-table-column prop="subjects" label="科目" width="180" />
        <el-table-column prop="scores" label="分数" width="180" />
    </el-table>

</template>

<script lang="ts" setup>
import { Comment, onMounted, reactive, renderSlot } from 'vue';
import { api } from '../../api/api';

interface Scores {
    id: number,
    uid: number,
    subjects: number,
    scores: number,
    year: number
}

var scores: Array<Scores> = reactive([])

onMounted(() => {
    let user = JSON.parse(localStorage.getItem("user") || "")

    var data = { "id": user.id }
    api.get("/getStudentScores", { params: data })
        .then(res => {
            for (let i = 0; i < res.data.length; i++) {
                scores[i] = res.data[i]
            }
        })

})

</script>


<style>
</style>