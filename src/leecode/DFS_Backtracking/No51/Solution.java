package leecode.BFS_DFS.No51;

import java.util.*;

/**
 * @author 小羊Shaun
 * @version 1.0
 */
@SuppressWarnings("all")
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solveNQueens(4));
    }
    //用四个boolean数组表示横向，纵向和两个斜向的占位情况
    //斜线方向的区分用与y轴截距来表示
    boolean[] hori ;
    boolean[] slash ;
    boolean[] bslash ;
    String ndot;
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        hori = new boolean[n];
        slash = new boolean[2*n];
        bslash = new boolean[2*n];
        LinkedList temp = new LinkedList();
        for(int j=0;j<n;j++){
            DFS(0,j,n,temp);
        }
        return ans;

    }
    void DFS(int i, int j, int n, LinkedList temp){
//        StringBuffer str = new StringBuffer(ndot);
//        str.setCharAt(j,'Q');
//        temp.add(str);

        char[] ndot = new char[n];
        Arrays.fill(ndot,'.');
        ndot[j]='Q';
        //数组转化为String连在temp后面
        temp.addLast(String.copyValueOf(ndot));
        hori[j] = true;
        slash[i-j+n-1]=true;
        bslash[i+j]=true;
        //满足条件将该种解法放入ans
        if(i==n-1) ans.add(new ArrayList(temp));
        else{
            for(int k=0;k<n;k++){
                if(hori[k]==false&&slash[i+1-k+n-1]==false&&bslash[i+1+k]==false)DFS(i+1,k,n,temp);
            }        }
       temp.pollLast();//去掉最后一个加入的元素
        hori[j] = false;
        slash[i-j+n-1]=false;
        bslash[i+j]=false;
        return;


    }


}