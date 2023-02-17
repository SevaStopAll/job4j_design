package ru.job4j.ood.lsp;

public class CPU {
    protected int mhz;
    protected int cores;

    public CPU(int mhz, int cores) {
        this.mhz = mhz;
        checkCores(cores);
        this.cores = cores;
    }

    public void checkCores(int cores) {
        if (cores < 4) {
            throw new IllegalArgumentException("It's not a good made CPU");
        }
    }
}


class ARM extends CPU {

    public ARM(int mhz, int cores) {
        super(mhz, cores);
    }
}
