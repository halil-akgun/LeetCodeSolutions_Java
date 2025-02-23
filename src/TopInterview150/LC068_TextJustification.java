package TopInterview150;

import java.util.ArrayList;
import java.util.List;

/*
Given an array of strings words and a width maxWidth, format the text such that each line has
exactly maxWidth characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line.
Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not
divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left-justified, and no extra space is inserted between words.

Note:
 - A word is defined as a character sequence consisting of non-space characters only.
 - Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 - The input array words contains at least one word.

Example 1:
Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]

Example 2:
Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
Output:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
Explanation: Note that the last line is "shall be    " instead of "shall     be",
because the last line must be left-justified instead of fully-justified.
Note that the second line is also left-justified because it contains only one word.

Example 3:
Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a",
"computer.","Art","is","everything","else","we","do"], maxWidth = 20
Output:
[
  "Science  is  what we",
  "understand      well",
  "enough to explain to",
  "a  computer.  Art is",
  "everything  else  we",
  "do                  "
]
 */
public class LC068_TextJustification {
    public static void main(String[] args) {
        System.out.println(fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));
        // [
        //   "This    is    an",
        //   "example  of text",
        //   "justification.  "
        // ]
        System.out.println(fullJustify(new String[]{"What", "must", "be", "acknowledgment", "shall", "be"}, 16));
        // [
        //  "What   must   be",
        //  "acknowledgment  ",
        //  "shall be        "
        // ]
        System.out.println(fullJustify(new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"}, 20));
        // [
        //  "Science  is  what we",
        //  "understand      well",
        //  "enough to explain to",
        //  "a  computer.  Art is",
        //  "everything  else  we",
        //  "do                  "
        // ]

    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0;

        while (index < words.length) {
            int count = words[index].length();
            int last = index + 1;
            while (last < words.length) {
                if (count + 1 + words[last].length() > maxWidth) break;
                count += 1 + words[last].length();
                last++;
            }

            StringBuilder line = new StringBuilder();
            int numWords = last - index;
            if (last == words.length || numWords == 1) {
                for (int i = index; i < last; i++) {
                    line.append(words[i]);
                    if (i < last - 1) line.append(" ");
                }
                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            } else {
                int totalSpaces = maxWidth - count + (numWords - 1);
                int spaceBetween = totalSpaces / (numWords - 1);
                int extraSpaces = totalSpaces % (numWords - 1);

                for (int i = index; i < last; i++) {
                    line.append(words[i]);
                    if (i < last - 1) {
                        line.append(" ".repeat(Math.max(0, spaceBetween + (i - index < extraSpaces ? 1 : 0))));
                    }
                }
            }

            result.add(line.toString());
            index = last;
        }
        return result;
    }
}
