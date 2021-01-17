import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description [31] 下一个排列 （每日一题）
 * https://leetcode-cn.com/problems/next-permutation/
 * 题解：https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-suan-fa-xiang-jie-si-lu-tui-dao-/
 * @date 2020/11/10 0010-9:35
 */
public class So31 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入数组长度：");
//        int len = scanner.nextInt();
//        int[] nums=new int[len];
//        System.out.println("请输入数组元素：");
//        for (int i = 0; i < len; i++) {
//            nums[i]=scanner.nextInt();
//        }
        int[] nums=new int[]{1,3,2};
        nextPermutation(nums);
    }
    public static void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int length = nums.length;
        int index1 = length - 2;

        /*
            从 倒数第2个元素 开始，向前遍历：
                1、若当前元素 < 后面的元素(存在下一个更大的排列)：
                    1）找到大于当前元素的最后一个元素，记录其下标
                    2）交换选中的两个数组元素
                    3）转置后续的元素(保证 后续元素“升序排列”，即 当前排列表示的数“最小”)
                2、反之(不存在下一个更大的排列):
                    则 继续循环
            若未找到，则当前排列为最大排列，转置后返回即可
         */
        while (index1 >= 0) {
            if (nums[index1] < nums[index1 + 1]) {
                int index2 = length - 1;
                /*
                    在区间[index1+1,length-1]中从后往前找到大于当前元素的第一个元素
                 */
                while (index2 > index1 && nums[index2] <= nums[index1]) {
                    index2--;
                }
                exchange(nums, index1, index2);
                reverse(nums, index1 + 1, length - 1);
                return;
            }
            index1--;
        }
        reverse(nums, 0, length - 1);
    }

    /**
     * 将 指定数组，从 指定开始位置，到 指定结束位置，进行 原地转置
     * @param nums 指定数组
     * @param startIndex 指定开始位置
     * @param endIndex 指定结束位置
     */
    private static void reverse(int[] nums, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            exchange(nums, startIndex++, endIndex--);
        }
    }

    /**
     * 将 指定数组 的 指定下标的两个元素，进行 原地交换
     * @param nums 指定数组
     * @param index1 指定元素下标
     * @param index2 指定元素下标
     */
    private static void exchange(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
