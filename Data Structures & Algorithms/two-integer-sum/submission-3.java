class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){

            // we used the fact that if there is sub,then it means we found those two numbers.
            int sub = target - nums[i];
            // 7 - 3 = 4; 

            // does 4 exist in the map

            // if so, return new int[]{map.get(sub), i}


            if(map.containsKey(sub)){
                return new int[] {map.get(sub), i};
            }else{
                map.put(nums[i], i);
            }
        }
        return new int[]{0,0};
        
    }
}
