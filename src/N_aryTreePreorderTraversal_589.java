import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class N_aryTreePreorderTraversal_589 {

}
class Solution1 {
    public List<Integer> preorder(Node root) {


         List<Integer> ans = new ArrayList<>();

         if (root==null) return ans;

         List<Integer> temp;

         ans.add(root.val);

         for (int i=0;i<root.children.size();i++){

             temp = preorder(root.children.get(i));

             for (int j = 0;j<temp.size();j++){
                 ans.add(temp.get(j));
             }
         }
         return ans;

    }

    public List<Integer> preorder(Node root) {


        List<Integer> ans = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Stack<Integer> leftChildren = new Stack<>();
        if (root==null) return ans;
        stack.push(root);
        leftChildren.push(root.children.size());
        ans.add(root.val);
        while (!stack.empty()){
            Node temp = stack.peek();
            int leftChildrenOfTemp = leftChildren.peek();

           if (leftChildrenOfTemp>0){
               leftChildren.push(leftChildren.pop()-1);
               int index = temp.children.size()-leftChildrenOfTemp;
               Node child = temp.children.get(index);
               stack.push(child);
               leftChildren.push(child.children.size());
               ans.add(child.val);
           }
           else {
               stack.pop();
               leftChildren.pop();
           }
        }

        return ans;

    }


}
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}