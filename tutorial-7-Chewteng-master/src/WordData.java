public class WordData {

    private String wordLength, word;

    public WordData(String column1, String column2) {
        this.wordLength = column1;
        this.word = column2;
    }


    public String getWordLength() {
        return wordLength;
    }


    public void setWordLength(String column1) {
        this.wordLength = column1;
    }


    public String getWord() {
        return word;
    }


    public void setWord(String column2) {
        this.word = column2;
    }

}
