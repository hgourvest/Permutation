package com.progdigy;

import com.progdigy.permutation.*;

public class Main {

    public static void main(String[] args) {
        String TABLE = "12345";
        Permutation p = new MirrorAlgorithm(TABLE.length());
        do {
            System.out.println(p.apply(TABLE));
        } while (p.next());
    }

}