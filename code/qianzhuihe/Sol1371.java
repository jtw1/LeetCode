package qianzhuihe;

import java.util.Arrays;

/**
 * @Description
 * @date 2021/5/20 0020-17:38
 */
public class Sol1371 {
    public int findTheLongestSubstring(String s){
        int len=s.length();
        int[] pos=new int[32];
        Arrays.fill(pos,-1);
        int status=0;
        int ans=0;
        pos[0]=0;
        for (int i = 0; i < len; i++) {
            char c=s.charAt(i);
            if (c=='a'){
                status ^= (1<<0);
            }else if (c=='e'){
                status ^= (1<<1);
            }else if (c=='i'){
                status ^= (1<<2);
            }else if (c=='o'){
                status ^= (1<<3);
            }else if (c=='u'){
                status ^= (1<<4);
            }

            if (pos[status]>=0){
                ans=Math.max(ans,i+1-pos[status]);
            }else{
                pos[status]=i+1;
            }
        }
        return ans;
    }
}
