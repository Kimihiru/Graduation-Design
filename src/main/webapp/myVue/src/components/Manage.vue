<template>
  <div id="manage">
    <el-container>
      <el-aside width="200px" style="background-color: rgb(238, 241, 246);height: 100%">
        <Aside></Aside>
      </el-aside>
      <el-container>
        <el-header style="text-align: right; font-size: 12px; border-bottom: 1px solid red; line-height:60px">
          <Header name="Admin"/>
        </el-header>
        <el-main>
          <h1>你好!管理员</h1>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import Aside from "./Aside";
import Header from "./Header";

export default {
  name: "Manage",
  components:{
    Aside,
    Header,
  }
}
</script>

<style scoped>

</style>
