class Solution {
    public int maxEnvelopes(int[][] e) {
        Arrays.sort(e,(a,b)->{
            if(a[0]==b[0]) return b[1]-a[1];
            return a[0]-b[0];
        });
        int n=e.length;
        int[] dp = new int[n];
        int l=0;
        for(int[] en : e){
            int idx=Arrays.binarySearch(dp,0,l,en[1]);
            if(idx<0) idx=-(idx+1);
            dp[idx]=en[1];
            if(idx==l) l++;
        }
        return l;
    }
}
