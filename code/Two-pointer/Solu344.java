package LeetCodeTest;
//344 反转字符串
public class Solu344 {
    public static void main(String[] args) {
        Solu344 solu = new Solu344();
        char[] c = new char[]{'a','b','c','v','n','g'};
        solu.reverseString(c);
        System.out.println(c);
        // for (int i = 0; i < c.length; i++) {
        //     System.out.println(c[i]);
        // }
    }

    
    public void reverseString(char[] s) {
        //法一：双指针
        //时间复杂度：O(n)     空间复杂度：O(1)
        int begin=0;
        int back=s.length-1;
        char temp;
        while (begin<back) {
            temp=s[begin];
            s[begin++]=s[back];
            s[back--]=temp;
        }

        //法二：递归
        //时间复杂度：O(n)     空间复杂度：O(n)
        //heilper(s, 0, s.length-1);
    }
    // public void heilper(char[] s,int left,int right){
    //     if(left>=right)  return;
    //     char tem=s[left];
    //     s[left++]=s[right];
    //     s[right--]=tem;
    //     heilper(s, left, right);
    // }
}