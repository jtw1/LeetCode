import java.util.Arrays;

/**
 * @Description 45 把数组排成最小的数
 * https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/solution/mian-shi-ti-45-ba-shu-zu-pai-cheng-zui-xiao-de-s-4/
 * @date 2021/1/27-20:28
 */
public class Sol45 {
    public String minNumber(int[] nums){
        //TC:O(nlogn) SC:O(n)
        if(nums==null || nums.length==0) return null;
        String[] str=new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i]=String.valueOf(nums[i]);
        }
        // 按拼接后的从小到大排列 例如 x: “3” y: “30”
        // “330”>"303", 所以x>y,y排在x前面
        Arrays.sort(str,(x,y)->(x+y).compareTo(y+x));
        StringBuilder res=new StringBuilder();
        for(String s:str){
            res.append(s);
        }
        return res.toString();
    }
}
