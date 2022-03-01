class Solution {
    public String getHint(String secret, String guess) {
        // exception case
        if(secret.length() != guess.length()) {
            System.err.println("size is different.");
        }

        int[] secretNumber = new int[10];
        int[] guessNumber = new int[10];
        int n = secret.length(), bulls = 0, cows = 0;
        for(int i = 0; i < n; i++) {
            if(secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            }
            secretNumber[secret.charAt(i) - '0']++;
            guessNumber[guess.charAt(i) - '0']++;
        }

        // check cows
        for(int i = 0; i < 10; i++) {
            cows += Math.min(secretNumber[i], guessNumber[i]);
        }
        cows -= bulls;

        return bulls + "A" + cows + "B";
    }
}