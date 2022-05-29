<template>
    <el-table :data="scores" stripe boder >
        <el-table-column fixed prop="year" label="时间"  />
        <el-table-column prop="subjects" label="科目" />
        <el-table-column prop="scores" label="分数" />
    </el-table>
    <el-pagination 
    background layout="prev, pager, next" 
    :total="20" 
    :page-size="10" 
    :page-sizes="[10,20,30]"
    data="scores.slice((currentPage - 1) * pagesize, currentPage * pagesize) "
    @size-change="handleSizeChange"
    @current-change="handleCurrentChange" />

</template>

<script lang="ts" setup>
import { Comment, onMounted, reactive, Ref, ref, renderSlot } from 'vue';
import { api } from '../../api/api';

interface Scores {
    id: number,
    uid: number,
    subjects: number,
    scores: number,
    year: number
}



const scores: Ref<Array<Scores>> = ref([])
const total: Ref<number> = ref(0)


const handleSizeChange = ()=>{
    console.log(1)
}

const handleCurrentChange = () => {
    console.log(2)
}

onMounted(async () => {
    let user = JSON.parse(localStorage.getItem("user") || "")

    let data = { "id": user.id }
    let count = 0
    await api.get("/getStudentScores", { params: data })
        .then(res => {
            count = res.data.length
            console.log("---" + count)
            for (let i = 0; i < res.data.length; i++) {
                scores.value[i] = res.data[i]
            }
        })
    total.value = count

})

</script>


<style>
</style>