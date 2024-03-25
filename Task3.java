import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

interface Search {
    void searchWord(String word) throws IOException;
}

class BookReader implements Search {
    private String bookContent;

    public BookReader(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            content.append(line);
        }
        reader.close();
        bookContent = content.toString();
    }

    public void searchWord(String word) {
        String[] words = bookContent.split("\\s+");
        int count = 0;
        for (String w : words) {
            if (w.equalsIgnoreCase(word)) {
                count++;
            }
        }
        System.out.println("Слово '" + word + "' встречается " + count + " раз.");
    }

    public void searchWithRegex(String regex) {
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(bookContent);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        System.out.println("Выражение '" + regex + "' встречается " + count + " раз.");
    }
}

public class Task3 {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Lenovo\\Downloads/Война и мир.txt";
        try {
            BookReader bookReader = new BookReader(filePath);
            String wordToSearch = "война";
            bookReader.searchWord(wordToSearch);
            wordToSearch = "мир";
            bookReader.searchWord(wordToSearch);
            wordToSearch = "и";
            bookReader.searchWord(wordToSearch);

            System.out.println("\nПоиск с использованием регулярных выражений:");
            String regex = "война|мир|и";
            bookReader.searchWithRegex(regex);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}