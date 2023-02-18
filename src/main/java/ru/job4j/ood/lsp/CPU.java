package ru.job4j.ood.lsp;

public class CPU {
    protected int mhz;
    protected int cores;

    public CPU(int mhz, int cores) {
        this.mhz = mhz;
        this.cores = cores;
    }

    public void workHard() {
        if (checkCores(cores)) {
            System.out.println("You may work hard");
        }
    }

    public boolean checkCores(int cores) {
        if (cores < 4) {
            throw new IllegalArgumentException("It's not a good made CPU");
        }
        return true;
    }
}


class ARM extends CPU {

    public ARM(int mhz, int cores) {
        super(mhz, cores);
    }

    @Override
    public void workHard() {
        System.out.println("You may work hard");
    }
}
