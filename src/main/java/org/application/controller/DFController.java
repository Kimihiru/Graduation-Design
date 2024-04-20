package org.application.controller;

import org.application.entity.Cart;
import org.application.service.CartService;
import org.application.service.DistanceService;
import org.application.service.FeeService;
import org.application.service.MatrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author Sakura
 * 计算最短路径以及最少花费费用
 */
@RestController
public class DFController {
    @Autowired
    public MatrixService matrixService;
    @Autowired
    public DistanceService distanceService;
    @Autowired
    public FeeService feeService;
    @Autowired
    public CartService cartService;
    //图G的顶点数
    public static int n;
    //当前解路径
    public static int[] x;
    //最优解路径
    public static int[] bestx;
    //图G的邻接矩阵
    public static int[][] a;
    //当前路径x[1:i]的费用
    public static int cc;
    //最优解费用
    public static int bestc;
    //无边标记、最大值
    public static int NoEdge = 20;

    // 回溯算法
    public static void backTrack(int i){
        if (i == n) {
            // 若点n-1和点n有连线且点1和n有连线且比最优路径短
            if (a[x[n-1]][x[n]] != NoEdge && a[x[n]][1] != NoEdge
                    && (cc + a[x[n - 1]][n] + a[x[n]][1] < bestc || bestc == NoEdge)) {
                for (int j = 1; j <= n; j++) {
                    // 将最优路径保存进bestx
                    bestx[j] = x[j];
                }
                // 最优值
                bestc = cc + a[x[n - 1]][x[n]] + a[x[n]][1];
            }
            return;
        }
        for (int j = i; j <= n; j++) {
            // 点i-1和点j是否存在路径且比最优路径短
            if (a[x[i - 1]][x[j]] != NoEdge && (cc + a[x[i - 1]][x[j]] < bestc || bestc == NoEdge)) {
                // 搜索子树
                swap(x, i, j);
                cc += a[x[i - 1]][x[i]];
                backTrack(i+1);
                cc -= a[x[i - 1]][x[i]];
                swap(x, i, j);
            }
        }
    }

    public static void swap(int[] x, int i, int j){
        int temp = x[i];
        x[i] = x[j];
        x[j] = temp;
    }

    public static int tsp(int[] v){
        x = new int[n + 1];
        // 初始化
        for (int i = 1; i <= n; i++) {
            x[i] = i;
        }
        // 初始化设置最少花费为最大值
        bestc = NoEdge;
        // 最优路径为v
        bestx = v;
        // 当前花费为0
        cc = 0;
        // 从1开始搜索，搜索x[1:n]的全排列
        backTrack(1);
        return Math.min(bestc, 20);
    }

    @GetMapping(value = "/df")
    public Map<String,Object> df(){
        List<Cart> cartList=cartService.queryAll();
        n=cartList.size();
        List<Cart> areaCopy=new ArrayList<>();
        areaCopy.add(null);
        for (int i=0;i<n;i++){
            areaCopy.add(cartList.get(i));
        }
        a=new int[n+1][n+1];
        a[0][0]=0;
        for (int i=1;i<=n;i++){
            a[i][0]=0;
        }
        for (int j=0;j<=n;j++){
            a[0][j]=0;
        }
        for (int i=1;i<=n;i++){
            String area=areaCopy.get(i).getArea();
            for (int j=1;j<=n;j++){
                if ("番禺".equals(area)){
                    a[i][j]=feeService.panyu(areaCopy.get(j).getArea());
                }
                if("南沙".equals(area)){
                    a[i][j]=feeService.nansha(areaCopy.get(j).getArea());
                }
                if("荔湾".equals(area)){
                    a[i][j]=feeService.liwan(areaCopy.get(j).getArea());
                }
                if("越秀".equals(area)){
                    a[i][j]=feeService.yuexiu(areaCopy.get(j).getArea());
                }
                if("海珠".equals(area)){
                    a[i][j]=feeService.haizhu(areaCopy.get(j).getArea());
                }
                if("天河".equals(area)){
                    a[i][j]=feeService.tianhe(areaCopy.get(j).getArea());
                }
                if("白云".equals(area)){
                    a[i][j]=feeService.baiyun(areaCopy.get(j).getArea());
                }
                if("黄埔".equals(area)){
                    a[i][j]=feeService.huangpu(areaCopy.get(j).getArea());
                }
                if("花都".equals(area)){
                    a[i][j]=feeService.huadu(areaCopy.get(j).getArea());
                }
                if("增城".equals(area)){
                    a[i][j]=feeService.zengcheng(areaCopy.get(j).getArea());
                }
                if("从化".equals(area)){
                    a[i][j]=feeService.conghua(areaCopy.get(j).getArea());
                }
            }
        }
        int[] v = new int[n+1];
        int fee = tsp(v);
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if(i==n){
                stringBuilder.append(areaCopy.get(bestx[i]).getName()).append("->").append(areaCopy.get(bestx[1]).getName());
            }
            else{
                stringBuilder.append(areaCopy.get(bestx[i]).getName()).append("->");
            }
        }
        String path=stringBuilder.toString();
        Map<String,Object> map=new HashMap<>();
        map.put("path",path);
        map.put("fee",fee);
        return map;
    }
}