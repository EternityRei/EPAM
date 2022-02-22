package com.epam.rd.autotasks;

public class CountDownTask implements Task{

    private int value;
    private boolean isFinished;

    public CountDownTask(int value) {
        this.value = value;
        if(this.value <= 0) {
            this.value = 0;
            isFinished = true;
        }
    }

    public int getValue() {
        if(value < 0) value = 0;
        return value;
    }

    @Override
    public void execute() {
        --value;
        if(value == 0) isFinished = true;

    }

    @Override
    public boolean isFinished() {
        return isFinished;
    }
}
