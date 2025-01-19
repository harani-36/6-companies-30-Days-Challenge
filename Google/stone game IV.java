class Solution {
    public int stoneGameVI(int[] av, int[] bv) {
        int n = av.length;
        int[][] sv = new int[n][3];
        for(int i = 0; i < n; i++){
            sv[i] = new int[]{av[i], bv[i],  (av[i] + bv[i])};
        }
        Arrays.sort(sv, (a, b) -> (b[2] - a[2]));
        int as = 0;
        for(int i = 0; i < n; i++){    
            if(i % 2 == 0){
                as += sv[i][0];
            }else{
                as -= sv[i][1];
            }
        }        
        if(as > 0) return 1;
        if(as < 0) return -1;        
        return 0;
    }
    
}
