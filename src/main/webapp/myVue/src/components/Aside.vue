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
      <b style="color:white">后台管理系统</b>
    </div>
    <el-menu-item index="/Manage">
      <template slot="title">
        <i class="el-icon-house"></i>
        <span slot="title">主页</span>
      </template>
    </el-menu-item>
    <el-submenu index="4">
      <template slot="title">
        <i class="el-icon-menu"></i>
        <span slot="title">系统管理</span>
      </template>
      <el-menu-item index="/user">
        <i class="el-icon-s-custom"></i>
        <span slot="title">用户管理</span>
      </el-menu-item>
      <el-menu-item index="/type">
        <i class="el-icon-reading"></i>
        <span slot="title">景点分类管理</span>
      </el-menu-item>
      <el-menu-item index="/score">
        <i class="el-icon-star-on"></i>
        <span slot="title">景点评分管理</span>
      </el-menu-item>
      <el-menu-item index="/attractionInformation">
        <i class="el-icon-message"></i>
        <span slot="title">景点信息管理</span>
      </el-menu-item>
      <el-menu-item index="/food">
        <i class="el-icon-dish-1"></i>
        <span slot="title">景点美食管理</span>
      </el-menu-item>
    </el-submenu>
  </el-menu>

</template>

<script>
export default {
  name: "Aside"
}
</script>
<style scoped>
</style>
