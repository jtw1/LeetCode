import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description 297 二叉树的序列化与反序列化
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 * @date 2021/3/5 0005-9:38
 */
public class Sol297 {
    // TC:O(n) SC:O(n)
    // Encodes a tree to a single string.
    public String serialize(TreeNode root){
        return reSerialize(root,"");
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] data_arr=data.split(",");
        List<String> data_list = new LinkedList<>(Arrays.asList(data_arr));
        return reDeserialize(data_list);
    }

    public String reSerialize(TreeNode root,String str) {
        if(root==null){
            str += "None,";
        }else {
            str += str.valueOf(root.val)+",";
            str = reSerialize(root.left,str);
            str = reSerialize(root.right,str);
        }
        return str;
    }

    public TreeNode reDeserialize(List<String> list) {
        if (list.get(0).equals("None")){
            list.remove(0);
            return null;
        }

        TreeNode root=new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left=reDeserialize(list);
        root.right=reDeserialize(list);
        return root;
    }
}
