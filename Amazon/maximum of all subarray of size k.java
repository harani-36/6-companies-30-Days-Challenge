class Solution {
    // Function to find maximum of each subarray of size k.
    public ArrayList<Integer> max_of_subarrays(int arr[], int k) {
        ArrayList<Integer> l = new ArrayList<>();
        Deque<Integer> d = new LinkedList<>();
        for(int i=0;i<arr.length;i++){
            while(!d.isEmpty() && d.peekFirst()<i-k+1){
                d.pollFirst();
            }
            while(!d.isEmpty() && arr[d.peekLast()]<=arr[i]){
                d.pollLast();
            }
            d.offerLast(i);
            if(i>=k-1) l.add(arr[d.peekFirst()]);
        }
        return l;
        // Your code here
    }
}
