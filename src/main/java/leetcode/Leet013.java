package leetcode;

/**
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from
 * 1 to 3999.
 * 
 * Link: https://leetcode.com/problems/roman-to-integer/description/
 * 
 * @author abijwe
 */
public class Leet013 {

    public int romanToInt(String s) {
        int index = 0;
        int sum = 0;
        while (index < s.length()) {
            int count = 1;
            char c = s.charAt(index);
            if (c == 'M') {
                //M then look for 0 or more M
                count = lookForMore('M', index, s);
                sum += count * 1000;
            } else if (c == 'D') {
                //D then look for 0 or more C
                count = lookForMore('C', index + 1, s);
                sum += (500 + count*100);
                count++;
            } else if (c == 'C') {
                //C then look for 0 or more C or one D or one M
                char nextChar = getNextChar(s, index);
                if (nextChar == 'D') {
                    sum += 400;
                    count = 2;
                } else if (nextChar == 'M') {
                    sum += 900;
                    count = 2;
                } else {
                    count = lookForMore('C', index, s);
                    sum += count*100;
                }
            } else if (c == 'L') {
                //L then look for 0 or more X
                count = lookForMore('X', index + 1, s);
                sum += (50 + count*10);
                count++;
            } else if (c == 'X') {
                //X then look for one L or 0 or more X or one C
                char nextChar = getNextChar(s, index);
                if (nextChar == 'L') {
                    sum += 40;
                    count = 2;
                } else if (nextChar == 'C') {
                    sum += 90;
                    count = 2;
                } else {
                    count = lookForMore('X', index, s);
                    sum += (count * 10);
                }
            } else if (c == 'V') {
                //V then look for 0 or more I
                count = lookForMore('I', index + 1, s);
                sum += 5 + count;
                count++;
            } else if (c == 'I') {
                //I then look for one V or one X or 0 or more I
                char nextChar = getNextChar(s, index);
                if (nextChar == 'X') {
                    sum += 9;
                } else if (nextChar == 'V') {
                    sum += 4;
                } else {
                    count = lookForMore('I', index, s);
                    sum += count;
                }
                break;
            }
            index += count;
        }
        return sum;
    }

    private char getNextChar(String s, int index) {
        return index + 1 < s.length() ? s.charAt(index + 1) : '0';
    }

    private int lookForMore(char m, int index, String s) {
        int count = 0;
        while (index < s.length() && s.charAt(index) == m) { count++; index++;}
        return count;
    }
}
