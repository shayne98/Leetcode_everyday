package leecode.greedy.No406;

import org.omg.CORBA.PERSIST_STORE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author 小羊Shaun
 * @version 1.0
 */
@SuppressWarnings("all")
////O(n^2) time|O(1) space
//class Solution {
//    public int[][] reconstructQueue(int[][] people) {
//        //先根据身高排序，从高到低
//        Arrays.sort(people, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if(o2[0]-o1[0]!=0)return o2[0]-o1[0];
//                else return o1[1]-o2[1];
//            }
//        });
//        //此时序号i代表前面比他高的人数，若大于比他高的人数说明需要把它往前插入
//        //记数组的后一个元素是tallerNum,插入到它前面i-tallNum的元素前面
//        int i,j;
//        for(i=0;i<people.length;i++){
//            int tallerNum = people[i][1];
//            int height = people[i][0];
//            int forwardNum = i>tallerNum?i-tallerNum:0;
//            //暂时存储需要插入的数组
//            int[] tem = new int[]{height,tallerNum};
//            //插入后的元素直到原来位置前的元素往后移动一位
//            for(j=i;j>i-forwardNum;j--){
//                people[j] = people[j-1];
//            }
//            people[j]=tem;
//        }
//        return people;
//
//    }
//}
class Solution {
    public int[][] reconstructQueue(int[][] people) {

        // greedy heap solution!

        Arrays.sort(people, (a,b)->(a[0] != b[0] ? b[0]-a[0] : a[1] - b[1])); // put tallest people first, otherwise sort by their people greater (so that the tallest are in order)

        List<int[]> res = new ArrayList<>();

        // let's now add them in the sorted order, at the specific index
        // add the tallest first, then put the next level in with the appropriate amount of people on and so on -- arraylist let's us put the person in at the proper index
        for (int[] p : people) {
            res.add(p[1], p);
        }

        // convert to an array
        return res.toArray(new int[people.length][2]);
    }
}