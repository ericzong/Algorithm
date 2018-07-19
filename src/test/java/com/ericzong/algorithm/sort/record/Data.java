package com.ericzong.algorithm.sort.record;

import java.util.Comparator;

public class Data {
    private int id;

    public Data(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id + "";
    }

    public static Comparator<Data> getComparator() {
        return (o1, o2) -> {
            if (o1.id > o2.id) {
                return 1;
            } else if (o1.id < o2.id) {
                return -1;
            } else {
                return 0;
            }
        };
    }
}
