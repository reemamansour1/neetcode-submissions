 class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int maxLen = 0;
        HashSet<Character> set = new HashSet<>();
        
        // why right < s.length() and not left < right?
        // because right is the "explorer" that scans every character
        // left < right is for TWO POINTERS (moving toward each other)
        // sliding window uses right < s.length() because both pointers move in the SAME direction
        while(right < s.length()){
            
            // why are we removing left and not right when duplicate found?
            // because the window [left, right] must stay CONTIGUOUS (a valid substring)
            // you can only add from right and remove from left to keep it contiguous
            // if you deleted from right you'd skip characters and break the substring
            
            // what if left is NOT the duplicate character?
            // that's ok! the while loop keeps removing from left until the duplicate is gone
            // it might take 1 removal or 5 removals — doesn't matter, it keeps shrinking
            // until s.charAt(right) is no longer in the set
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            
            // now s.charAt(right) is safe to add — no duplicates in window
            set.add(s.charAt(right));
            
            // why right - left + 1 and not length++?
            // length++ doesn't shrink when the window shrinks — gives wrong count
            // right - left + 1 directly calculates the ACTUAL current window size
            // why +1? because indices are 0-based:
            // left=0, right=2 → 3 characters → 2-0+1=3 ✅ (without +1 would be 2 ❌)
            maxLen = Math.max(maxLen, right - left + 1);
            
            right++; // expand window — move right forward
        }
        return maxLen;
    }
}