package com.progdigy.permutation;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.Arrays;

public abstract class Permutation extends Factoradic {
    protected final int[] order;

    protected Permutation(int size) {
        super(size - 1);
        order = new int[size];
        init();
    }

    protected void init() {
        for (int i = 0; i < order.length; i++)
            order[i] = i;
    }

    // Juggling Algorithm without using GCD
    protected void rotate(int count, int size) {
        if (count > 0) {
            int total = 0, start = 0;
            while (total < size) {
                int prevIndex = start;
                int prevValue = order[start];
                do {
                    int nextIndex = (prevIndex + count) % size;
                    int nextValue = order[nextIndex];
                    order[nextIndex] = prevValue;
                    prevValue = nextValue;
                    prevIndex = nextIndex;
                    total++;
                } while (prevIndex != start);
                start++;
            }
        }
    }

    protected void swap(int a, int b) {
        if (a != b) {
            int tmp = order[a];
            order[a] = order[b];
            order[b] = tmp;
        }
    }

    protected void mirror(int size) {
        int from = 0, to = size;
        while (from < to) {
            int a = from++;
            int b = to--;
            int tmp = order[a];
            order[a] = order[b];
            order[b] = tmp;
        }
    }

    protected void sync() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void first() {
        gotoFirst();
        init();
    }

    @Override
    public void last() {
        gotoLast();
        sync();
    }

    @Override
    public abstract boolean next();

    @Override
    public abstract boolean previous();

    @Override
    public boolean setIndex(int value) {
        if (super.setIndex(value)) {
            sync();
            return true;
        }
        return false;
    }

    @Override
    public boolean setBase(int[] base) {
        if (super.setBase(base)) {
            sync();
            return true;
        }
        return false;
    }

    public int[] getOrder() {
        return order;
    }

    public boolean setOrder(int[] value) {
        throw new UnsupportedOperationException();
    }

    public String apply(CharSequence from) {
        if (from != null && from.length() == order.length) {
            char[] ret = new char[order.length];
            for (int i = 0; i < order.length; i++) {
                ret[i] = from.charAt(order[i]);
            }
            return new String(ret);
        }
        return null;
    }

    public Object[] apply(Object[] from) {
        if (from != null && from.length == order.length) {
            Object[] ret = new Object[order.length];
            for (int i = 0; i < order.length; i++) {
                ret[i] = from[order[i]];
            }
            return ret;
        }
        return null;
    }

    public boolean apply(Object[] from, Object[] to) {
        if (from != null && from.length == order.length) {
            for (int i = 0; i < order.length; i++) {
                to[i] = from[order[i]];
            }
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return Arrays.toString(order);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Permutation permutation = (Permutation) o;
        return Arrays.equals(order, permutation.order) && Arrays.equals(base, permutation.base);
    }
}
