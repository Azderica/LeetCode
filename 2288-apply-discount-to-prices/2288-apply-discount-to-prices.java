class Solution {
    public String discountPrices(String sentence, int discount) {
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split(" ");
        for(String word: words) {
            if(isPrice(word)) {
                double price = Math.floor(Double.valueOf(word.substring(1)) * (100 - discount)) / 100;
                sb.append("$").append(String.format("%.2f", price)).append(" ");
            } else {
                sb.append(word).append(" ");
            }
        }
        sb.deleteCharAt(sb.lastIndexOf(" "));
        return sb.toString();
    }

    private boolean isPrice(String word){
        if(word.charAt(0) != '$' || word.length() == 1) return false;
        int pointCount = 0;
        for(int i = 1; i < word.length(); i++) {
            if(pointCount > 1) return false;
            if(word.charAt(i) == '.') pointCount++;
            if(word.charAt(i) < '0' || word.charAt(i) > '9') return false;
        }
        return true;
    }
}