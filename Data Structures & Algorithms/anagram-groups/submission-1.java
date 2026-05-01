class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, ArrayList<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if(map.containsKey(sorted)){
                map.get(sorted).add(strs[i]);
            }else{
                // create the key
                ArrayList<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(sorted, list);
            }
        }
        result.addAll(map.values());
        return result;
    }
}
