package com.example.sophie.habittracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.sophie.habittracker.HabitContract.HabitEntry.*;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase habitDB;
    private HabitDbHelper habitDbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        habitDbHelper = new HabitDbHelper(getBaseContext());
        habitDB=habitDbHelper.getWritableDatabase();

        insertData("Take medicine",8);
        insertData("Running",24);
        insertData("Reading a book",16);
        habitDB.close();
        displayDatabaseInfo();

    }
    private void insertData(String habit, int frequency){
        ContentValues values = new ContentValues();
        values.put(COLUMN_HABIT,habit);
        values.put(COLUMN_FREQUENCY, frequency);
        Long insertFail= habitDB.insert(TABLE_NAME,null,values);
        if (insertFail==-1){
            Toast toast = Toast.makeText(this, "insert failed", Toast.LENGTH_LONG);
            toast.show();
        }else{
            Toast toast = Toast.makeText(this, "habit data saved", Toast.LENGTH_LONG);
            toast.show();
        }

    }

    private void displayDatabaseInfo() {
        ArrayList arrayList= new ArrayList<Habit>();
        Cursor cursor = read(TABLE_NAME);
        while (cursor.moveToNext()){
            arrayList.add(new Habit(cursor.getString(1),cursor.getInt(2)));
        }
        cursor.close();
        habitDB.close();
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(new HabitArrayAdapter(this,arrayList));
    }
    private Cursor read(String table){
        habitDB = habitDbHelper.getReadableDatabase();
        String[] projection={ID,COLUMN_HABIT,COLUMN_FREQUENCY};
        Cursor cursor = habitDB.query(table,projection,null,null,null,null,ID);
        return cursor;
    }

}
