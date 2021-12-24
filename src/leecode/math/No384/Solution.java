package leecode.math.No384;

import java.util.Arrays;
import java.util.Random;

/**
 * @author 小羊Shaun
 * @version 1.0
 * 384. Shuffle an Array
 * 洗牌算法，总共n张牌，假设前i张已经洗好，从前i张里抽取一张和第i+1张进行交换，就是实现了完全随机
 */
class Solution {
    int[] origin;
    int m =0;
    Random random;

    public Solution(int[] nums) {
        origin = Arrays.copyOf(nums,nums.length);
        random = new Random();
    }

    public int[] reset() {
        return origin;

    }

    public int[] shuffle() {
        if(origin == null) return null;
        int[] shuffled = Arrays.copyOf(origin,origin.length);
        for(int i=1;i<shuffled.length;i++){
            int temp = shuffled[i];
            int index = random.nextInt(i+1);
            shuffled[i] = shuffled[index];
            shuffled[index] = temp;
        }
        return shuffled;

    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */