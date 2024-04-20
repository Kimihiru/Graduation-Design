<template>
  <div id="score">
    <el-container style="height: 100%">
      <el-aside width="200px" style="background-color: rgb(238, 241, 246);height: 100%">
        <Aside></Aside>
      </el-aside>
      <el-container>
        <el-header style="text-align: right; font-size: 12px; border-bottom: 1px solid red; line-height:60px">
          <Header name="Admin"/>
        </el-header>
        <el-main>
          <div style="padding:10px">
            <el-input style="width:250px" suffix-icon="el-icon-search" placeholder="请输入名称搜索" v-model="name"></el-input>
            <el-button style="margin-left:5px" type="primary" @click="load">搜索</el-button>
          </div>
          <div style="margin:10px">
            <el-button type="primary" @click="hanleAdd">新增<i class="el-icon-circle-plus"></i></el-button>
          </div>
          <el-table :data="tableData">
            <el-table-column prop="id" label="id">
            </el-table-column>
            <el-table-column prop="name" label="景点名">
            </el-table-column>
            <el-table-column prop="score" label="综合评分">
            </el-table-column>
            <el-table-column fixed="right" label="操作">
              <template slot-scope="scope">
                <el-button type="success" size="small" icon="el-icon-edit" @click="handleEdit(scope.row)">编辑</el-button>
                <el-button type="danger" size="small"  icon="el-icon-delete" @click="deleteById(scope.row)">删除</el-button>
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
              <el-form-item label="景点名">
                <el-input v-model="form.name" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="综合评分">
                <el-input v-model="form.score" autocomplete="off"></el-input>
              </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
              <el-button type="primary" @click="insert">确定</el-button>
              <el-button @click="dialogFormVisible = false">取 消</el-button>
            </div>
          </el-dialog>

          <el-dialog title="景点信息" :visible.sync="dialogFormVisibleForDelete" width="30%">
            <el-form label-width="80px" size="small">
              <el-form-item label="id">
                <el-input v-model="form.id" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="景点名">
                <el-input v-model="form.name" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item label="综合评分">
                <el-input v-model="form.score" autocomplete="off"></el-input>
              </el-form-item>
            </el-form>
          </el-dialog>

        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import Aside from "./Aside";
import Header from "./Header";
import axios from "axios";
export default {
  name: "Score",
  components:{
    Aside,
    Header,
  },
  data() {
    return {
      tableData:[],
      total:0,
      pageNum:1,
      pageSize:5,
      id:"",
      name:"",
      score:"",
      dialogFormVisible:false,
      form:{},
      dialogFormVisibleForDelete:false
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
      fetch("http://localhost:8080/scorePage?pageNum="+this.pageNum
        +"&pageSize="+this.pageSize
        +"&name="+this.name+"").then(res=>res.json()).then(res=>{
        console.log(res)
        this.tableData=res.data
        this.total=res.total
        this.name=""
      })
    },
    hanleAdd(){
      this.dialogFormVisible = true;
      this.form={};
    },
    insert(){
      axios.post("/scoreSaveOrUpdate",this.form).then(res=>{
        if(res.data==true){
          alert("保存成功");
          this.dialogFormVisible=false;
          this.load();
        }
        else{
          alert("景点名已存在,保存失败");
        }
      })
    },
    handleEdit(row){
      console.log(row);
      this.form=row;
      this.dialogFormVisible=true;
    },
    deleteById(row){
      console.log(row);
      this.form=row;
      this.dialogFormVisibleForDelete=false;
      confirm("确定删除?");
      axios.post("/msgDelete",this.form).then(res=>{
        if(res.data==true){
          alert("删除成功");
          this.load();
        }
        else{
          alert("删除失败");
        }
      })
    }
  },
}
</script>

<style scoped>

</style>
