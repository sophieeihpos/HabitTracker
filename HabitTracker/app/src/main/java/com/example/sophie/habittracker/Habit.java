package com.example.sophie.habittracker;

public class Habit {
    private String habit;
    private int frequency;
    public Habit(String habit,int frequency){
        this.habit=habit;
        this.frequency=frequency;
    }

    public String getHabit() {
        return habit;
    }

    public int getFrequency() {
        return frequency;
    }
}
