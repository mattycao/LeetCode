import java.util.*;

public class Solution {
    public static class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
    }
    public static int maxPoints(Point[] points) {
        if(points.length < 3) {
            return points.length;
        }
        int result = 0;
        Map<Double, Integer> map = new HashMap<Double, Integer>(); 
        for(int i = 0; i < (points.length -1); ++i) {
            map.clear();
            int sameNum = 0;
            int point_Max = 1;
            for(int j = i + 1; j < points.length; ++j) {
                double slope;
                if(points[i].x == points[j].x) {
                    // add the slope infinite
                   //map.put((double)Integer.MAX_VALUE, 2);
                    slope = Double.MAX_VALUE;
                   if(points[i].y == points[j].y) {
                       ++sameNum;
                       continue;
                   }
                } else {
                    slope = ((double)(points[i].y - points[j].y)/(points[i].x - points[j].x)) + 0.0;
                }
                int count = 0;
                if(map.containsKey(slope)) {
                    count = (map.get(slope)).intValue() + 1;
                    map.put(slope, count);
                } else {
                    count = 2;
                    map.put(slope, count);
                }
                if(point_Max < count) 
                    point_Max = count;
            }
            //result = (result < point_Max + sameNum)? point_Max + sameNum : result;
            if(result < point_Max + sameNum) result = point_Max + sameNum;
        }
        return result;
    }
    public static void main(String[] args) {
        Point[] point = {new Point(-7, 7), new Point(-7, 1), new Point(1, 0), new Point(-7, -25)};
        System.out.println("Result:" + maxPoints(point));
    }
}