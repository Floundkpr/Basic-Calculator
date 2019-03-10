public class Methods {
    static double stringToNumber (String input, int num_sys){

        String left = input.charAt(0) == '-' || input.charAt(0) == '+' ? input.substring(1, input.indexOf(',')) : input.substring(0, input.indexOf(','));
        String right = input.substring(input.indexOf(',') + 1);

        System.out.println(left + " " + right);

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
}
