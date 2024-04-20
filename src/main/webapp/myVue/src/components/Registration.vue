<template>
  <div id="registration">
    <h2 style="margin-left:90px;color: #333333;margin-top: 100px">注册中心</h2>
    <el-form ref="form" :model="form" label-width="80px" style="margin-top: 30px">
      <el-form-item>
        <el-input v-model="form.username" style="width: 200px;" placeholder="用户名"></el-input>
      </el-form-item>
      <el-form-item>
        <el-input v-model="form.password" style="width: 200px;" placeholder="密码"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="register" style="width: 200px;">注册</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "Registration",
  data() {
    return {
      form: {
        username: '',
        password: ''
      }
    }
  },
  methods:{
    register(){
      axios.post("/register",this.form).then((response)=>{
        if (response.data==true){
          alert("注册失败!用户名已经存在!");
        }
        else{
          confirm("注册成功!正在登录...");
          this.$router.push("/first");
        }
      })
    },
  }
}
</script>

<style scoped>
  #registration{
    text-align: center;
    content: '';
    position: absolute;
    inset: 0;
    background-image: url("../assets/bg2.jpg");
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-size: cover;
    background-position: center;
  }
</style>
