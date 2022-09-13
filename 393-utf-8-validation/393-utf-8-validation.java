class Solution {
    public boolean validUtf8(int[] data) {
        if(data == null || data.length == 0) return false;
        boolean isValid = true;
        for(int i = 0; i < data.length; i++) {
            if(data[i] > 255) return false;
            int numberOfBytes = 0;
            if((data[i] & 128) == 0) numberOfBytes = 1;           // 0xxxxxxx
            else if((data[i] & 224) == 192) numberOfBytes = 2;    // 110xxxxx
            else if((data[i] & 240) == 224) numberOfBytes = 3;    // 1110xxxx
            else if((data[i] & 248) == 240) numberOfBytes = 4;    // 11110xxx
            else return false;

            for(int j = 1; j < numberOfBytes; j++) {
                if(i + j >= data.length) return false;
                if((data[i + j] & 192) != 128) return false;      // 11000000(192), 10000000(128)
            }
            i = i + numberOfBytes - 1;
        }
        return isValid;
    }
}