package fifth_lab;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("ura.txt");
            FileWriter writer = new FileWriter("plg.txt");

            int character;
            while ((character = reader.read()) != -1) {
                writer.write(character);
            }

            reader.close();
            writer.close();

            System.out.println("Содержимое файла успешно скопировано.");
        } catch (IOException e) {
            System.out.println("Ошибка при чтении или записи файла: " + e.getMessage());
        }
    }
}

