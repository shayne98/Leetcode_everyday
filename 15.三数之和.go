/*
 * @lc app=leetcode.cn id=15 lang=golang
 *
 * [15] 三数之和
 */

// @lc code=start
func threeSum(nums []int) [][]int {
	res:= [][]int{}
	sort.Ints(nums)
	// prea:=nums[0]-1
	// preb:=nums[0]-1
	n:= len(nums)
	// mp :=make(map[int]bool)
	for i,_:=range(nums){
		if i>0&&nums[i]==nums[i-1]{
			continue
		}
		j,k:=i+1,n-1
		for j<k {
			for j>i+1&&j<k&&nums[j]==nums[j-1]{
				j++
			}
			if j>=k{
				break
			}
			sum:= nums[i]+nums[j]+nums[k]
			if sum==0{
				res = append(res,[]int{nums[i],nums[j],nums[k]})
				j++
			}else if sum>0{
				k--
			}else{
				j++
			}
		}
	}
	return res


}
// @lc code=end

