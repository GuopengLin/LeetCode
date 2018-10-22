# 589
**总体想法** 题目要求是对一颗给定的树进行先序遍历，这和课本中的二叉树的唯一区别是，课本中的遍历直接使用search(node.left)，search(node.right)进行两次遍历就足够了，而题目中的子节点数是未知的，因此需要用循环来对每个子节点进行遍历

**题目有两种解法**

**解法1：**递归版，先将自身的值存储到List中，在进行遍历，每一个子节点进行遍历后，将返回的List使用循环进行合并
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
         

**解法2：**非递归版，这里需要讲到如何用循环实现递归与回溯。


**什么是回溯** 简单而言就是进入下一层后，能够返回上一层，并且保留上一层的状态，当你使用调用函数的方法时，系统自动帮你建好了栈，储存了该层循环中所有的局部变量。例如 有一个函数名为f()，我们将第一重函数调用定义为：F1，在F1中调用f()自身，形成第二重调用称为F2，那么我们在F1调用F2时，会将F1中的所有局部变量放入系统栈中，然后进入F2，当F2结束时，F2的栈内容被pop出去，此时栈指针又会指向F1的内容，再将里面的内容取出，于是就完成了回溯

**接下来讲如何应对深度的问题**


如果是单纯的深入而不返回上一层的话，用循环实现是非常简单的，例如二叉树的搜索操作，只要判断当前节点不是null并且不等于要找的key值，就可以将该节点的子节点赋值给当前引用，然后继续下一轮循环。

如果是搜索深度是已知的，同样是很简单的，深度为多少，就写几重循环，同样能解决问题

但是当深度是未知的，且要求回溯（也就是进入下一层后，能够返回上一层），这时候，推荐还是使用函数调用的方法，千万不用使用以下方法作死
，不过，既然题目都说了，我还是写下

方法其实是换汤不换药的，既然不调用方法，不调用系统栈，那就自己建个栈吧，
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
       
理论上我们应该模仿系统栈的行为对每个局部变量进行入栈的，但是实际上我们可以有选择的将部分有用的值入栈，当回溯的时候，我们唯一关心的是该节点原来遍历到哪个子节点了，然后好进行下一步遍历，所以我们只需保存好它剩余的孩子数
