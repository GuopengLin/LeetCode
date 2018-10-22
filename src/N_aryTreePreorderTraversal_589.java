import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class N_aryTreePreorderTraversal_589 {

}
class Solution1 {
    public List<Integer> preorder(Node root) {


         List<Integer> ans = new ArrayList<>(); //本次将返回的List

         if (root==null) return ans;//为空直接返回

         List<Integer> temp;//用于接受子节点返回的list

         ans.add(root.val);//将自身的值加入list

         for (int i=0;i<root.children.size();i++){ //遍历

             temp = preorder(root.children.get(i));

             for (int j = 0;j<temp.size();j++){ //合并
                 ans.add(temp.get(j));
             }
         }
         return ans;

    }

    public List<Integer> preorder(Node root) {


        List<Integer> ans = new ArrayList<>();

        Stack<Node> stack = new Stack<>(); //存储进栈的节点
        Stack<Integer> leftChildren = new Stack<>();//栈顶元素的剩余孩子数，即用来计算当前应该遍历该节点的第几个孩子
        if (root==null) return ans;
        stack.push(root);
        leftChildren.push(root.children.size()); //将根节点及其剩余孩子树入栈

        ans.add(root.val); //将根节点的值放入list中
        while (!stack.empty()){  //栈为空时，说明已经遍历所有节点
            Node temp = stack.peek(); //取栈顶元素
            int leftChildrenOfTemp = leftChildren.peek(); //取出它剩余的孩子数

           if (leftChildrenOfTemp>0){ //假如说它还有孩子没有被遍历，则继续遍历它的孩子
               leftChildren.push(leftChildren.pop()-1);   // 将它的剩余孩子数-1，记住：两个栈应该保持一致，同一个位置时刻指向相同元素及其属性，所以先取出，-1后在push进去
               int index = temp.children.size()-leftChildrenOfTemp; //算出孩子的下标
               Node child = temp.children.get(index);
               stack.push(child);
               leftChildren.push(child.children.size()); //将孩子及其孩子数入栈
               ans.add(child.val);//将孩子的值加入list
           }
           else { //假如说所有孩子都被遍历了，将这个节点出栈
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