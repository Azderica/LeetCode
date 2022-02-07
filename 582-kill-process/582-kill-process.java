class Solution {
    class Node {
        int id;
        List<Node> children;
        Node(int id) {
            this.id = id;
            children = new ArrayList<>();
        }
    }

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        int n = pid.size();
        HashMap<Integer, Node> map = new HashMap<>();

        for(int id : pid) { map.put(id, new Node(id)); }
        for(int i = 0; i < n; i++) {
            if(ppid.get(i) != 0) {
                map.get(ppid.get(i)).children.add(map.get(pid.get(i)));
            }
        }

        List<Integer> result = new ArrayList<>();
        result.add(kill);
        addAllChildren(result, map.get(kill));

        return result;
    }

    private void addAllChildren(List<Integer> result, Node parent) {
        if(parent.children.size() > 0) {
            for(Node children : parent.children) {
                result.add(children.id);
                addAllChildren(result, children);
            }
        }
    }
}