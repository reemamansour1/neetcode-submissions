class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        char [] ss = s.toCharArray();
        char [] ts = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(ts);
        if(String.valueOf(ss).equals(String.valueOf(ts))) return true;
        return false;
    }
}
