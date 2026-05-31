class Solution {
    public int longestConsecutive(int[] nums) {
    if(nums.length == 0) return 0;
    int max = 1;
    HashSet<Integer> hs = new HashSet<>();
       for(int n : nums){
        hs.add(n);
       }
       for(int i = 0; i < nums.length; i++){
            if(hs.contains(nums[i] - 1)) continue; // not a start, skip
            // it IS a start, count the sequence
            int length = 1;
            while(hs.contains(nums[i] + length)){
                length++;
            }
            max = Math.max(max, length);
        }
return max;
}
}