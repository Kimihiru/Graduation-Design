<template>
  <el-menu :default-openeds="['1', '4']"
           style="height:100%;
           overflow-x:hidden"
           background-color=rgb(48,65,86)
           text-color=#ccc
           active-text-color=red
           router=""
  >
    <div style="height:100%; line-height:60px; text-align:center">
      <img src="../assets/logo.png" style="width:20px;position:relative;top:5px;margin-right:5px"/>
      <b style="color:white">欢迎登录</b>
    </div>
    <el-menu-item index="/first">
      <template slot="title">
        <i class="el-icon-house"></i>
        <span slot="title">热门</span>
      </template>
    </el-menu-item>
    <el-menu-item index="/tourList">
      <i class="el-icon-guide"></i>
      <span slot="title">主页</span>
    </el-menu-item>
    <el-menu-item index="/personalRecommend">
      <i class="el-icon-user-solid"></i>
      <span slot="title">推荐</span>
    </el-menu-item>
    <el-menu-item index="/cart">
      <i class="el-icon-box"></i>
      <span slot="title">预选旅游点</span>
    </el-menu-item>
  </el-menu>
</template>

<script>
export default {
  name: "UserAside"
}
</script>

<style scoped>

</style>
