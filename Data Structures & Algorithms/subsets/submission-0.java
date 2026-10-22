class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // an empty set is a valid set
        res.add(new ArrayList<>());
        for(int num : nums){
            int size = res.size();
            for(int i = 0; i < size; i++){
                // why did we pass res.get(i)?
                List<Integer> subset = new ArrayList<>(res.get(i));
                subset.add(num);
                res.add(subset);
            }
        }
        return res;
    }

}
