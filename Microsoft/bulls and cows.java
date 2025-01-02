class Solution {
    public String getHint(String s, String g) {
        int bulls = 0;
        int cows = 0;
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> gMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == g.charAt(i)) {
                bulls++;
            } else {
                sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
                gMap.put(g.charAt(i), gMap.getOrDefault(g.charAt(i), 0) + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : sMap.entrySet()) {
            char key = entry.getKey();
            if (gMap.containsKey(key)) {
                cows += Math.min(entry.getValue(), gMap.get(key));
            }
        }
        return bulls + "A" + cows + "B";
    }
}
