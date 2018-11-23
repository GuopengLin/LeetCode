public class MinimumDepthofBinaryTree {


      public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
      }

    class Solution {
        public int minDepth(TreeNode root) {
             TreeNode[] queue = new TreeNode[100000];
             int[] depth = new int[100000];
             if (root == null) return 0;
             int head = 0;
             int tali = 0;
             queue[tali++] = root;//先将根节点入队
             depth[tali++] = 1;
             while(head!=tali){ //如果队列不为空
                 TreeNode x = queue[head++];
                 int xDepth = depth[head++];//取出队头的节点及其深度
                 if (x.left == null && x.right == null){ //如果是叶子节点，则找到最浅深度
                     return xDepth;
                 }
                  if (x.left != null){ //左儿子不为空，则将左儿子入队
                     queue[tali++] = x.left;
                     depth[tali++] = xDepth+1;
                 }
                 if (x.right != null){
                     queue[tali++] = x.right;
                     depth[tali++] = xDepth+1;
                 }
             }
             return 0;
        }
    }
}
