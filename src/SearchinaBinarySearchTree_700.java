public class SearchinaBinarySearchTree_700 {


}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root==null) return root;
        if (root.val==val) return root;
        if (val<root.val) return searchBST(root.left,val);
        else return searchBST(root.right,val);

    }
}