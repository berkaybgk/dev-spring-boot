public class IntToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }


    public static String intToRoman(int integer) {
        int varInteger = integer;
        String romanString = "";

        while (varInteger >= 1000) {
            romanString += "M";
            varInteger -= 1000;
        }

        // after this step our integer has been reduced to maximum of 3 digits
        // similar rule is applied from now on

        String varString = varInteger + "";
        int ordOfMag = varString.length()-1;

        for (int i=0; i<varString.length(); i++) {
            romanString += romanEquivalent(Integer.parseInt(String.valueOf(varString.charAt(i))),ordOfMag--);
        }

        return romanString;
    }

    public static String romanEquivalent(int digit, int orderOfMagnitude) {
        String[] romanArray = {"M","D","C","L","X","V","I"};

        // special case in which we need the subtraction rule, digits 4 and 9
        if (digit == 0)
            return "";

        else if ((digit == 4) || (digit == 9)) {
            if (digit == 9) {
                if (orderOfMagnitude == 2)
                    return "CM";
                else if (orderOfMagnitude == 1)
                    return "XC";
                else if (orderOfMagnitude == 0)
                        return "IX";
            }
            else {
                if (orderOfMagnitude == 2)
                    return "CD";
                else if (orderOfMagnitude == 1)
                    return "XL";
                else if (orderOfMagnitude == 0)
                    return "IV";
            }
        }

        else if ((digit == 1) || (digit == 2) || (digit == 3)) {
            if (orderOfMagnitude == 2)
                return "C".repeat(digit);
            else if (orderOfMagnitude == 1)
                return "X".repeat(digit);
            else if (orderOfMagnitude == 0)
                return "I".repeat(digit);
        }

        else if (digit == 5) {
            if (orderOfMagnitude == 2)
                return "D";
            else if (orderOfMagnitude == 1)
                return "L";
            else if (orderOfMagnitude == 0)
                return "V";
        }

        else { // digit is either 6,7,8
            if (orderOfMagnitude == 2)
                return "D"+"C".repeat(digit%5);
            else if (orderOfMagnitude == 1)
                return "L"+"X".repeat(digit%5);
            else if (orderOfMagnitude == 0)
                return "V"+"I".repeat(digit%5);
        }

        return "";
    }

}
