/*
// [116] 填充每个结点的下一个右侧节点
// https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null) return root;
        
        //法一 层次遍历
        //TC:O(n)   SC:O(n)

        // 初始化队列同时将第一层节点加入队列中，即根节点
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        // 外层的 while 循环迭代的是层数
        while(!queue.isEmpty()){
            // 记录当前队列大小
            int size = queue.size();
            // 遍历这一层的所有节点
            for(int i=0;i<size;i++){
                // 从队首取出元素,poll方法：移除并返回队列头部元素
                Node node = queue.poll();
                // 连接
                if(i<size-1){
                    //peek()：返回队列头部元素
                    node.next=queue.peek();
                }
                // 拓展下一层节点
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
        }
        return root;
        
        
        //法二 使用已建立的next指针
        //TC:O(n)   SC:O(1)

        Node leftMost=root;
        while(leftMost.left!=null){
            // 从根节点开始
            Node head = leftMost;

            while(head!=null){
                // 遍历这一层节点组织成的链表，为下一层的节点更新 next 指针

                //第一种情况是连接同一个父节点的两个子节点。它们可以通过同一个节点直接访问到
                head.left.next=head.right;
                //第二种情况在不同父亲的子节点之间建立连接，这种情况不能直接连接。
                if(head.next!=null){
                    head.right.next=head.next.left;
                }
                // 指针向后移动
                head=head.next;
            }
            // 去下一层的最左的节点
            leftMost=leftMost.left;
        }
        return root;
    }
}
