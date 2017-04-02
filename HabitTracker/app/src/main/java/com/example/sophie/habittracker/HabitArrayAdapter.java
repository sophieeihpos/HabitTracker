package com.example.sophie.habittracker;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class HabitArrayAdapter extends ArrayAdapter {
    public HabitArrayAdapter(Context context, ArrayList<Habit> habits) {
        super(context, 0, habits);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }
        Habit current = (Habit) getItem(position);
        TextView textView= (TextView) convertView.findViewById(R.id.text_view);
        textView.setText(current.getHabit()+"  |  "+current.getFrequency());
        return convertView;
    }
}
