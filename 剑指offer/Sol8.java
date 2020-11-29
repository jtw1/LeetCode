/**
 * @Description 面试题8：二叉树的下一个节点 [剑指offer p65]
 * 题目：给定一棵二叉树和其中的一个结点，如何找出中序遍历顺序的下一个结点？
 * 树中的结点除了有两个分别指向左右子结点的指针以外，还有一个指向父结点的指针。
 * @date 2020/11/27 0027-10:39
 */
class BinaryTreeNode{
    public int val;
    public BinaryTreeNode left;
    public BinaryTreeNode right;
    public BinaryTreeNode parent;
    BinaryTreeNode() {}
    public BinaryTreeNode(int val) { this.val = val; }
    BinaryTreeNode(int val, BinaryTreeNode left, BinaryTreeNode right,BinaryTreeNode parent) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.parent=parent;
    }
}

public class Sol8 {
    public BinaryTreeNode getNext(BinaryTreeNode node){
        if(node==null) return null;
        BinaryTreeNode pNext=null;
        //如果一个节点有右子树，那么他的下一个节点就是右子树的最左子节点
        if(node.right!=null){
            BinaryTreeNode pRight=node.right;
            while(pRight.left!=null){
                pRight=pRight.left;
            }
            pNext=pRight;
        }
        /**
         * 如果一个节点没有右子树，分两种情况
         * 1：该节点是它父节点的左子节点，那么它的下一个节点就是他的父节点
         * 2：该节点是它父节点的右子节点，沿着父节点的指针向上遍历，直到找到一个是它父节点的左子节点的节点，
         *    如果存在这样的节点，那么这个节点的父节点即为要找的下一节点
         */
        else if(node.parent!=null){
            BinaryTreeNode pCurrent=node;
            BinaryTreeNode pParent=node.parent;
            while(pParent!=null && pCurrent==pParent.right){
                pCurrent=pParent;
                pParent=pParent.parent;
            }
            pNext=pParent;
        }
        return pNext;
    }

}
