package leecode.math.No470;

/**
 * @author 小羊Shaun
 * @version 1.0
 * 470. Implement Rand10() Using Rand7()
 * ranM->ranN(N>M)
 * 首先生成1~M*M(此时M*M>=N)范围的随机数
 * 取最大的N的整数倍X，若生成的数res大于等于N重新生成
 * 可以证明这样生成的数概率为1/X
 * 若生成的数小于N，res%N即为生成的随机数
 */
/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */

//class Solution extends SolBase {
//
//    public int rand10() {
//       int res = 40;
//       while(res>=40){
//           res = 7*(rand7()-1)+rand7()-1;
//       }
//       return res%10+1;
//    }
//}