package simple;

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
//        int[] result = solution.twoSum(nums,target);
        int[] result = solution.twoSumBest(nums,target);
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

    /**
     * 核心思想：用额外的数组extra存储当前循环中的数据，每次遍历数据时，比较其和目标值的差值并在extra中进行查找，巧妙的利用值作为下标，类似于hash查找
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumBest(int[] nums, int target) {
        int indexArrayMax = 2047;
        int[] indexArrays = new int[indexArrayMax + 1];
        for (int i = 0; i < nums.length; i++) {
            //获取差值
            int diff = target - nums[i];
            //避免负数
            int index = diff & indexArrayMax;
            //查看indexArray数组中是否以存储了这个值，如果存储了，则说明找到了可以累加得到target的值
            if (indexArrays[index] != 0) {
                return new int[] { indexArrays[index] - 1, i };
            }
            //将nums[i]作为下标存储i+1的值
            indexArrays[nums[i] & indexArrayMax] = i + 1;
        }
        throw new IllegalArgumentException("No two sum value");
    }
}