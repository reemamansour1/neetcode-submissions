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
        // ok it does not matter, p could be left or right it will 
        // give the same answer because the while loop stops when they are equal

        int p = right;
        // check 2nd half
        int result = bs(nums, target,  p, nums.length - 1);
        if(result != -1){
            return result;
        }

        // check 1st half
        return bs(nums,target, 0, p-1);
        // also it deos not matter which half to check first
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
