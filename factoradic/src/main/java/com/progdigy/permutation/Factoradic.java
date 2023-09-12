/*
 *  Factorial number system
 *  https://en.wikipedia.org/wiki/Factorial_number_system
 *
 * */

package com.progdigy.permutation;

import java.util.Arrays;

public class Factoradic {
    protected int[] base;

    public Factoradic(int size) {
        if (size <= 0)
            throw new IllegalArgumentException();
        base = new int[size];
    }

    public int[] getBase() {
        return base;
    }

    public boolean setBase(int[] base) {
        if (base != null && base.length == this.base.length) {
            System.arraycopy(base, 0, this.base, 0, base.length);
            return true;
        }
        return false;
    }

    public int getIndex() {
        int factorial = 1;
        int ret = 0;
        for (int i = 0; i < base.length; i++) {
            ret += base[i] * factorial;
            factorial *= i + 2;
        }
        return ret;
    }

    public boolean setIndex(int value) {
        int factorial = 1;
        int modulo = 2;
        int remain = value;
        for (int i = 0; i < base.length; i++) {
            int v = (remain / factorial) % modulo;
            base[i] = v;
            remain -= v * factorial;
            factorial *= i + 2;
            modulo++;
        }
        return remain == 0;
    }

    protected int increment() {
        for (int i = 0; i < base.length; i++) {
            int value = base[i];
            if (value <= i) {
                base[i] = ++value;
                return i;
            } else
                base[i] = 0;
        }
        return -1;
    }

    protected int decrement() {
        for (int i = 0; i < base.length; i++) {
            int value = base[i];
            if (value > 0) {
                base[i] = --value;
                return i;
            } else
                base[i] = i + 1;
        }
        return -1;
    }

    protected void gotoFirst() {
        Arrays.fill(base, 0);
    }

    protected void gotoLast() {
        for (int i = 0; i < base.length; i++)
            base[i] = i + 1;
    }

    public void first() {
       gotoFirst();
    }

    public void last() {
       gotoLast();
    }

    public boolean next() {
        return increment() >= 0;
    }

    public boolean previous() {
        return decrement() >= 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Factoradic item = (Factoradic) o;
        return Arrays.equals(base, item.base);
    }

    @Override
    public int hashCode() {
        return getIndex();
    }

    @Override
    public String toString() {
        return Arrays.toString(base);
    }
}
