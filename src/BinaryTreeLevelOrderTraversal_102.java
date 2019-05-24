import java.util.ArrayList;
import java.util.List;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeLevelOrderTraversal_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        if (root == null){

            return ans;
        }
        //队列
        TreeNode[] queue = new TreeNode[10000];
        //深度
        int[] level = new int[10000];

        //头指针，尾指针
        int head = 0;
        int tail = 0;
        //根节点入队
        queue[tail] = root;
        level[tail] = 0;
        tail++;

        //如果队列未空
        while(head != tail){


            TreeNode node = queue[head];
            int nowLevel = level[head];
            head++;
            List<Integer> list;
            //如果ans 的size <= 当前节点的深度，则该list 还没有创建
            if (ans.size()<=nowLevel){
                list = new ArrayList<>();
                ans.add(list);
            }else {
                list = ans.get(nowLevel);
            }

            list.add(node.val);

            if (node.left != null){
                queue[tail] = node.left;
                level[tail] = nowLevel+1;
                tail++;
            }
            if (node.right != null){
                queue[tail] = node.right;
                level[tail] = nowLevel+1;
                tail++;
            }
        }
        return ans;
    }
}
