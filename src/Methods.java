import java.io.FileReader;
import java.io.FileWriter;

class Methods {

    static String[] readFromFile (){
        String[] out = {"",""};
        try(FileReader reader = new FileReader("./Data/Input.txt"))
        {
            int chr;
            while((chr = reader.read()) != 13 && chr != -1) {

                out[0] = out[0] + (char) chr;

            }
            chr = reader.read();
            while((chr = reader.read()) != 13 && chr != -1) {

                out[1] = out[1] + (char) chr;
            }
            return out;
        }
        catch(Exception ex) {
            out[0] = "0";
            out[1] = "0";
            System.out.println(ex.getMessage());
            return out;
        }
    }

    static double stringToNumber (String input, int num_sys){

        input = input + ',';
        String left = input.charAt(0) == '-' || input.charAt(0) == '+' ? input.substring(1, input.indexOf(',')) : input.substring(0, input.indexOf(','));
        String right = input.substring(input.indexOf(',') + 1);

        double integer_part = 0;
        double fractional_part = 0;

        for (int i = 0; i < left.length(); i++)
        {
            integer_part += Math.pow(num_sys, i) * Character.getNumericValue(left.charAt(left.length() - i - 1));
        }
        
        for (int i = 0; right.length() > 0 && (right.charAt(right.length() - 1) == ',' ? i < right.length() - 1 : i < right.length()); i++)
        {
            fractional_part += Math.pow(num_sys, (i + 1) * -1) * Character.getNumericValue(right.charAt(i));
        }

        return input.charAt(0) == '-' ? (integer_part + fractional_part) * -1 : integer_part + fractional_part;
    }

    static StringBuilder numberToString(double num, int num_sys, int numbersOfFraction) {
        StringBuilder result = new StringBuilder();

        int ceil = (int) Math.floor(num);
        double fraction = num - ceil;

        do {
            if (num_sys > 10) {
                switch (ceil % num_sys) {
                    case 10:
                        result.append("A");
                        break;
                    case 11:
                        result.append("B");
                        break;
                    case 12:
                        result.append("C");
                        break;
                    case 13:
                        result.append("D");
                        break;
                    case 14:
                        result.append("E");
                        break;
                    case 15:
                        result.append("F");
                        break;
                    default:
                        result.append(ceil % num_sys);
                        break;
                }
            } else result.append(ceil % num_sys);
            ceil = (int) Math.floor((double) ceil / num_sys);
        } while (ceil != 0);

        result.reverse().append(",");

        for (int i = 0; i < numbersOfFraction; i++){
            if (num_sys > 10) {
                switch ((int)Math.floor(fraction * num_sys)) {
                    case 10:
                        result.append("A");
                        break;
                    case 11:
                        result.append("B");
                        break;
                    case 12:
                        result.append("C");
                        break;
                    case 13:
                        result.append("D");
                        break;
                    case 14:
                        result.append("E");
                        break;
                    case 15:
                        result.append("F");
                        break;
                    default:
                        result.append((int)Math.floor(fraction * num_sys));
                        break;
                }
            } else {
                 result.append((int)Math.floor(fraction * num_sys));
            }
            fraction = fraction * num_sys - Math.floor(fraction * num_sys);
        }

        return result;
    }

    static void toProtocol(String[] protocol){
        try(FileWriter writer = new FileWriter("./Data/Protocol.txt", false))
        {
            for (String s : protocol) {
                writer.write(s);
                writer.append('\n');
            }
                         //Запись строки в открытый файл
            writer.flush();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }



}
