import java.util.ArrayList;
import java.util.List;

/**
 * @Description 448 找到所有数组中消失的数字
 *
 * @date 2021/3/14-13:20
 */
public class Sol448 {
    /**
     * TC:O(n)  SC:O(1)
     * 数组元素是i是1~n，对应索引是(i-1)%n,将数组元素对应为索引的位置加n
     * 遍历加n后的数组，当前遍历的下标为i，若数组元素值小于等于n，说明之前没有加过n,即i+1没有出现过
     * 说明则说明数组下标值不存在，即消失的数字
     */
    public List<Integer> findDisappearedNumbers(int[] nums){
        List<Integer> ret = new ArrayList<>();
        if(nums==null || nums.length==0) return ret;
        int len=nums.length;
        for(int num :nums){
            // 这里对len求余的原因是防止之前已经加过一次的情况造成下标越界
            int x=(num-1)%len;
            nums[x] += len;
        }

        for (int i = 0; i < len; i++) {
            if (nums[i]<=len){
                ret.add(i+1);
            }
        }
        return ret;
    }
}
