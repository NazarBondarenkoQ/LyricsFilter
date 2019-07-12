import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static java.util.stream.Collectors.toMap;

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
