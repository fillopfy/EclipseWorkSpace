import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PointsAndSegments {
	
	static class Segment{
		int start, end;
		public Segment(int a, int b) {
			this.start=a;
			this.end=b;
		}
	}
	
	static class SortByStartingPoint implements Comparator<Segment>{
		public int compare(Segment a, Segment b) {
			return a.start-b.start;
		}
	}
	
	

    private static int[] fastCountSegments(Segment[] segment, int[] points) {
        int[] cnt = new int[points.length];
        
        return cnt;
    }

    private static int[] naiveCountSegments(int[] starts, int[] ends, int[] points) {
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < starts.length; j++) {
                if (starts[j] <= points[i] && points[i] <= ends[j]) {
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        Segment[] segment=new Segment[n];
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends[i] = scanner.nextInt();
            segment[i]=new Segment(starts[i],ends[i]);
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        Arrays.sort(points);
        Arrays.sort(segment,new SortByStartingPoint());
        //use fastCountSegments
        int[] cnt = naiveCountSegments(starts, ends, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
    }
}

