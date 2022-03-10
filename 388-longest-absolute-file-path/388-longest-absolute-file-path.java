class Solution {
    public int lengthLongestPath(String input) {
        String[] lines = input.split("\n");
        int longestPath = 0, n = lines.length;

        if (n <= 1) {
            if(input.contains("."))
                return input.length();
            return 0;
        }

        int[] depth = new int[n];
        for (int i = 0; i < n; i++) {
            depth[i] = getPatternOccurrences(lines[i], "\t");
            lines[i] = lines[i].replaceAll("\t", "");
        }

        // if line is file, get size and compare with longest path
        for(int i = 0; i < n; i++) {
            if(isFile(lines[i])) {
                int curLength = lines[i].length();
                int curDepth = depth[i];

                for(int j = i - 1; j >=0; j--) {
                    // 부모인 디렉토리인 경우
                    if(curDepth > depth[j]) {
                        curLength += lines[j].length() + 1;
                        curDepth = depth[j];
                    }
                    if(curDepth == 0) break;
                }
                if(curLength > longestPath) {
                    longestPath = curLength;
                }
            }
        }

        return longestPath;
    }

    private int getPatternOccurrences(String s, String pattern) {
        int lastIndex = 0, count = 0;
        while (lastIndex != -1) {
            lastIndex = s.indexOf(pattern, lastIndex);
            if (lastIndex != -1) {
                count++;
                lastIndex += pattern.length();
            }
        }
        return count;
    }

    private boolean isFile(String s) {
        return s.contains(".");
    }
}