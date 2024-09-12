package lesson4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Symbol {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String symbol = sc.next();
       Pattern pattern = Pattern.compile(">>-->|<--<<");
       Matcher matcher = pattern.matcher(symbol);
       long count = matcher.results().count();
       System.out.println(count);
    }
}
