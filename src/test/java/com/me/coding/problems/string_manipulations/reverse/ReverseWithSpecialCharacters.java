package com.me.coding.problems.string_manipulations.reverse;

public class ReverseWithSpecialCharacters {

    public static void main(String[] args) {
        String str = "!@#! This is Test $%^";
        //Output: !@#! tseT si sihT $%^
        //        !@#! tseT si sihT $%^
        String[] s = str.split(" ");

        StringBuilder sb = new StringBuilder();
        sb.append(s[0]);
        StringBuilder sbb = new StringBuilder();;
        for (int i = 1; i < s.length - 1; i++) {
            sbb.append(s[i]).append(" ");
        }
        String reversed = reverse(sbb.toString());
        sb.append(reversed).append(" ").append(s[s.length - 1]);
        System.out.println(sb);
    }

    public static String reverse(String input) {
        char[] charArray = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = charArray.length - 1; i >= 0; i--) {
            sb.append(charArray[i]);
        }
        return sb.toString();
    }
}
