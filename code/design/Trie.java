package design;
/**
 * @Description 208 实现前缀树
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 * @date 2021/3/1 0001-9:39
 */
public class Trie {
    class TireNode{
        private boolean isEnd;   //该节点是否是一个串的结束
        TireNode[] next;         //字母映射表
        public TireNode(){
            isEnd=false;
            next=new TireNode[26];
        }
    }
    private TireNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root=new TireNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TireNode node=root;
        for(char c:word.toCharArray()){
            if(node.next[c-'a']==null){
                node.next[c-'a']=new TireNode();
            }
            node=node.next[c-'a'];
        }
        node.isEnd=true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TireNode node=root;
        for(char c:word.toCharArray()){
            node=node.next[c-'a'];
            if(node==null) return false;
        }
        return node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TireNode node=root;
        for(char c:prefix.toCharArray()){
            node=node.next[c-'a'];
            if(node==null) return false;
        }
        return true;
    }
}
