package LeetCodeTest;
// [187] 重复的DNA序列
// https://leetcode-cn.com/problems/repeated-dna-sequences/description/

import java.util.ArrayList;
//import java.util.HashMap;
import java.util.HashSet;
//import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class Solu187 {
    public List<String> findRepeatedDnaSequences(String s) {
        // int len = s.length();
        // List<String> res = new ArrayList<>();
        // if(s==null || len<10) return res;

        // HashMap<String,Integer> map = new HashMap<>();
        // String str;
        // for (int i = 0; i <= len-11; i++) {
        //     str=((i < len-11)? s.substring(i, i+10):s.substring(i));

        //     if (!map.keySet().contains(str)) {
        //         map.put(str, 1);
        //     }else{
        //         map.put(str, map.get(s)+1);
        //     }
        // }
        // Iterator<String> iterator = map.keySet().iterator();
        // while (iterator.hasNext()) {
        //     str = (String)iterator.next();
        //     if(map.get(str)>1) res.add(str);
        // }
        // return res;


        //法二
        // int len = s.length();
        // Set<String> res = new HashSet<>();
        // Set<String> temp = new HashSet<>();

        // for (int i = 0; i <= len-10; i++) {
        //     String str = s.substring(i, i+10);

        //     if (!temp.contains(str)) {
        //         res.add(str);
        //     }else{
        //         temp.add(str);
        //     }
        // }

        // return new ArrayList<>(res);


        //法三，位运算，把字母映射到二进制位， A -> 00, C -> 01, G -> 10, T -> 11
        int len = s.length();
        if(s==null || len<10) return new ArrayList<>();

        Set<String> res = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        char[] map = new char[26];
        map['A'-'A']=0;
        map['C'-'A']=1;
        map['G'-'A']=2;
        map['T'-'A']=3;  //四种状态，每个字母用两位二进制数表示

        int key=0;
        char[] array = s.toCharArray();
        //单独把第一个10位的序列初始化,即第一个十位字母对应的二进制组合序列
        for (int i = 0; i < 10; i++) {
            key = key<<2 | map[array[i]-'A'];
        }
        set.add(key);

        for (int i = 10; i < len; i++) {
            //移动截取十个字母的窗口时，每次向右移动一位，对应二进制序列左移两位
            //二进制序列低位的两位再加上当前的字母对应
            //再截断为长度位20的二进制序列
            key = key<<2 | map[array[i]-'A'];
            key &= 0xfffff;  //int类型的数默认是32位的，这里每个十个字母对应的二进制组合序列长度是20，所以将其和（1111 1111 1111 1111 1111）即0xfffff,相与,就截断成20位的了

            if(set.contains(key)){
                res.add(s.substring(i-9,i+1));
            }else{
                set.add(key);
            }
        }

        return new ArrayList<>(res);
    }
}