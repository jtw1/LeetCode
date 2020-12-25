package GreedySelector;

import java.util.Arrays;

/**
 * @Description [455] 分发饼干
 * https://leetcode-cn.com/problems/assign-cookies/
 * @date 2020/12/25 0025-9:47
 */
public class Sol455 {
    public int findContentChildren(int[] g, int[] s){
        //TC:O(mlogm+nlogn)  SC(logn+logm)
        Arrays.sort(g);
        Arrays.sort(s);
        int count=0;
        int numOfChildren=g.length,numOfCookies=s.length;
        for(int i=0,j=0; i<numOfChildren && j<numOfCookies; i++,j++){
            while(j<numOfCookies && g[i]>s[j]){
                j++;
            }
            if(j<numOfCookies) count++;
        }
        return count;
    }
}
