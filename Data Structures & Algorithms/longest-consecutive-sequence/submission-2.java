class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        int current = 1; 
        int longest = 1;
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1]) continue;
            else if(nums[i] - nums[i-1] == 1){
                current++;
                longest = Math.max(current, longest);
            }else{
                current = 1;
                longest = Math.max(current, longest);
            }
        }
        return Math.max(current, longest);
    }
}
