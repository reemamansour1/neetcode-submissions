class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = (right-left)/2 + left;
            if(nums[mid] > nums[right]){
                left = mid + 1;
            }else{
                // now what? like what do i do if middle is not > than right?
                right = mid;
            }
        }
        return nums[left];
    }
}