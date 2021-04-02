/**
 * @Description 52 两个链表的第一个公共节点
 * https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 * @date 2021/1/31-16:25
 */
public class Sol52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /**
         * 链表A到公共节点距离为a，链表B到公共节点距离为，二者公共部分长度为c吧，公共节点为q
         * pA，pB分别从headA，headB出发，pA到尾节点之后，转为从headB出发，p到尾节点之后，转为从head出发A
         * 原理：pA第二次到q时，走过的距离为a+b+c,pB第二次到q时，走过的距离也是a+b+c，
         * 所以pA=pB时，他们就在公共节点
         * 没有公共点时，pA,pB都是null
         */
        ListNode pA=headA;
        ListNode pB=headB;
        while(pA!=pB){
            pA = pA!=null?pA.next:headB;
            pB = pB!=null?pB.next:headA;
        }
        return pA;
    }
}
