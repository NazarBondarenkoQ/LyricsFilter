import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Lyrics lyrics = new Lyrics();
        String[] text = lyrics.readLines();
        String[] censored = {"fucking", "fuck", "dick", "cunt"};
        String[] splitString = lyrics.lyricsChecker(text);
        lyrics.countWords(censored,splitString);
        lyrics.wordRepeat(splitString);
    }

}
