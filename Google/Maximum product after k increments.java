class Solution {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n : nums){
            pq.add(n);
        }
        int m=1000000007;
        while(k-->0){
            int x=pq.poll();
            pq.add(x+1);
        }   
        long a=1;
        while(!pq.isEmpty()){
            a*=pq.poll();
            a%=m;
        }
        return (int)a;
    }
}
