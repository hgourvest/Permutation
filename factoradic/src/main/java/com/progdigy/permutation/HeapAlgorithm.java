/*
 * Heap's algorithm
 * https://en.wikipedia.org/wiki/Heap%27s_algorithm
 *
 */

package com.progdigy.permutation;

public class HeapAlgorithm extends Permutation {
    public HeapAlgorithm(int size) {
        super(size);
    }

    @Override
    public boolean next() {
        int offset = super.increment();
        if (offset >= 0) {
            int a = (offset % 2 != 0) ? 0 : base[offset] - 1;
            int b = offset + 1;
            swap(a, b);
            return true;
        }
        return false;
    }

    @Override
    public boolean previous() {
        int offset = super.decrement();
        if (offset >= 0) {
            int a = (offset % 2 != 0) ? 0 : base[offset];
            int b = offset + 1;
            swap(a, b);
            return true;
        }
        return false;
    }

    @Override
    public void last() {
        init();
        int len = order.length;
        if (len % 2 != 0) {
            swap(0, len - 1);
        } else {
            rotate(len - 1, len);
            if (len >= 6)
                rotate(2, len - 2);
        }
        gotoLast();
    }

    @Override
    protected void sync() {
        init();
        for (int offset = base.length - 1; offset >= 0 ; offset--) {
            int count = base[offset];
            if (count > 0) {
                if (offset % 2 != 0) {
                    for (int x = 0; x < count; x++) {
                        swap(0, offset - 1);
                        rotate(1, offset + 2);
                        if (offset > 1)
                            swap(offset - 1, offset + 1);
                    }
                } else {
                    for (int x = 0; x < count; x++) {
                        swap(0, offset);
                        swap(x, offset + 1);
                    }
                }
            }
        }
    }

}
