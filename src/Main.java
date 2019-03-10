import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Инициализация объекта date
        Date dateNow = new Date();

        // Вывод текущей даты и времени с использованием toString()
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("ddMMyyyy_HHmmss");

        System.out.println("Текущая дата " + formatForDateNow.format(dateNow));
    }
}
