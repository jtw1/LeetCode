import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description 37 序列化二叉树 p194
 * @date 2021/1/25 0025-14:35
 */
public class Sol37 {
    // BFS
    public String serialize1(TreeNode root) {
        if(root==null) return "[]";
        StringBuilder res=new StringBuilder("[");
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        //层次遍历
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            if(node!=null){
                res.append(node.val+",");
                queue.add(node.left);
                queue.add(node.right);
            }else{
                res.append("null,");
            }
        }
        res.deleteCharAt(res.length()-1);//去掉最后一个逗号
        res.append("]");
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize1(String data) {
        if(data.equals("[]")) return null;
        String[] vals=data.substring(1,data.length()-1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int i=1;
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            if(!vals[i].equals("null")){
                node.left=new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.left);
            }
            i++;
            if(!vals[i].equals("null")){
                node.right=new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }

    // 前序遍历
    // Encodes a tree to a single string.
    public String serialize(TreeNode root){
        if(root==null) return "null";
        return root.val+","+serialize(root.left)+","+serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data){
        Queue<String> queue=new LinkedList<>(Arrays.asList(data.split(",")));
        return dfs(queue);
    }

    private TreeNode dfs(Queue<String> queue){
        String vals=queue.poll();
        if("null".equals(vals)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(vals));
        root.left=dfs(queue);
        root.right=dfs(queue);
        return root;
    }
}
