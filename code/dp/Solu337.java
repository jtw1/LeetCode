package LeetcodeTest;
// [337] 打家劫舍
// https://leetcode-cn.com/problems/house-robber-iii/
public class Solu337 {
    //dp TC:O(n)   SC:O(n)
    /**
     * 算法分析：构造一个长度为2的数组l[]， 
     * l[0]表示l节点不被选中时，l节点子树上被选择的节点的最大权值和，
     * l[1]表示l节点被选中时，l节点子树上被选择的节点的最大权值和
     * 所以·对每个结点·分两种情况·
     * 1) L被选中时，L的左右孩子节点都不能被选中，所以L[1]=L.value+L.left[0]+L.right[0];
     * 2) L不被选中时，L的左右孩子节点可以被选中，也可以不被选中，所以对L的某个子节点，它对L的贡献是该子节点被选中和不被选中时，权值和的最大值
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        int[] rootStatues = DFS(root);
        return Math.max(rootStatues[0], rootStatues[1]);
    }

    public int[] DFS(TreeNode root){
        if(root==null) return new int[]{0,0};

        int[] left = DFS(root.left);
        int[] right = DFS(root.left);
        
        //L被选中时，L的左右孩子节点都不能被选中，所以L[1]=L.value+L.left[0]+L.right[0];
        int selected = root.val+left[0]+right[0];
        //L不被选中时，L的左右孩子节点可以被选中，也可以不被选中，所以对L的某个子节点，它对L的贡献是该子节点被选中和不被选中时，权值和的最大值
        int NonSelected = Math.max(left[0], left[1])+Math.max(right[0], right[1]);

        return new int[]{NonSelected,selected};
    }


}