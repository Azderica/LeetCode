class Solution {
    static final String[] thousandNames = new String[] {"Thousand", "Million", "Billion"};
    static final String[] tenNames = new String[] {"Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    static final String[] oneNames = new String[] {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    static final String[] teenNames = new String[] {"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        
        StringBuilder word = new StringBuilder();
        appendNumber(num / 1000000000, 3, word);
        appendNumber((num % 1000000000) / 1000000, 2, word);
        appendNumber((num % 1000000) / 1000, 1, word);
        appendNumber(num % 1000, 0, word);
        
        return word.toString().trim();
    }
    
    private void appendNumber(int number, int thousands, StringBuilder sb) {
        if(number == 0) return;
        int hundreds = number / 100;
        if(hundreds > 0)
            sb.append(oneNames[hundreds - 1]).append(" Hundred").append(' ');
        int remainder = number % 100;
        if(remainder < 20 && remainder > 10) {
            sb.append(teenNames[remainder - 11]).append(' ');
        } else {
            int tens = (number % 100) / 10;
            int ones = number % 10;
            if(tens > 0) sb.append(tenNames[tens - 1]).append(' ');
            if(ones > 0) sb.append(oneNames[ones - 1]).append(' ');
        }
        if(thousands > 0) sb.append(thousandNames[thousands - 1]).append(' ');
    }
}