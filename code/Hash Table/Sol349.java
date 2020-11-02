import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * @date 2020/11/2 0002-9:42
 */
public class Sol349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        //TC:O(m+n)  SC:O(m+n)
        Set<Integer> set1=new HashSet<>();
        Set<Integer> set2=new HashSet<>();
        for(int num:nums1){
            set1.add(num);
        }
        for(int num:nums2){
            set2.add(num);
        }
        return getIntersection(set1,set2);
    }

    public int[] getIntersection(Set<Integer> set1, Set<Integer> set2){
        if(set1.size()>set2.size()) return getIntersection(set2,set1);
        Set<Integer> commonSet=new HashSet<>();
        for(int num:set1){
            if(set2.contains(num)){
                commonSet.add(num);
            }
        }

        int[] res=new int[commonSet.size()];
        int index=0;
        for(int num:commonSet){
            res[index++]=num;
        }
        return res;
    }
}
