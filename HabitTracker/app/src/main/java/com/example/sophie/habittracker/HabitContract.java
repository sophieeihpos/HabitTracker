package com.example.sophie.habittracker;

import android.provider.BaseColumns;


public class HabitContract {
    private HabitContract() {
    }
    public static class HabitEntry implements BaseColumns {
        public static final String TABLE_NAME = "habit";
        public static final String ID = BaseColumns._ID;
        public static final String COLUMN_HABIT = "description";
        public static final String COLUMN_FREQUENCY = "hours";
    }
}
