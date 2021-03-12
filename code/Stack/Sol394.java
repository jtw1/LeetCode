import java.util.LinkedList;

/**
 * @Description 394 字符串解码
 * https://leetcode-cn.com/problems/decode-string/
 * @date 2021/3/12 0012-10:03
 */
public class Sol394 {
    /**
     * 辅助栈   TC:O(n)  SC:O(n)
     * 遍历s中的每一个字符
     * c为数字字符时，将其转化为数字multi
     * c为字母时，将其添加到res尾部
     * c为'['时，将当前 multi 和 res 入栈，并分别置空置 0
     *     记录此 [ 前的临时结果 res 至栈，用于发现对应 ] 后的拼接操作
     *     记录此 [ 前的倍数 multi 至栈，用于发现对应 ] 后，获取 multi × [...] 字符串。
     *     进入到新 [ 后，res 和 multi 重新记录。
     * 当 c 为 ] 时，stack 出栈，拼接字符串 res = last_res + cur_multi * res
     *     last_res是上个 [ 到当前 [ 的字符串，例如 "3[a2[c]]" 中的 a；
     *     cur_multi是当前 [ 到 ] 内字符串的重复倍数，例如 "3[a2[c]]" 中的 2
     */
    public String decodeString(String s){
        StringBuilder res=new StringBuilder();
        if (s==null || s.length()==0) return res.toString();
        // 记录遍历到的数字
        int multi=0;
        // 分别用来记录数字和字母的两个栈
        LinkedList<Integer> stack_multi = new LinkedList<>();
        LinkedList<String> stack_res = new LinkedList<>();
        for(char c:s.toCharArray()){
            if (c=='['){
                stack_multi.addLast(multi);
                stack_res.addLast(res.toString());
                multi=0;
                res=new StringBuilder();
            }else if (c==']'){
                StringBuilder tmp=new StringBuilder();
                int cur_multi=stack_multi.removeLast();
                for (int i = 0; i < cur_multi; i++) {
                    tmp.append(res);
                }
                res=new StringBuilder(stack_res.removeLast()+tmp);
            }else if (c>='0' && c<='9'){
                multi=multi*10+Integer.parseInt(c+"");
            }else{
                res.append(c);
            }
        }
        return res.toString();
    }
}
