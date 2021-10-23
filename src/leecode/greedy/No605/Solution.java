package leecode.greedy.No605;

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for(int i=0;i<flowerbed.length;i++){
            if(flowerbed[i]==1){
                if(i-1>=0)flowerbed[i-1]=-1;
                if(i+1<flowerbed.length)flowerbed[i+1]=-1;
            }
        }
        for(int i=0;i<flowerbed.length;i++){
            if(flowerbed[i]==0){
                count++;
                if(i+1<flowerbed.length)flowerbed[i+1]=-1;
            }
        }
        return count>=n;

    }
}