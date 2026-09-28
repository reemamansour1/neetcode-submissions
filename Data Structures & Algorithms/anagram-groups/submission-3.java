class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // result
       List<List<String>> res = new ArrayList<>();
       
       Map<String, List<String>> map = new HashMap<>();
       for(String s : strs){
        char[] c = s.toCharArray();
        Arrays.sort(c);
        String k = String.valueOf(c);
        // what am i putting in the value here? initally it will be an empty list/
        if(!map.containsKey(k)){
            map.put(k, new ArrayList<>());
            // so we should add this s?
            map.get(k).add(s);
             
        }
        else{
            // how would i add the current value?
            // u already did
            map.get(k).add(s);
        }

       }
       for(List<String> s : map.values()){
        res.add(s);
       }

       return res;
       
    }
}
