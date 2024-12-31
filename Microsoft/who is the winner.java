class Solution {
    public int findTheWinner(int n, int k) {
        ArrayList<Integer> a = new ArrayList<>();
        for(int i=0;i<n;i++){
            a.add(i+1);
        }
        int s=0;
        while(a.size()>1){
            int nw = (s+k-1)%a.size();
            a.remove(nw);
            s=nw;
        }
        return a.get(0);
    }
}
