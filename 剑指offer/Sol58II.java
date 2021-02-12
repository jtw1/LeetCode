/**
 * @Description 58_II 左旋转字符串
 * https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 * @date 2021/2/12-15:12
 */
public class Sol58II {
    public String reverseLeftWords(String s, int n) {
        StringBuilder res=new StringBuilder();
        res.append(s.substring(n));
        res.append(s.substring(0,n));
        return res.toString();
    }
}
