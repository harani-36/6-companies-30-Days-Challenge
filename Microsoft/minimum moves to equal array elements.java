class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int m = nums[nums.length/2];
        int r=0;
        for(int n : nums){
            r+=Math.abs(n-m);
        }
        return r;
        
    }
}
