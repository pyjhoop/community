package com.study.common.domain;

public class PositiveIntegerCounter {
    private int count;

    public PositiveIntegerCounter() {
    }

    public void increase() {
        this.count++;
    }

    public void decrease() {
        if(count <= 0){
            return;
        }
        this.count--;
    }
}
