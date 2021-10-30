package leecode;


import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.swing.plaf.PanelUI;
import java.security.PublicKey;
import java.util.*;

@SuppressWarnings("all")
class Solution {
    boolean[] row,column,slash,r_slash;
    List<List<String>> ans=new ArrayList<>();
    LinkedList<String> temp = new LinkedList<>();
    public List<List<String>> solveNQueens(int n) {
        row = new boolean[n];
        column = new boolean[n];
        slash = new boolean[n*2];
        r_slash = new boolean[n*2];
        for(int j=0;j<n;j++){
            DFS_Back(0,j,n);
        }
        return ans;
    }
    public void DFS_Back(int i,int j,int n){
        column[j]=true;
        slash[j-i+n-1]=true;
        r_slash[j+i]=true;
        char[] ndot = new char[n];
        Arrays.fill(ndot,'.');
        ndot[j]='Q';
        temp.addLast(String.copyValueOf(ndot));
        if(i==n-1){
            ans.add(new ArrayList<>(temp));
        }
        else{
            for(int k=0;k<n;k++){
                if(column[k]||slash[k-i+n-2]||r_slash[k+i+1])continue;
                DFS_Back(i+1,k,n);
            }
        }
        column[j]=false;
        slash[j-i+n-1]=false;
        r_slash[j+i]=false;
        temp.pollLast();
    }
}