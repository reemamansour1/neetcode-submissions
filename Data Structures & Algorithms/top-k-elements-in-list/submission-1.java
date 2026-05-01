class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int [] result = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        // i cannot just sort the values of the map keys
        // i need to put them in a list
        // sort this list
        // map through the map keys and return the one with the highest key 
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a,b) -> map.get(b) - map.get(a));
        for(int i = 0; i< k; i++){
            result[i] = list.get(i);
        }
        return result;

    }
}
