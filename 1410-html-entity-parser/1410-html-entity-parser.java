class Solution {
    public String entityParser(String text) {
        if(text == null || text.isEmpty()) return "";
        Map<String, String> replaceMap = Map.of(
                "&quot;", "\"",
                "&apos;", "'",
                "&gt;", ">",
                "&lt;", "<",
                "&frasl;", "/");
        for(String key : replaceMap.keySet()) {
            text = text.replaceAll(key, replaceMap.get(key));
        }
        return text.replaceAll("&amp;", "&");
    }
}