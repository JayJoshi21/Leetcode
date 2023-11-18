class Solution {
    public int maxFrequency(int[] nums, int k) {
        int left =0, right=0, ans=0;
        Arrays.sort(nums);
        long sum = nums[0];
        while(right < nums.length){
            if((right-left+1)*nums[right]<=k+sum){
                ans = Math.max(ans, right-left+1);
                right++;
                if(right<nums.length) sum+=nums[right];
            }
            else{
                sum-=nums[left];
                left++;
            }
        }
        return ans;
        
    }
}