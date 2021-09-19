import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'dayOfProgrammer' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER year as parameter.
     */

    public static String dayOfProgrammer(int year) {
        int day = 0, month = 9;
        if (year == 1918) {
            day = 26;
            month = 9;
        } else if (year >= 1919) {
            if (((year % 100 == 0) || (year % 4 != 0)) && (year % 400 != 0)) {
                day = 13;
            } else {
                day = 12;
            }
        } else if (year >= 1700) {
            day = year % 4 == 0 ? 12 : 13;
        }
        return getFormattedDateString(day, month, year);
    }
    
    public static String getFormattedDateString(int day, int month, int year) {
        String dateString = "";
        dateString += day < 10 ? "0" + String.valueOf(day) : String.valueOf(day);
        dateString += ".";
        dateString += month < 10 ? "0" + String.valueOf(month) : String.valueOf(month);
        dateString += ".";
        dateString += String.valueOf(year);
        return dateString;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
