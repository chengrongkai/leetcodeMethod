package code_1;

/**
 * @Author: 程荣凯
 * @Date: 2019/3/27 15:06
 * 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 */
public class Code1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3,2,4};
        int target = 6;
        int[] result = solution.twoSum(nums,target);
        for (int i = 0; i < result.length; i++) {
            int i1 = result[i];
            System.out.println(i1);
        }

    }
}
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        boolean flag = false;
        for(int i=0;i<nums.length;i++){
            int newTarget = target-nums[i];
            result[0] = i;
            for(int j = i+1;j<nums.length;j++){
                if(newTarget==nums[j]){
                    result[1] = j;
                    flag = true;
                    break;

                }
            }
            if(flag){
                break;
            }
        }
        return result;
    }
}