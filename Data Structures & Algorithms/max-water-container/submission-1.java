class Solution {
    public int maxArea(int[] heights) {
        // i feel the container with most water would be the greatest on area
        // area = h * w
        // we need a var called area
        // and we need a var called max area, that is what we are returning
        // 7  at index 1 : (7-2) * 2
        // 7 and 6 : ()* 6 = 36
        // i cannot figure out the formula
        // then two pointers one at the beginning and one at the end
        // then keep looking up until finding the max area
        int max = 0;
        int left = 0;
        int right = heights.length - 1;
        
           // now i got stuck, do i need a while loop inside the for loop
           // or do i only need a while loop for the pointers
           // how could i determine that? 
        
        while(left < right){
            int h = Math.min(heights[left], heights[right]);
            int w = right - left;
            int area = h*w;
            max = Math.max(area, max);
            // idk which one to move but i feel the right
            if(heights[left] < heights[right]){
                left++;
            } else if(heights[right] < heights[left]){
                right--;
            }else{
                right--;
                left++;
            }
           
        }
        return max;

    }
}
