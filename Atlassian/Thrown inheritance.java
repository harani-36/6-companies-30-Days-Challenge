class ThroneInheritance {
    String kingName;
    Map<String, List<String>> children;
    Set<String> dead_name;
    public ThroneInheritance(String kingName) {
        this.kingName = kingName;
        children = new HashMap<>();
        dead_name = new HashSet<>();
    }
    
    public void birth(String parentName, String childName) {
        children.putIfAbsent(parentName, new ArrayList<>());
        children.get(parentName).add(childName);
    }
    
    public void death(String name) {
        dead_name.add(name);
    }
    
    public List<String> getInheritanceOrder() {
        List<String> result = new ArrayList<>();
        helper(result, kingName);
        return result;
    }
    private void helper(List<String> result, String current){
        if(!dead_name.contains(current)){
            result.add(current);
        }
        List<String> next_children = children.get(current);
        if(next_children == null){
            return;
        }
        for(String child : next_children){
            helper(result, child);
        }
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */
