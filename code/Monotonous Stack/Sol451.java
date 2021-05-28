import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 451. 根据字符出现频率排序
 * @date 2021/5/28 0028-10:20
 */
public class Sol451 {
    // 桶排序   TC:O(n)  SC:O(n)
    public String frequencySort(String s) {
        if(s==null || s.length()==0) return s;
        Map<Character,Integer> map=new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        List<Character>[] list=new List[s.length()+1];
        for(Character key:map.keySet()){
            int i=map.get(key);
            if(list[i]==null){
                list[i]=new ArrayList<>();
            }
            list[i].add(key);
        }

        StringBuilder res=new StringBuilder();
        for(int i=list.length-1;i>=0;i--){
            if(list[i]==null) continue;

            for(char c:list[i]){
                for(int j=0;j<i;j++){
                    res.append(c);
                }
            }
        }
        return res.toString();
    }
}
