import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static java.util.stream.Collectors.toMap;

class Lyrics {

    String[] readLines() throws IOException {
        FileReader fileReader = new FileReader("src/data.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        bufferedReader.close();
        return lines.toArray(new String[0]);
    }

    String[] lyricsChecker(String[] lyrics) {
        StringBuilder builder = new StringBuilder();
        System.out.println("Lamb of God - Faded Line (lyrics):");
        System.out.println("==================================");
        for (String s : lyrics) {
            System.out.println(s);
            builder.append(s);
        }
        String a = builder.toString();
        return a.split(" ");
    }

    void countWords(String[] censored, String[] lyrics){
        int wordsCounter = lyrics.length;
        List<String> censoredList = new ArrayList<>();
        System.out.println("=================================================");
        for (String s : censored) {
            for (String lyric : lyrics) {
                if (s.equalsIgnoreCase(lyric)) {
                    censoredList.add(lyric);
                }
            }
        }
        for (String lyric : lyrics) {
            if (lyric.length() < 3) {
                censoredList.add(lyric);
            }
        }
        System.out.println("Number of words in the lyrics (without exceptions): " + (wordsCounter - censoredList.size()));
        System.out.println("=================================================");
        System.out.println("Number of filtered words:  " + censoredList.size());
        System.out.println("=================================================");
    }

    void wordRepeat(String[] lyrics) {
        Map<String, Integer> repeats = new HashMap<>();
        for (String word : lyrics) {
            Integer repeater = repeats.get(word);
            if (repeater == null) {
                repeater = 0;
            }
            repeats.put(word, repeater + 1);
        }
        LinkedHashMap<String, Integer> result = repeats.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));
        Iterator iterator = result.entrySet().iterator();
        for (int i = 0; i <= 5; i++) {
            Map.Entry pair = (Map.Entry) iterator.next();
            System.out.println("Word: \"" + pair.getKey() + "\" repeats: " + pair.getValue() + " times.");
        }
        System.out.println("=================================================");
    }
}
