class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        // we said we need to multiply to what to left of the element and what is the right of it together
        // is that how we get the prefix array? 
        int product = 1;
        for(int i = 0; i<nums.length; i++){
            result[i] = product;
            product *= nums[i];
        }
        int [] suffix = new int[nums.length];
        product = 1;
        for(int i = nums.length - 1; i>=0; i--){
            suffix[i] = product;
            product *= nums[i];
            result[i] *= suffix[i];
        }
        return result;

    } 
}  
