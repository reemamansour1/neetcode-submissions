class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = numbers.length - 1;
        int j = 0;
        while(j < i){
            if(numbers[j] + numbers[i] > target){
                i--;
            } else if(numbers[j] + numbers[i] < target){
                j++;
            } else {
                return new int[]{j + 1, i + 1};
            }
        }
        return new int[]{-1, -1}; 
    }
}