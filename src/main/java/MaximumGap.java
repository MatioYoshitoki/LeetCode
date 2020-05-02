import java.util.Arrays;

class Solution10 {
    public int maximumGap(int[] nums) {
        if (nums.length==2){
            return Math.abs(nums[0]-nums[1]);
        }
        int result = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            result = Math.max(Math.abs(nums[i]-nums[i+1]), result);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution10().maximumGap(new int[]{3,6,9,1}));
    }
}