
/**
 * @Description 35 复杂链表的复制
 * https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 * @date 2021/1/21 0021-10:13
 */
public class Sol35 {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        cloneNodes(head);
        connectRandom(head);
        return reConnectNode(head);
    }

    /**
     * 复制原始链表的节点pNode,并创建新节点pCloned,把pCloned连接到pNode后面
     * @param head
     */
    public void cloneNodes(Node head){
        Node pNode=head;
        while(pNode!=null){
            Node pCloned=new Node(-1);
            pCloned.val=pNode.val;
            pCloned.next=pNode.next;
            pCloned.random=null;

            pNode.next=pCloned;
            pNode=pCloned.next;
        }
    }

    /**
     * 设置pCloned的random节点
     * @param head
     */
    public void connectRandom(Node head){
        Node pNode=head;
        while(pNode!=null){
            Node pCloned=pNode.next;
            if(pNode.random!=null){
                pCloned.random=pNode.random.next;
            }
            pNode=pCloned.next;
        }
    }

    /**
     * 把长链表拆分成两个链表，奇数位置的节点用next连接起来就是原始链表，偶数位置的节点用next连接起来就是复制的链表
     * @param head
     * @return 复制的链表
     */
    public Node reConnectNode(Node head){
        Node pNode=head;
        Node pClonedHead=null;
        Node pClonedNode=null;

        if(pNode!=null){
            pClonedHead=pClonedNode=pNode.next;
            pNode.next=pClonedNode.next;
            pNode=pNode.next;
        }

        while(pNode!=null){
            pClonedNode.next=pNode.next;
            pClonedNode=pClonedNode.next;
            pNode.next=pClonedNode.next;
            pNode=pNode.next;
        }
        return pClonedHead;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
