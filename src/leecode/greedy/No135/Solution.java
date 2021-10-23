package leecode.greedy.No135;

public class Solution {
    public int candy(int[] ratings) {
        //O(n) time|O(n) space
        int length = ratings.length;
        int candyNum=length;
        int[] candy=new int[length];
        for(int ele:candy)ele=1;
        //一次从左往右遍历，只调整右侧的值
        for(int i=1;i<length;i++){
            if(ratings[i]>ratings[i-1]&&candy[i]<=candy[i-1]){
                candyNum+=candy[i-1]-candy[i]+1;
                candy[i]=candy[i-1]+1;
            }
        }
        //一次从有往左遍，只调整左侧的值
        for(int i=length-1;i>0;i--){
            if(ratings[i-1]>ratings[i]&&candy[i-1]<=candy[i]){
                candyNum+=candy[i]-candy[i-1]+1;
                candy[i-1]=candy[i]+1;

            }
        }
        return candyNum;
    }

}
