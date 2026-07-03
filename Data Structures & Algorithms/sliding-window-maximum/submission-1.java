class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // i wanna solve the brute force solution first
        int [] ks = new int[nums.length - k + 1];
        for(int i = 0; i<=nums.length-k; i++){
            int max = nums[i];
            for(int j = i; j < i+k; j++){
                if(nums[j] > max){
                    max = nums[j];
                }
              ks[i] = max;  
            }
            
        }
        return ks;
    }
}
