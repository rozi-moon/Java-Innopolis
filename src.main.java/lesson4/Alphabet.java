package lesson4;

import java.util.Scanner;

public class Alphabet {
    public static void main(String[] args) {
        String alphabet = "qwertyuiopasdfghjklzxcvbnm";
        Scanner sc = new Scanner(System.in);
        String ch = sc.next();
        if(ch.equals("q")) {
            System.out.println("m");
        }
        else {
            Integer index = alphabet.indexOf(ch);
            char str = alphabet.charAt(index - 1);
            System.out.println(str);{

            }

        }

    }
}
