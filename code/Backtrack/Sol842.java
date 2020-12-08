import java.util.ArrayList;
import java.util.List;

/**
 * @Description [842] 将数组拆分成斐波那契序列
 * https://leetcode-cn.com/problems/split-array-into-fibonacci-sequence/
 * @date 2020/12/8 0008-9:32
 */
public class Sol842 {
    public List<Integer> splitIntoFibonacci(String S){
        //TC:O(nlog(C^2)) C是整数范围2^31-1  SC:O(n)
        List<Integer> list=new ArrayList<>();
        backTrack(list,S,S.length(),0,0,0);
        return list;
    }

    public boolean backTrack(List<Integer> list,String S,int length,int index,int sum,int prev){
        if(index==length){
            return list.size()>=3;
        }
        long currLong=0;
        for (int i = index; i < length; i++) {
            if(i>index && S.charAt(index)=='0') break;
            currLong=currLong*10+S.charAt(i)-'0';
            if(currLong>Integer.MAX_VALUE) break;

            int curr=(int)currLong;
            if(list.size()>=2){
                if(curr<sum){
                    continue;
                }else if(curr>sum){
                    break;
                }
            }

            list.add(curr);
            if(backTrack(list,S,length,i+1,prev+curr,curr)){
                return true;
            }else{
                list.remove(list.size()-1);
            }
        }
        return false;
    }
}
