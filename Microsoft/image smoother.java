class Solution {
    public int[][] imageSmoother(int[][] img) {
        int r=img.length;
        int c=img[0].length;
        int[][] rs = new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                rs[i][j]=find(img,i,j,r,c);
            }
        }
        return rs;
    }
    public int find(int[][] a, int i, int j, int r, int c){
        int s=a[i][j],ct=1;
        if(i-1>=0){
            if(j-1>=0){
                s+=a[i-1][j-1];
                ct++;
            }
            if(j+1<c){
                s+=a[i-1][j+1];
                ct++;
            }
            s+=a[i-1][j];
            ct++;
        }
        if(i+1<r){
            if(j-1>=0){
                s+=a[i+1][j-1];
                ct++;
            }
            if(j+1<c){
                s+=a[i+1][j+1];
                ct++;
            }
            s+=a[i+1][j];
            ct++;
        }
        if(j-1>=0){
            s+=a[i][j-1];
            ct++;
        }
        if(j+1<c){
            s+=a[i][j+1];
            ct++;
        }
        double d = (double)s/ct;
        int rs=(int)Math.floor(d);
        return rs;
    }
}
