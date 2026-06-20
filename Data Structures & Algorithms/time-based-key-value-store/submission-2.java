class TimeMap {
    Map<String, List<String[]>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new String[]{value, String.valueOf(timestamp)});
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        int left = 0; 
        int size = map.get(key).size();
        int right = size - 1;
        List<String[]> list = map.get(key);
        int i = -1;
        // when do i do left < right or left <= right in bs?
        while(left <= right){
            int mid = (right+left)/2;
            if(Integer.parseInt(list.get(mid)[1]) <= timestamp){
                i = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        if(i == -1) return "";
        return map.get(key).get(i)[0];
    }
}
