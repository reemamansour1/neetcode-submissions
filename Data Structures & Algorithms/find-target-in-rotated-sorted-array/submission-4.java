class Solution {
    public int search(int[] nums, int target) {
        int right = nums.length - 1;
        int left = 0;
        while(left<right){
            int mid = (right+left)/2;
            if(nums[mid] > nums[right]){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        // is there a reason why p = left?
        // like why did we assign p to left?
        // is it cuz the minimum is pivot which is left? and why?
        int p = right;
        int result = bs(nums, target, 0, p-1);
        if(result != -1){
            return result;
        }
        return bs(nums,target, p, nums.length-1);
    }
    public int bs(int[] nums , int target, int left, int right){
        while(left <= right){
            int mid = (left+right)/2;
            if(nums[mid] == target){
                return mid;
            }else if(target > nums[mid]){
                left = mid+1;
            }else{
                right = mid -1;
            }
        }
        return -1;
    }
}
