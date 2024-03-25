
    import java.util.regex.Matcher;
import java.util.regex.Pattern;

    public class Task2 {
        public static void main(String[] args) {
            String text = "Мой номер телефона +375-29-1234567. Мой ник в Телеграм @TheGodFather.";

            // Найти номер телефона без кода
            Pattern phonePattern = Pattern.compile("(\\d{7})");
            Matcher phoneMatcher = phonePattern.matcher(text);
            if (phoneMatcher.find()) {
                String phoneNumber = phoneMatcher.group(1);
                System.out.println("Номер телефона без кода: " + phoneNumber);
            } else {
                System.out.println("Номер телефона не найден");
            }

            // Найти ник в телеграм без символа "@"
            Pattern telegramPattern = Pattern.compile("@(\\w+)");
            Matcher telegramMatcher = telegramPattern.matcher(text);
            if (telegramMatcher.find()) {
                String telegramNick = telegramMatcher.group(1);
                System.out.println("Ник в Телеграм: " + telegramNick);
            } else {
                System.out.println("Ник в Телеграм не найден");
            }
        }
    }

