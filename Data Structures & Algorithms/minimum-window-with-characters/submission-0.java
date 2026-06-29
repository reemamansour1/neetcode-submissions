class Solution {
    public String minWindow(String s, String t) {        
        // stores frequency of each character in t
        // tells us what we NEED in our window
        HashMap<Character, Integer> map = new HashMap<>();
        
        // stores frequency of each character in the CURRENT window
        // we compare this against map to check validity
        HashMap<Character, Integer> window = new HashMap<>();
        
        // build the t frequency map
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        // how many UNIQUE characters from t we need to satisfy
        // a character is satisfied when window count >= map count for that char
        // we never change this — it's our target
        int need = map.size();
        
        // counts how many unique characters from t are FULLY SATISFIED in the current window
        // a character is satisfied when its window count exactly reaches its t count
        // when have == need, the window contains everything t requires → valid window
        int have = 0;
        
        // left boundary of the sliding window
        // right is our for loop variable — expands every iteration
        // left only moves when we shrink the window
        int left = 0;
        
        // stores the [left, right] indices of the best (smallest) valid window found so far
        // initialized to {-1, -1} meaning "no valid window found yet"
        // at the end: if result[0] == -1 → return "", else return s.substring(result[0], result[1]+1)
        int[] result = {-1, -1};
        
        // tracks the LENGTH of the best window found so far
        // used to compare against new valid windows to decide if we update result
        // initialized to MAX_VALUE so any valid window will be smaller
        int resultLen = Integer.MAX_VALUE;
        
        // right pointer — expands the window one character at a time
        int right = 0;
        
        while(right < s.length()){
            // step 1: add s[right] to window
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            
            // step 2: check if this character just became satisfied
            // only increment have when count exactly hits the target (not when it exceeds it)
            // map.containsKey(c) ensures we only care about characters that are in t
            if(map.containsKey(c) && window.get(c).equals(map.get(c))){
                have++;
            }
            
            // step 3: shrink from left while window is valid (have == need)
            // every time we enter this loop, the window is valid
            // we try to make it as small as possible before it breaks
            while(have == need){
                // update result if current window is smaller than best so far
                if(right - left + 1 < resultLen){
                    resultLen = right - left + 1;
                    result[0] = left;
                    result[1] = right;
                }
                // remove leftmost character from window
                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);
                // if removing this character breaks satisfaction → have--
                // meaning window count dropped BELOW t's required count
                if(map.containsKey(leftChar) && window.get(leftChar) < map.get(leftChar)){
                    have--;
                }
                left++;
            }
            
            // step 4: expand right
            right++;
        }
        
        // if no valid window was found, return ""
        // otherwise return the substring from result[0] to result[1] inclusive
        return result[0] == -1 ? "" : s.substring(result[0], result[1] + 1);
    }
}
