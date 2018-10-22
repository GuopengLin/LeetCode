## 700
       if (root==null) return root;
        if (root.val==val) return root;
        if (val<root.val) return searchBST(root.left,val);
        else return searchBST(root.right,val);
这题没啥好说的了，书上基本都有源代码，思路也很简单，把当前节点小往左，比当前节点大往右