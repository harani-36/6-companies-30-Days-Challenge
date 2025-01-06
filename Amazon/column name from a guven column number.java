class Solution {
    public String convertToTitle(int c) {
        StringBuilder r = new StringBuilder();
        while (c>0) {
            c--;
            r.append((char) (c % 26 + 'A'));
            c/=26;
        }
        return r.reverse().toString();
    }
}
