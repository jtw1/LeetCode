import java.util.Stack;

/**
 * @Description 33 二叉搜索树的后序遍历序列 p179
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 * @date 2021/1/18 0018-21:06
 */
public class Sol33 {
    public boolean verifyPostorder(int[] postorder) {
        if(postorder==null || postorder.length==0) return true;
        return recur(postorder,0,postorder.length-1);
    }
    public boolean recur(int[] postorder,int left,int right) {
        //如果left==right，就一个节点不需要判断了，如果left>right说明没有节点，
        //也不用再看了,否则就要继续往下判断
        if (left >= right)
            return true;
        //因为数组中最后一个值postorder[right]是根节点，这里从左往右找出第一个比
        //根节点大的值，他后面的都是根节点的右子节点（包含当前值，不包含最后一个值，
        //因为最后一个是根节点），他前面的都是根节点的左子节点
        int mid = left;
        int root = postorder[right];
        while (postorder[mid] < root)
            mid++;
        int temp = mid;
        //因为postorder[mid]前面的值都是比根节点root小的，
        //我们还需要确定postorder[mid]后面的值都要比根节点root大，
        //如果后面有比根节点小的直接返回false
        while (temp < right) {
            if (postorder[temp++] < root)
                return false;
        }
        //然后对左右子节点进行递归调用
        return recur(postorder, left, mid - 1) && recur(postorder, mid, right - 1);
    }
    //法二：辅助栈
    // https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/solution/di-gui-he-zhan-liang-chong-fang-shi-jie-jue-zui-ha/
    public boolean verifyPostorder1(int[] postorder){
        if(postorder==null || postorder.length==0) return true;
        Stack<Integer> stack=new Stack<>();
        int root=Integer.MAX_VALUE;
        for (int i = postorder.length-1; i >= 0; i--) {
            /**
             * root并不一定都是父节点的值，相对于遇到了左子节点的时候他是左子节点的父节点。
             * 如果是右子节点，root就是他的某一个祖先节点，并且这个右子节点是这个祖先节点的一个左子树的一部分，所以不能超过他
             */
            if(postorder[i]>root) return false;
            while(!stack.isEmpty() && stack.peek()>postorder[i]){
                root=stack.pop();
            }
            stack.add(postorder[i]);
        }
        return true;
    }
}
