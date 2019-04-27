package com.example.nowrin.austcalendarplanner;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nowrin on 2/13/2018.
 */

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int databaseVersion = 1;
    private static final String databaseName = "EventsManagerDB";
    private static final String tableName = "Events";
    private static final String keyId = "id";
    private static final String keyName = "EventName";
    private static final String keyTime = "EventTime";
    private static final String keyDate = "EventDate";
    private static final String keyNote = "EventNote";

    public DatabaseHandler(Context context){
        super(context, databaseName, null, databaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sq1 = "CREATE TABLE " + tableName + "(" +
                keyId + " INTEGER PRIMARY KEY AUTO INCREMENTED, " +
                keyName + " TEXT, " +
                keyTime + " TEXT, " +
                keyDate + " TEXT, " +
                keyNote + " TEXT" + ")";
        sqLiteDatabase.execSQL(sq1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sq1 = "DROP TABLE IF EXISTS " + tableName;
        sqLiteDatabase.execSQL(sq1);
        onCreate(sqLiteDatabase);
    }

    public void insertEvent(Events event){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(keyId, event.getId());
        values.put(keyName, event.getEventName());
        values.put(keyDate, event.getEventDate());
        values.put(keyTime, event.getEventTime());
        values.put(keyNote, event.getEventNote());

        db.insert(tableName, null, values);
        db.close();
    }

    public List<Events> getAllEvents(){
        SQLiteDatabase db = this.getReadableDatabase();

        List<Events> eventsList = new ArrayList<>();
        String sq1 = "SELECT * FROM " + tableName;
        Cursor cursor = db.rawQuery(sq1, null);
        if(cursor.moveToFirst()){
            do{
                Events event = new Events(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
                eventsList.add(event);
            }while(cursor.moveToNext());
        }
        db.close();
        return eventsList;
    }

    public void deleteEvent(int id){
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(tableName, keyId+"=?", new String[]{String.valueOf(id)});
        db.close();
    }

    public void updateEvent(Events event){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "UPDATE events SET EventName = '"+ event.getEventName()+"' WHERE id = '"+event.getId()+"'";
        db.execSQL(sql);
        db.close();
    }

}
