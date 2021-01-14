/**
 * @Description 26 树的子结构 p151
 * https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 * 题解：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/solution/mian-shi-ti-26-shu-de-zi-jie-gou-xian-xu-bian-li-p/
 * https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/solution/di-gui-fang-shi-jie-jue-by-sdwwld/
 * @date 2021/1/14 0014-15:39
 */
public class Sol26 {
    //A的节点数M，B的节点数N    TC:O(MN)  SC:O(M)
    //遍历树A的每一个节点a
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        // 先从根节点判断B是不是A的子结构，如果不是在分别从左右两个子树判断，
        // 只要有一个为true，就说明B是A的子结构
        return (A!=null && B!=null) &&
               (recur(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B));
    }
    //判断A中以a为根节点的子树是否包含树B
    private boolean recur(TreeNode A, TreeNode B){
        /**
         * 当节点 B 为空：说明树 B 已匹配完成（越过叶子节点），因此返回 true ；
         * 当节点 A 为空：说明已经越过树 A 叶子节点，即匹配失败，返回 false ；
         * 当节点 A 和 B 的值不同：说明匹配失败，返回 false ；
         */
        if(B==null) return true;
        if(A==null || A.val!=B.val) return false;
        return recur(A.left,B.left) && recur(A.right,B.right);
    }
}
