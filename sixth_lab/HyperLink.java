package fifth_java_lab;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HyperLink {
    public static void main(String[] args) {
        String text = "Пример текста с ссылкой: http://www.ahahaha.com";

        try {
            String replacedText = replaceLinks(text);
            System.out.println(replacedText);
        } catch (Exception e) {
            System.out.println("Ошибка при замене ссылок: " + e.getMessage());
        }
    }

    public static String replaceLinks(String text) throws Exception {
        // Паттерн для поиска ссылок
        Pattern pattern = Pattern.compile("(http|https)://[\\w\\d\\-_]+(\\.[\\w\\d\\-_]+)+([\\w\\d\\-.,@?^=%&:/~+#]*[\\w\\d\\-@?^=%&/~+#])?");
        Matcher matcher = pattern.matcher(text);

        // Замена ссылок на гиперссылки
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String link = matcher.group();
            matcher.appendReplacement(stringBuffer, "<a href='" + link + "'>" + link + "</a>");
        }
        matcher.appendTail(stringBuffer);

        return stringBuffer.toString();
    }
}

