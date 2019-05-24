public class CourseSchedule_207 {
    public boolean[][] temp;
    public int nums;
    int[] color;
    public final int WHITE = 0;
    public final int GRAY = 1;
    public final int BLACK = 2;
    boolean result;
    public boolean canFinish(int numCourses, int[][] prerequisites) {


        nums = numCourses;
        color = new int[nums];
        //初始化所有节点为白色
        for ( int i = 0;i<nums;i++)
            color[i] = WHITE;

        //把图存储的方式转化一下，
        temp = new boolean[nums][nums];
        for (int i = 0;i<prerequisites.length;i++)
        {
            temp[prerequisites[i][0]][prerequisites[i][1]] = true;
        }


        //开始遍历
        result = true;
        for( int i = 0;i<nums;i++)
        {
            //白色代表还没走过
            if (color[i] == WHITE)
                deepFirstSearch(i);
        }
        return result;
    }
    public void deepFirstSearch( int k ){

        //已进入该节点，先改成灰色
        color[k] = GRAY;
        //遍历相邻节点
        for (int i = 0;i<nums;i++){
            if (temp[k][i] ){
                //如果遍历到节点为灰色，则一定存在环
                if (color[i] == GRAY){
                    result = false;
                    return;
                }
                if (color[i] == WHITE)
                    deepFirstSearch(i);
            }
        }
        //遍历完相邻节点，变成黑色
        color[k] = BLACK;
    }
}
