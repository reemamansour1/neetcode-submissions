class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while(j > i){
            while(j > i && !Character.isLetterOrDigit(s.charAt(i))) i++; // skip left if non alph
            while(j > i && !Character.isLetterOrDigit(s.charAt(j))) j--; // skip right if non alphå
            
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
                return false;
            }
            i++;
            j--;
}
        return true;
    }
}
