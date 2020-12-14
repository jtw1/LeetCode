package GreedySelector;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description Dota2 参议院 day
 * https://leetcode-cn.com/problems/dota2-senate/
 * @date 2020/12/11 0011-9:49
 */
public class Sol649 {
    public String predictPartyVictory(String senate){
        //TC:O(n) SC:O(n)
        int len=senate.length();
        //使用两个队列radiant 和dire分别按照投票顺序存储天辉方和夜魇方每一名议员的投票时间
        Queue<Integer> radiant=new LinkedList<>();
        Queue<Integer> dire=new LinkedList<>();

        for (int i = 0; i < len; i++) {
            if(senate.charAt(i)=='R'){
                radiant.offer(i);
            }else{
                dire.offer(i);
            }
        }
        /**
         * 如果此时radiant 或者 dire 为空，那么就可以宣布另一方获得胜利；
         * 如果均不为空，比较两个队列的首元素
         */
        while(!radiant.isEmpty() && !dire.isEmpty()){
            int radiantIndex = radiant.poll(),direIndex=dire.poll();
            //如果radiant首元素较小，说明radiant方先行使权力，会禁言dire的首元素对应那位议员
            //因此将dire首元素永久弹出，并将radiant首元素弹出，增加n之后重新放回队列
            // 这里增加n而不是增加剩余的议员人数，是为了保证在一轮中议员的前后相对位置不变
            if(radiantIndex<direIndex){
                radiant.offer(radiantIndex+len);
            }else{
                dire.offer(direIndex+len);
            }
        }
        return radiant.isEmpty()? "Radiant":"Dire";
    }
}
