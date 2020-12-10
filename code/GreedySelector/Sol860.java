package GreedySelector;

/**
 * @Description [860] 柠檬水找零
 *https://leetcode-cn.com/problems/lemonade-change/
 * @date 2020/12/10 0010-9:47
 */
public class Sol860 {
    public boolean lemonadeChange(int[] bills) {
        //贪心+模拟
        //TC:O(n)  SC:O(1)
        if(bills[0]>5) return false;
        int five=0,ten=0;
        for (int bill : bills) {
            if(bill==5){
                five++;
            }else if(bill==10){
                if(five==0) return false;
                five--;
                ten++;
            }else{
                if(five>0 && ten>0){
                    five--;
                    ten--;
                }else if(five>=3){
                    five -= 3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
