import java.util.*;

/**
 * @Description [49] 字母异位词分组
 * https://leetcode-cn.com/problems/group-anagrams/
 * @date 2020/12/14 0014-9:39
 */
public class Sol49 {
    /**
     *法一 排序    TC:O(nklogk)   SC:O(nk)     n 是strs中的字符串的数量，k是strs中的字符串的的最大长度
     * 使用哈希表存储每一组字母异位词，哈希表的键为一组字母异位词的标志，哈希表的值为一组字母异位词列表。
     * 遍历每个字符串，对于每个字符串，得到该字符串所在的一组字母异位词的标志，将当前字符串加入该组字母异位词的列表中。
     * 遍历全部字符串之后，哈希表中的每个键值对即为一组字母异位词。
     */
    public List<List<String>> groupAnagrams(String[] strs){
        Map<String,List<String>> map=new HashMap<>();
        for(String str:strs){
            char[] array = str.toCharArray();
            //对每次取出的数组排序再作为键值
            Arrays.sort(array);
            String key=new String(array);
            List<String> list=map.getOrDefault(key, new ArrayList<String>());
            //哈希表的值为一组字母异位词列表。
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }


    /**
     *法二 计数    TC:O(n(k+26))   SC:O(n(k+26))     n 是strs中的字符串的数量，k是strs中的字符串的的最大长度
     *
     */
    public List<List<String>> groupAnagrams1(String[] strs){
        Map<String,List<String>> map=new HashMap<>();
        for(String str:strs){
            int[] counts=new int[26];
            for (int i = 0; i < str.length(); i++) {
                counts[str.charAt(i)-'a']++;
            }
            // 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if(counts[i]!=0){
                    sb.append(i+'a');
                    sb.append(counts[i]);
                }
            }

            String key=sb.toString();
            List<String> list=map.getOrDefault(key,new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

}
