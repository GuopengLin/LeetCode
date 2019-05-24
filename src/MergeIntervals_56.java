import java.util.ArrayList;
import java.util.List;

public class MergeIntervals_56 {
    public List<Interval> merge(List<Interval> intervals) {

        List<Interval> ans = new ArrayList<>();
        if ( intervals == null )
            return ans;
        int len = intervals.size();
        if (len == 0)
            return ans;
        sort(intervals,0,len-1);
        int start = intervals.get(0).start;
        int end = 0;
        for (int i = 0 ; i < len-1 ; i++){
            if (intervals.get(i).end > end)
                end = intervals.get(i).end;
            if (end < intervals.get(i+1).start){
                Interval interval = new Interval(start,end);
                ans.add(interval);
                start = intervals.get(i+1).start;
            }

        }
        if (intervals.get(len-1).end > end)
            end = intervals.get(len-1).end;
        Interval interval = new Interval(start,end);
        ans.add(interval);
        return ans;


    }
    public void sort(List<Interval> intervals,int l ,int r){

        int k;
        if ( l < r){
            k = partition(intervals,l,r);
            sort(intervals,l,k-1);
            sort(intervals,k+1,r);
        }

    }
    public int partition(List<Interval> intervals,int l ,int r){
            int k = (int)(Math.random()*(r-l))+l;
            exchange(intervals,k,r);
            Interval x = intervals.get(r);
            int i = l-1;
            for ( int j = l ; j <= r-1; j++){
                if (intervals.get(j).start < x.start || ( intervals.get(j).start == x.start && intervals.get(j).end < x.end)){
                    i++;
                    exchange(intervals,i,j);
                }

            }
            exchange(intervals,i+1,r);
            return i+1;
    }
    public void exchange(List<Interval> intervals,int x ,int y){
        Interval temp1 = intervals.get(x);
        Interval temp2 = intervals.get(y);
        intervals.set(x,temp2);
        intervals.set(y,temp1);
    }
    static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
}
