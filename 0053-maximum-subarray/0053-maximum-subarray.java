class Solution {
    public int maxSubArray(int[] nums) {
        int maxsum = nums[0];
        int currentSum = nums[0];
        for(int i=1; i < nums.length; i++){
            currentSum = Math.max(nums[i] , currentSum + nums[i]);
            maxsum = Math.max(maxsum , currentSum);
          
        }
        return maxsum;
    }
}