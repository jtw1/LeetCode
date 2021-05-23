package LeetCodeTest;
import java.util.*;
// import java.util.ArrayDeque;
// import java.util.Deque;
// import java.util.HashMap;
// import java.util.LinkedList;
// import java.util.Map;
// import java.util.Scanner;

public class EffectiveBrackets {
    public static void main(String[] args) {
        
            System.out.print("请输入只包含括号的一串字符：");
            Scanner scan=new Scanner(System.in);
            String strm=scan.nextLine().toString();
            //System.out.println(strm);
            boolean isEffective=isValid1(strm);
            //System.out.println(strm);
            System.out.println(isEffective);
            scan.close();
        
    }
    
        // private static final Map<Character,Character> map = new HashMap<Character,Character>(){{
        //     put('{','}'); put('[',']'); put('(',')'); put('?','?');
        // }};
        // public static boolean isValid(String s) {
        //     if(s.length() > 0 && !map.containsKey(s.charAt(0))) return false;
        //     LinkedList<Character> stack = new LinkedList<Character>() {{ add('?'); }};
        //     for(Character c : s.toCharArray()){
        //         if(map.containsKey(c)) stack.addLast(c);
        //         else if(map.get(stack.removeLast()) != c) return false;
        //     }
        //     return stack.size() == 1;
        // }

        // 2ms
        public static boolean isValid1(String s){
            if(s==null||s.length()==0) return true;
            if(s.length()%2==1)        return false;
            Map<Character,Character> map=new HashMap<>();
            map.put(')', '(');
            map.put(']', '[');
            map.put('}', '{');
            Deque<Character> dq=new ArrayDeque<>();
            for (char c : s.toCharArray()){ 
                if(c=='('||c=='['||c=='{'){
                    dq.push(c);
                }else{
                    if(dq.size()==0||map.get(c)!=dq.pop())  return false;
                }
            }
            return true;
        }
    // 60ms
    public boolean isValid(String s) {
        if(s==null || s.length()==0) return false;
        if(s.length()%2==1) return false;
        while(s.contains("()")||s.contains("[]")||s.contains("{}")){
            if(s.contains("()")){
                s=s.replace("()","");
            }
            if(s.contains("[]")){
                s=s.replace("[]","");
            }
            if(s.contains("{}")){
                s=s.replace("{}","");
            }
        }
        return s.length()==0;
    }
}