import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {


















        // Инициализация объекта date
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("ddMMyyyy_HHmmss");

        try(FileWriter writer = new FileWriter("./Log/" + formatForDateNow.format(dateNow) + ".txt", false))
        {
            // запись всей строки
            String text = "Hello Gold!";    // Инициализация строки которая будет записана в файл
            writer.write(text);             //Запись строки в открытый файл
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
