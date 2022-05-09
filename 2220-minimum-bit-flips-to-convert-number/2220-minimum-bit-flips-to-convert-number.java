class Solution {
    public int minBitFlips(int start, int goal) {
        String startBit = getBit(start);
        String endBit = getBit(goal);

        if (endBit.length() < startBit.length()) {
            String tmp = endBit;
            endBit = startBit;
            startBit = tmp;
        }

        StringBuilder zeros = new StringBuilder();
        for (int i = 0; i < endBit.length() - startBit.length(); i++)
            zeros.append("0");
        startBit = zeros.append(startBit).toString();

        int mintFlip = 0;
        for (int i = 0; i < startBit.length(); i++) {
            if (startBit.charAt(i) != endBit.charAt(i)) {
                mintFlip++;
            }
        }
        return mintFlip;
    }

    private String getBit(int value) {
        StringBuilder sb = new StringBuilder();
        while (value > 0) {
            sb.append(value % 2);
            value /= 2;
        }
        return sb.reverse().toString();
    }
}