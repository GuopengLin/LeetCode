import java.util.ArrayList;

public class RedundantConnectionII_685 {
    public int[] inDegree;
    public int[] queue;
    public ArrayList<Integer>[] myEdge;
    public boolean[] inStack;
    public boolean[] haveReached;
    public int[] stack;
    public int[] dfn;
    public int[] low;
    public int[] color;
    public int now_color;
    public int time;
    public int top;
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n;
        n = edges.length;
        inDegree = new int[n+1];

        myEdge = new ArrayList[n+1];
        queue = new int[n+1];


        for (int i = 1 ; i <= n; i++){
            myEdge[i] = new ArrayList<>();
        }
        //计算每个点的入度
        for (int i = 0 ; i < n; i++){
            int from = edges[i][0];
            int to = edges[i][1];
            myEdge[from].add(to);
            inDegree[to]++;
        }
//        //如果有某个点的度为2，那么一定是把这个点的后一条去掉
//        int node = -1;
//        for (int i = 1 ; i <= n ;i++){
//            if (inDegree[i] == 2)
//                node = i;
//        }
//        //存在入度为2的点
//        if (node != -1){
//            for (int i = n-1 ; i>=0;i--){
//                int from = edges[i][0];
//                int to = edges[i][1];
//                if (to == node && inDegree[from] != 0)
//                    return new int[]{from,to};
//            }
//        }
//
//        //接下来是不存在的情况，也是本次的重点，

        //第一个代表该元素是否在栈内，第二个代表是否经过这个点，第三个代表栈里面的元素
        inStack = new boolean[n+1];
        haveReached = new boolean[n+1];
        stack = new int[2*n];

        //同一个环里面的元素都染成同一个颜色
        now_color = 0;
        color = new int[n+1];
        top = 0;
        //时间设置为0
        time = 0;


        //dfn 代表遍历到的时间，low 代表可以追溯到的最早之间，也就是属于同一个强连通分块的最早遍历的节点
        dfn = new int[n+1];
        low = new int[n+1];

        for (int i = 1 ; i < n+1 ;i++)
            if (!haveReached[i])
                tarjan(i);
        //有以下三种可能，既存在环又存在入度为2 的点，存在环，存在入度为2 的点
        for (int i = n-1 ; i>=0;i--){
            int from = edges[i][0];
            int to = edges[i][1];
            //如果两个点颜色相同，则说明在用一个环
            if(color[from] == color[to] && inDegree[to] == 2){
               return new int[]{from,to};
            }
        }
        for (int i = n-1 ; i>=0;i--){
            int from = edges[i][0];
            int to = edges[i][1];
            //如果两个点颜色相同，则说明在用一个环
            if(color[from] == color[to]){
                return new int[]{from,to};
            }
        }
        //
        for (int i = n-1 ; i>=0;i--){
            int from = edges[i][0];
            int to = edges[i][1];
            //如果两个点颜色相同，则说明在用一个环
            if(inDegree[to] == 2){
                return new int[]{from,to};
            }
        }
        return new int[2];
    }
    public void tarjan(int k){
        inStack[k] = true;
        haveReached[k] = true;
        time++;
        dfn[k] = time;
        low[k] = time;
        top++;
        stack[top] = k;
        for (int i = 0 ; i < myEdge[k].size();i++){
            int next_node = myEdge[k].get(i);

            if (!haveReached[next_node]){
                //还没有遍历的点先去遍历，再更新low
                tarjan(next_node);
                low[k] = min(low[k],low[next_node]);
            }else if (inStack[next_node]) {
                //对于遍历过的点，且还在栈里面，说明找到了回路
                low[k] = min(low[k],low[next_node]);
            }
        }
        //强连通分量找到
        if (dfn[k] == low[k]){
            now_color++;
            //把栈里面的元素去出，直到上一个取出的元素和当前元素一样
            //并且在这个期间设置好连通块的颜色
            while (stack[top+1] != k){
                inStack[stack[top]] = false;
                color[stack[top]] = now_color;
                top--;
            }
        }
    }
    public int min(int a, int b){
        return (a<b)?a:b;
    }
}
