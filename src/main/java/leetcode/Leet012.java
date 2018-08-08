package leetcode;

/**
 * Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from
 * 1 to 3999.
 * 
 * Link: https://leetcode.com/problems/integer-to-roman/description/
 * 
 * @author abijwe
 */
public class Leet012 {

    String[] units = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    String[] thousands = {"", "M", "MM", "MMM"};
    public String intToRoman(int i) {
        StringBuilder builder = new StringBuilder();
        int unit = i%10;
        int ten = (i%100)/10;
        int hundred = (i%1000)/100;
        int thousand = (i%10000)/1000;

        builder.append(thousands[thousand]).append(hundreds[hundred]).append(tens[ten]).append(units[unit]);
        return builder.toString();
    }

}
