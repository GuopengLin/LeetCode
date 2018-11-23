## 111. Minimum Depth of Binary Tree  
直接上代码吧，注释在代码里，简单的广度优先搜索罢了。。  
每次将左右孩子入队，如果没有左右孩子说明找到底了，还有记得保存深度。  
 
## 代码  
```
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