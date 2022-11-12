class Solution {
    public String arrangeWords(String text) {
        StringBuilder sb = new StringBuilder();
        List<String> wordList = new ArrayList<>();
        String[] words = text.split(" ");

        for(String word : words) {
            wordList.add(word.toLowerCase());
        }
        wordList.sort(Comparator.comparingInt(String::length));

        for(int i = 0; i < wordList.size(); i++) {
            if(i == 0) {
                String first = wordList.get(i);
                sb.append(first.substring(0, 1).toUpperCase() + first.substring(1));
            } else {
                sb.append(wordList.get(i));
            }

            if(i != wordList.size() - 1)
                sb.append(" ");
        }
        return sb.toString();
    }
}