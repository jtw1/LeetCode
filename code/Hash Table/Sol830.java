import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description [830] 较大分组的位置 day
 * https://leetcode-cn.com/problems/positions-of-large-groups/
 * @date 2021/1/5 0005-11:25
 */
public class Sol830 {
    //TC:O(n) SC:O(1)
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ret = new ArrayList<>();
        int n = s.length();
        int num = 1;
        for (int i = 0; i < n; i++) {
            if (i == n - 1 || s.charAt(i) != s.charAt(i + 1)) {
                if (num >= 3) {
                    ret.add(Arrays.asList(i - num + 1, i));
                }
                num = 1;
            } else {
                num++;
            }
        }
        return ret;
    }
}
