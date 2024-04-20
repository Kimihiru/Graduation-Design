<template>
  <div id="tourList">
    <el-container style="height: 100%">
      <el-aside width="200px" style="background-color: rgb(238, 241, 246);height: 100%">
        <UserAside></UserAside>
      </el-aside>
      <el-container>
        <el-header style="text-align: right; font-size: 12px; border-bottom: 1px solid red; line-height:60px">
          <Header name="你好"/>
        </el-header>
        <el-main>
          <div style="padding:10px">
            <el-button style="margin-left:5px" type="primary" @click="submit">提交</el-button>
          </div>
          <el-table :data="tableData">
            <el-table-column prop="name" label="景点名">
            </el-table-column>
            <el-table-column prop="area" label="所属区域">
            </el-table-column>
            <el-table-column fixed="right" label="操作">
              <template slot-scope="scope">
                <el-button type="danger" size="small" icon="el-icon-delete" @click="handleDelete(scope.row)">移除</el-button>
              </template>
            </el-table-column>
          </el-table>
          <div style="padding:10px">
            <el-pagination
              @size-change="handleSizeChange"
              @current-change="handleCurrentChange"
              :current-page="pageNum"
              :page-sizes="[5, 10, 15, 20]"
              :page-size="pageSize"
              layout="total, sizes, prev, pager, next, jumper"
              :total="total">
            </el-pagination>
          </div>

          <el-dialog title="景点信息" :visible.sync="dialogFormVisible" width="30%">
            <el-form label-width="80px" size="small">
              <el-form-item label="序号">
                <el-input v-model="form.id" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="景点名">
                <el-input v-model="form.name" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="所属区域">
                <el-input v-model="form.area" autocomplete="off"></el-input>
              </el-form-item>
            </el-form>
          </el-dialog>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import Header from "./Header";
import UserAside from "./UserAside";
import axios from "axios";
export default {
  name: "Cart",
  components:{
    Header,
    UserAside,
  },
  data() {
    return {
      tableData:[],
      total:0,
      pageNum:1,
      pageSize:5,
      id:"",
      name:"",
      area:"",
      dialogFormVisible:false,
      form:{},
    }
  },
  created(){
    //请求分页查询数据
    this.load();
  },
  methods: {
    edit(row){
      console.log(row);
    },
    handleSizeChange(val) {/*传递过来当前是第几页*/
      console.log(`每页 ${val} 条`);
      this.pageSize=val;  //获取当前每页显示条数
      this.load();
    },
    handleCurrentChange(val) {/*传递过来当前是第几页*/
      console.log(`当前页: ${val}`);
      this.pageNum=val;   //获取当前第几页
      this.load();
    },
    //将请求数据封装为一个方法
    load() {
      //请求分页查询数据
      fetch("http://localhost:8080/cartPage?pageNum="+this.pageNum
        +"&pageSize="+this.pageSize +"").then(res=>res.json()).then(res=>{
        console.log(res)
        this.tableData=res.data
        this.total=res.total
        this.name=""
      })
    },
    handleDelete(row){
      console.log(row);
      this.dialogFormVisible = false;
      this.form=row;
      axios.post("/deleteFromCart",this.form).then(res=>{
        if(res.data==true){
          alert("移除成功");
          this.load();
        }
        else{
          alert("移除失败");
          this.load();
        }
      })
    },
    submit(){
      this.$router.push("/result");
    }
  },
}
</script>

<style scoped>

</style>
