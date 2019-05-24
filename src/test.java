import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        CourseScheduleII_210 courseScheduleII_210 = new CourseScheduleII_210();
        int[][] edge = {{1,0},{0,1}};
        int[] ans = courseScheduleII_210.findOrder(2,edge);
        System.out.println(ans.length);
    }
}
