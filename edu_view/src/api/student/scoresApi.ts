import { api } from "../api"

function getScores (id: number) {
    var data = {"id": id}
    api.get("/getStudentScores",{params: data})
        .then(res=>{
            console.log(res.data)
            return res.data
        })
}







export default { getScores }