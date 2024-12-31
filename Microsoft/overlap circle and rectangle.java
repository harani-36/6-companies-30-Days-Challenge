class Solution {
    public boolean checkOverlap(int r, int xc, int yc, int x1, int y1, int x2, int y2) {
        int nx=Math.max(x1, Math.min(xc,x2));
        int ny=Math.max(y1, Math.min(yc,y2));
        int dx=xc-nx, dy=yc-ny;
        int rs=dx*dx+dy*dy;
        return rs<=r*r;
    }
}
