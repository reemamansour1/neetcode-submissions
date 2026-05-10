class Solution {
    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i<strs.size(); i++){
            String s = strs.get(i);
            res.append(s.length());
            res.append("#");
            res.append(s);
        }
        return res.toString();
    }
    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while(i < str.length()){
            int j = i;
            while(str.charAt(j) != '#'){
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            String word = str.substring(j + 1, j + 1 + length);
            res.add(word);
            i = j + 1 + length;
        }
        return res;
    }
}