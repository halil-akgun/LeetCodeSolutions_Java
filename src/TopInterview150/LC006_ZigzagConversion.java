package TopInterview150;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
(you may want to display this pattern in a fixed font for better legibility)

    P   A   H   N
    A P L S I I G
    Y   I   R

And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

    string convert(string s, int numRows);

Example 1:
Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"

Example 2:
Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I

Example 3:
Input: s = "A", numRows = 1
Output: "A"
 */
public class LC006_ZigzagConversion {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3)); // PAHNAPLSIIGYIR
        System.out.println(convert("PAYPALISHIRING", 4)); // PINALSIGYAHRPI
        System.out.println(convert("A", 1)); // A
        System.out.println(convert("ABC", 2)); // ACB

    }

    public static String convert(String s, int numRows) {
        // way 1
//        if (numRows == 1 || numRows >= s.length()) return s;
//        String[][] a = new String[numRows][(s.length() / 2) + 1];
//        c(a, s, numRows);
//        StringBuilder r = new StringBuilder();
//        for (String[] strings : a) {
//            r.append(Arrays.stream(strings).filter(Objects::nonNull).collect(Collectors.joining()));
//        }
//        return r.toString();

        // way 2
        if (numRows == 1 || numRows >= s.length()) return s;

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int i = 0, step = 1;
        for (char c : s.toCharArray()) {
            rows[i].append(c);
            if (i == 0) step = 1;
            else if (i == rows.length - 1) step = -1;
            i += step;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }

//    private static void c(String[][] a, String s, int numRows) {
//        int col = 0;
//        int row = 0;
//        int idx = 0;
//        while (true) {
//            for (int i = 0; i < numRows; i++) {
//                if (idx == s.length()) return;
//                a[row++][col] = s.substring(idx, idx + 1);
//                idx++;
//            }
//            row--;
//            for (int i = 0; i < numRows - 2; i++) {
//                if (idx == s.length()) return;
//                a[--row][++col] = s.substring(idx, idx + 1);
//                idx++;
//            }
//            col++;
//            row--;
//        }
//    }
}
