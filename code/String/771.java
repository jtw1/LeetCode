//771 宝石与石头
//https://leetcode-cn.com/problems/jewels-and-stones/
class Solution {
    public int numJewelsInStones(String J, String S) {
        if(S==null || S.length()==0) return 0;
        int jewelsCount=0;
        HashSet<Character> jewelsMap = new HashSet<>();
        for(int i=0;i<J.length();i++){
            jewelsMap.add(J.charAt(i));
        }
        for (int i = 0; i < S.length(); i++) {
            char stone = S.charAt(i);
            if (jewelsMap.contains(stone)) {
                jewelsCount++;
            }
        }
        return jewelsCount;
    }
}
