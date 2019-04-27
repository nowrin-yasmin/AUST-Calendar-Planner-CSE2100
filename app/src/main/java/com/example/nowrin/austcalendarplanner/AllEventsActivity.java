package com.example.nowrin.austcalendarplanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class AllEventsActivity extends AppCompatActivity {

    LinearLayout outputLL;
    TextView eventDeleteID;
    DatabaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_events);

        outputLL = findViewById(R.id.outputLL);
        eventDeleteID = findViewById(R.id.delete);
        db = new DatabaseHandler(this) ;
    }

    public void getAllEvents(View v){
        List<Events> events = db.getAllEvents();
        if(events.size() == 0){
            Toast.makeText(getApplicationContext(), "No Events Found", Toast.LENGTH_SHORT).show();
        }
        else {
            outputLL.removeAllViews();
            TextView tempTV = new TextView(this);
            tempTV.setText("ID\t\t\tEVENT\t\t\t\t\tDATE\t\t\t\t\tTIME\t\t\t\tNOTE");
            outputLL.addView(tempTV);

            for(Events events1 : events){
                tempTV = new TextView(this);
                tempTV.setText(events1.getId()+"\t\t\t"+events1.getEventName()+"\t\t\t\t\t"+events1.getEventDate()
                + "\t\t\t\t\t" + events1.getEventTime() + "\t\t\t\t" + events1.getEventNote());
                outputLL.addView(tempTV);
            }
        }
    }

    public void deleteEvent(View v){
        String id = eventDeleteID.getText().toString();
        if(id.equals("")){
            Toast.makeText(getApplicationContext(), "Invalid Input", Toast.LENGTH_SHORT).show();
        }else{
            db.deleteEvent(Integer.parseInt(id));
        }
    }
}
