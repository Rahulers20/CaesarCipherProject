package caesar;

import java.util.Scanner;

public class Main {

    public static String encrypt(String plainText, int shift) {
        if(shift > 26) {
            shift = shift%26;
        } else if(shift < 0) {
            shift = (shift % 26) + 26;
        }

        String cipherText = "";
        int length = plainText.length();

        for(int i= 0; i<length; i++) {
            char ch = plainText.charAt(i);
            if(Character.isLetter(ch)) {
                if(Character.isLowerCase(ch)) {
                    char c = (char)(ch + shift);
                    if(c > 'z') {
                        cipherText += (char)(ch - (26 - shift));
                    } else {
                        cipherText += c;
                    }
                } else if(Character.isUpperCase(ch)) {
                    char c = (char)(ch + shift);
                    if(c > 'Z') {
                        cipherText += (char)(ch - (26 - shift));
                    } else {
                        cipherText += c;
                    }
                }
            } else {
                cipherText += ch;
            }
        }

        return cipherText;
    }

    public static String decrypt(String plainText, int shift) {
        if(shift > 26) {
            shift = shift%26;
        } else if(shift < 0) {
            shift = (shift % 26) + 26;
        }

        String cipherText = "";
        int length = plainText.length();

        for(int i= 0; i<length; i++) {
            char ch = plainText.charAt(i);
            if(Character.isLetter(ch)) {
                if(Character.isLowerCase(ch)) {
                    char c = (char)(ch - shift);
                    if(c < 'a') {
                        cipherText += (char)(ch + (26 - shift));
                    } else {
                        cipherText += c;
                    }
                } else if(Character.isUpperCase(ch)) {
                    char c = (char)(ch - shift);
                    if(c < 'A') {
                        cipherText += (char)(ch + (26 - shift));
                    } else {
                        cipherText += c;
                    }
                }
            } else {
                cipherText += ch;
            }
        }

        return cipherText;
    }




    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);            // User Text
        String text = scnr.nextLine();

        //String text = "This is some message";           // For Manual purposes

        String cipher = encrypt(text, 5);
        System.out.println(cipher);
        String decrypted = decrypt(cipher, 5);
        System.out.println(decrypted);


    }
}
