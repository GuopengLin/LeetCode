import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MinimumHeightTrees_310 {

  //  class Solution {
        int[] queue;
        boolean[] reached;
        ArrayList<Integer>[] myEdge;
        int[] len;
        int[] last;
        int head;
        int tail;
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            List<Integer> ans = new ArrayList<>();
            myEdge = new ArrayList[n];

            for (int i = 0;i<n;i++){
                myEdge[i] = new ArrayList<>();
            }
            for (int i = 0;i<edges.length;i++){ //转化边的储存形式，改成链接链表，其实原本觉得这么做可以减下时间复杂度的，但是leetcode 不给数据规模啥的，不知道边的多少
                int x = edges[i][0];
                int y = edges[i][1];
                myEdge[x].add(y);
                myEdge[y].add(x);
            }

            int p1 = BFS(0);//找到第一个端点
            int p2  = BFS(p1);//找到第二个端点
            int x = p2;
            int length = len[x];
            int t1 = 0;
            int t2 = 0;  //t1,t2是中点对应的len
            if (length % 2 ==0){
                t1 = length/2;
                t2 = length/2+1;
            }
            else {
                t1 = length/2+1;
            }

            do{  //开始找中点
                if (len[x] == t1 || len[x] == t2){
                    ans.add(x);
                }
                x = last[x];
            }while (x != last[x]);
            if (len[x] == t1 || len[x] == t2){  //如果第一个点就是，leetcode 总有一些坑爹数据
                if (ans.indexOf(x)<0) ans.add(x);
            }

            return  ans;
        }
        public  int BFS(int node){
            queue = new int[100000]; //广搜的队列
            len = new int[100000]; //存储在路径的位置，为了找中点用
            last = new int[100000]; //存储上一个节点
            reached = new boolean[100000]; //是否遍历过
            head = 0;
            tail = 0;
            int x = node;
            len[x] = 1;
            reached[x] = true;
            last[x] = x;
            inQueue(node);//将该点入队
            while (!isEmpty()){//开始广搜
                 x = deQueue();
                for (int i = 0 ;i<myEdge[x].size();i++){
                     int y = myEdge[x].get(i);
                     if (reached[y] == false){ //如果y 节点还未遍历，则入队
                         inQueue(y);
                         len[y] = len[x]+1;
                         last[y] = x;
                         reached[y] = true;
                     }
                }
            }
            return x;
        }
        public boolean isEmpty(){
            return head == tail;
        }
        public void inQueue(int node){
            queue[tail++] = node;
        }
        public int deQueue(){
           return queue[head++];
        }

  //  }
}
