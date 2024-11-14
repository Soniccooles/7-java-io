package com.example.task02;

import java.io.IOException;

public class Task02Main {
    public static void main(String[] args) throws IOException {
        int current;
        boolean carried = false;
        while ((current = System.in.read()) != -1)
        {
            if (current == 13) { // встретили 13
                if (carried) { // если прошлый был 13, то пишем 13 (r)
                    System.out.write(13);
                }
                carried = true; // ставим carried в true
            }
            else if (current == 10) {
                if (carried) {
                    System.out.write(10); // если прошлое было 13 (флаг carried = true), тогда выводим только 10 (r\n\ -> n\)
                    carried = false; // ставим carried в false
                }
                else {
                    System.out.write(current); // если прошлое не 13, то просто выводим 10 (n)
                }
            }
            else {
                if (carried) { // если в целом другой байт и прошлое это 13, то выводим и 13, и этот байт
                    System.out.write(13);
                    carried = false;
                }
                System.out.write(current);
            }

        }
        if (carried)
        {
            System.out.write(13); // на случай, если последний байт это \r, то есть 13
        }
        System.out.flush(); // очищаем буфер
    }
}
