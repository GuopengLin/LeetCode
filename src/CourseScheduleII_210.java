import java.util.ArrayList;

public class CourseScheduleII_210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        int indexAns = 0;
        int[] inDegree = new int[numCourses];
        ArrayList<Integer>[] edge = new ArrayList[numCourses];
        for (int i = 0 ; i < numCourses ; i++){
            edge[i] = new ArrayList<>();
        }
        int len = prerequisites.length;
        for (int i = 0 ; i < len ; i++){
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            inDegree[to]++;
            edge[from].add(to);
        }
        int[] queue = new int[numCourses];
        int head = 0;
        int tail = 0;
        for (int i = 0 ; i < numCourses ; i++){
            if (inDegree[i] == 0)
                queue[tail++] = i;
        }
        while (head < tail){
            int nowCource = queue[head++];
            ans[indexAns++] = nowCource;
            int temp = edge[nowCource].size();
            for (int i = 0 ; i < temp ; i++){
                int nextCourse = edge[nowCource].get(i);
                inDegree[nextCourse]--;
                if (inDegree[nextCourse] == 0){
                    queue[tail++] = nextCourse;
                }
            }
        }
        if (indexAns < numCourses)
            ans = new int[0];
        return ans;
    }
}
