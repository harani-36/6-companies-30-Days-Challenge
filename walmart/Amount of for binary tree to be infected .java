class Solution {
    public int amountOfTime(TreeNode root, int start) {
        if (root == null) return 0;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        buildGraph(root, null, graph);
        return bfs(graph, start);
    }
    private void buildGraph(TreeNode node, TreeNode parent, Map<Integer, List<Integer>> graph) {
        if (node == null) return;
        graph.putIfAbsent(node.val, new ArrayList<>());
        if (parent != null) {
            graph.get(node.val).add(parent.val);
            graph.get(parent.val).add(node.val);
        }
        buildGraph(node.left, node, graph);
        buildGraph(node.right, node, graph);
    }
    private int bfs(Map<Integer, List<Integer>> graph, int start) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);
        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean infected = false;
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                for (int neighbor : graph.get(current)) {
                    if (!visited.contains(neighbor)) {
                        queue.offer(neighbor);
                        visited.add(neighbor);
                        infected = true;
                    }
                }
            }

            if (infected) time++;
        }

        return time;
    }
}
