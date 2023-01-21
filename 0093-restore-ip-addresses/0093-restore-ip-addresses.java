class Solution {
    private boolean isValid(String s, int start, int legnth) {
        return legnth == 1
                || (s.charAt(start) != '0' && (legnth < 3 || s.substring(start, start + legnth).compareTo("255") <= 0));
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        for (int i = Math.max(1, s.length() - 9); i <= 3 && i <= s.length() - 3; ++i) {
            if (!isValid(s, 0, i)) continue;

            for (int j = Math.max(1, s.length() - i - 6); j <= 3 && j <= s.length() - i - 2; ++j) {
                if (!isValid(s, i, j)) continue;

                for (int k = Math.max(1, s.length() - i - j - 3); k <= 3 && k <= s.length() - i - j - 1; ++k) {
                    if (isValid(s, i + j, k) && isValid(s, i + j + k, s.length() - i - j - k)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(s.substring(0, i)).append(".");
                        sb.append(s.substring(i, i + j)).append(".");
                        sb.append(s.substring(i + j, i + j + k)).append(".");
                        sb.append(s.substring(i + j + k));
                        res.add(sb.toString());
                    }
                }
            }

        }
        return res;
    }
}