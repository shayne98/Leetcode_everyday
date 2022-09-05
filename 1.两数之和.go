/*
 * @lc app=leetcode.cn id=1 lang=golang
 *
 * [1] 两数之和
 */

// @lc code=start
func twoSum(nums []int, target int) []int {
	mp :=make(map[int]int)
	for i,num := range(nums){
		expect:= target-num
		j,ok := mp[expect]
		if ok{
			return []int{i,j}
		}
		mp[num]=i
	}
	return []int{}

}
// @lc code=end

