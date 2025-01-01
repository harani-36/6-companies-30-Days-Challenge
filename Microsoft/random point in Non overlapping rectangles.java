import java.util.Random;
class Solution {
    private int[][] rects;
    private int[] cs;
    private int tp;
    private Random random;

    public Solution(int[][] rects) {
        this.rects = rects;
        this.random = new Random();
        this.cs = new int[rects.length];
        this.tp = 0;
        for (int i = 0; i < rects.length; i++) {
            int w = rects[i][2] - rects[i][0] + 1;
            int h = rects[i][3] - rects[i][1] + 1;
            tp += w * h;
            cs[i] = tp;
        }
    }

    public int[] pick() {
        int rp = random.nextInt(tp);
        int ri = binarySearch(rp);
        int[] rect = rects[ri];
        int x = rect[0] + random.nextInt(rect[2] - rect[0] + 1);
        int y = rect[1] + random.nextInt(rect[3] - rect[1] + 1);
        return new int[]{x, y};
    }
    private int binarySearch(int t) {
        int l = 0, r = cs.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (cs[mid] > t) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
