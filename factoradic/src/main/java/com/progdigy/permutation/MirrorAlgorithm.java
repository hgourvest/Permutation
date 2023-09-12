package com.progdigy.permutation;

public class MirrorAlgorithm extends Permutation {
    public MirrorAlgorithm(int size) {
        super(size);
    }

    @Override
    public boolean next() {
        int offset = super.increment();
        if (offset >= 0) {
            mirror(offset + 1);
            return true;
        }
        return false;
    }

    @Override
    public boolean previous() {
        int offset = super.decrement();
        if (offset >= 0) {
            mirror(offset + 1);
            return true;
        }
        return false;
    }

    @Override
    public boolean setOrder(int[] value) {
        if (value.length == order.length) {
            init();
            for (int i = value.length - 1; i > 0 ; i--) {
                int search = value[i];
                int diff = 0;
                int j = 0;
                for (; j < i; j ++)
                    if (search == order[j]) {
                        diff = i - j;
                        rotate(diff, i + 1);
                        break;
                    }
                if (diff == 0 && search != order[j])
                    return false;
                base[i - 1] = diff;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void sync() {
        init();
        for (int i = base.length - 1; i >= 0 ; i--)
            rotate(base[i], i + 2);
    }

    @Override
    public void last() {
        gotoLast();
        int len = order.length;
        for (int i = 0; i < len; i++)
            order[i] = len - i - 1;
    }
}
