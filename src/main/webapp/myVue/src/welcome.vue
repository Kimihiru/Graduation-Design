<template>
  <div id="welcome">
    <h2 style="margin-left:100px;color: #333333;margin-top: 100px">广州市旅游景点推荐系统</h2>
    <el-form ref="form" :model="form" label-width="80px" style="margin-top: 30px">
      <el-form-item>
          <el-input v-model="form.username" style="width: 200px;" placeholder="用户名"></el-input>
      </el-form-item>
      <el-form-item>
          <el-input v-model="form.password" style="width: 200px;" placeholder="密码"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="login" style="width: 93px;">用户登录</el-button>
        <el-button type="primary" @click="admin" style="width: 97px;">管理员登录</el-button>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="reset" style="width: 200px;">重置</el-button>
      </el-form-item>
      <el-form-item>
        <h2><a href="#" @click="register" style="color: darkorchid;">还没账户?点击注册</a></h2>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
import axios from "axios";
export default {
  name: "welcome",
  data() {
    return {
      form: {
        username: '',
        password: ''
      },
    }
  },
  methods: {
    login() {
      axios.post("/userLogin",this.form).then((response)=>{
        if(response.data==true) {
          confirm('登录成功!');
          this.$router.push("/tourList");
        }
        else alert('用户名或密码错误，请重试！');
      })
    },
    register() {
      this.$router.push("/registration");
    },
    admin(){
      axios.post("/adminLogin",this.form).then((response)=>{
        if(response.data==true){
          confirm("登录成功!");
          this.$router.push("/Manage");
        }
        else{
          alert("管理员密码错误");
        }
      })
    },
    reset(){
      this.form.username="";
      this.form.password="";
    },
  },
}
</script>
<style>
  #welcome{
    text-align: center;
    content: '';
    position: absolute;
    inset: 0;
    background-image: url("./assets/bg1.jpg");
    background-repeat: no-repeat;
    background-attachment: fixed;
    background-size: cover;
    background-position: center;
  }
</style>
