class Solution {
    public int percentageLetter(String s, char letter) {
        int count = (int) s.chars().mapToObj(c -> (char) c).filter(c -> c.equals(letter)).count();
        return count * 100 / s.length();
    }
}