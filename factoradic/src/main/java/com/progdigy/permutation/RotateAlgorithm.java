package com.progdigy.permutation;

public class RotateAlgorithm extends Permutation {

    public RotateAlgorithm(int size) {
        super(size);
    }

    @Override
    public boolean next() {
        int offset = super.increment();
        if (offset >= 0) {
            rotate(base[offset], offset + 2);
            return true;
        }
        return false;
    }

    @Override
    public boolean previous() {
        int offset = super.decrement();
        if (offset >= 0) {
            rotate(offset + 1 - base[offset], offset + 2);
            return true;
        }
        return false;
    }

}
