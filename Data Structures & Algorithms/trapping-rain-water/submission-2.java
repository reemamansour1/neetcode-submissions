class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
       int left = 0;
       int right = height.length - 1;
       int maxLeft = height[left];
       int maxRight = height[right];
       int area = 0;
       while(left < right){
        if(maxLeft < maxRight){
                left++;
                maxLeft = Math.max(maxLeft, height[left]);
                area += maxLeft - height[left];
            } else {
                right--;
                maxRight = Math.max(maxRight, height[right]);
                area += maxRight - height[right];
    
            }
        }
       return area;
    }
}
