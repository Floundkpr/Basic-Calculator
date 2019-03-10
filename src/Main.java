import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try(FileReader reader = new FileReader("./Data/Input.txt"))
        {
            // читаем посимвольно
            int c;
            String num = "";
            while((c = reader.read()) != 10 && c != -1) {

                num = num + (char) c;
            }

            num = "";
            while((c = reader.read()) != 10 && c != -1) {

                num = num + (char) c;
            }

        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }




        /*
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
        */
    }
}
