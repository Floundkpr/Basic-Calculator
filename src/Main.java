import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Инициализация объекта date
        Date dateNow = new Date();

        // Вывод текущей даты и времени с использованием toString()
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("ddMMyyyy_HHmmss");

        try(FileWriter writer = new FileWriter("./SomeDir/" + formatForDateNow.format(dateNow) + ".txt", false))
        {
            // запись всей строки
            String text = "Hello Gold!";
            writer.write(text);
            // запись по символам
            writer.append('\n');
            writer.append('E');

            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        System.out.println("Текущая дата " + formatForDateNow.format(dateNow));
    }
}
