class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        for(char c : s1.toCharArray()){
            map1.put(c, map1.getOrDefault(c,0) + 1);
        }
        HashMap<Character, Integer> map2 = new HashMap<>();

        // int right = s1.length() - 1; or
        int right = 0;
        int left = 0;
        while(right < s2.length()){
            char c = s2.charAt(right);
            map2.put(c, map2.getOrDefault(c,0) + 1);
            if(right - left + 1 == s1.length()){
                if(map1.equals(map2)) return true;
                char leftchar = s2.charAt(left);
                map2.put(leftchar, map2.get(leftchar) - 1);
                left++;
                if(map2.get(leftchar) == 0) map2.remove(leftchar);
            }
            right++;
        }
        return false;
    }
}
