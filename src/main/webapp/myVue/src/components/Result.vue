<template>
<div>
  <div>最短路径:{{path}}</div>
  <div>最低费用:{{fee}}元</div>
  <div style="padding:10px">
    <el-button style="margin-left:5px" type="primary" @click="submit">返回</el-button>
  </div>
</div>
</template>

<script>
import axios from "axios";
export default {
  name: "Result",
  data(){
    return{
      path:"",
      fee:0,
    }
  },
  created(){
    this.load();
  },
  methods:{
    load() {
      fetch("http://localhost:8080/df").then(res=>res.json()).then(res=>{
        console.log(res)
        this.path=res.path;
        this.fee=res.fee;
      })
    },
    submit() {
      axios.post("/truncate").then(res=>{
        this.$router.push("/tourList");
      })
    },
  }
}
</script>

<style scoped>

</style>
