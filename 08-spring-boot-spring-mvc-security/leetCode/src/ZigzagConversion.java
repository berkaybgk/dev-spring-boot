import java.util.ArrayList;

public class ZigzagConversion {

    public static void main(String[] args) {

        String s = "PAYPALISHIRING";
        int numRows = 4;

        System.out.println(convert(s,numRows));

    }

    public static String convert(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }

        ArrayList<ArrayList<String>> twoDArrayList = new ArrayList<>();
        for (int row = 0; row< numRows; row++) {
            twoDArrayList.add(new ArrayList<String>());
        }

        int variableRowNum = 0;
        int direction = +1;

        for (int i = 0; i< s.length(); i++ ) {

            String currentChar = s.charAt(i) + "";


            twoDArrayList.get(variableRowNum).add(currentChar);
            variableRowNum += direction;

            // change direction if reached the bound
            if ((variableRowNum == 0) || (variableRowNum == numRows-1)) {
                direction *= -1;
            }

        }

        String toReturn = "";

        for (ArrayList<String> row: twoDArrayList) {
            for (String character: row) {
                toReturn += character;
            }
        }

        return toReturn;
    }
}
