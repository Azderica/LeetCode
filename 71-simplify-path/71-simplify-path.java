class Solution {
    public String simplifyPath(String path) {
        Deque<String> st = new LinkedList<>();
        path = path.replaceAll("//", "/");
        String[] dirs = path.split("/");

        for(String dir : dirs) {
            if(dir.isBlank()) {
                continue;
            } else if(dir.equals("..")) {
                if(st.isEmpty()) continue;
                st.pollLast();
            } else if(dir.equals(".")) {
                continue;
            } else {
                st.addLast(dir);
            }
        }

        StringBuilder sb = new StringBuilder("/");
        while(!st.isEmpty()) {
            sb.append(st.pollFirst());
            if(st.size() > 0) {
                sb.append("/");
            }
        }
        return sb.toString();
    }
    
}