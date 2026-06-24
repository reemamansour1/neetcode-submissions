class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int answer = 0;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c,0) + 1);
            max = Math.max(max, map.get(c));
            while((r - left + 1) - max > k){
                // what to do here? this if condition means that the window is valid
                char cl = s.charAt(left);
                map.put(cl, map.get(cl) - 1);
                left++;
                
            }
            answer = Math.max(answer, r - left + 1);
            // why the max is r - left + 1
            // how are we keeping in head the replacements?
        }
         return answer;
    }
}
