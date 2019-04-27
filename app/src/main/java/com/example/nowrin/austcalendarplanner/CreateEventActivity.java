package com.example.nowrin.austcalendarplanner;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.text.format.DateFormat;
import android.widget.Toast;

import com.prolificinteractive.materialcalendarview.CalendarDay;


import java.util.Calendar;
import java.util.List;

public class CreateEventActivity extends AppCompatActivity implements
        DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    Button pick;
    TextView date, time;
    LinearLayout outputLL;

    int day, month, year, hour, minute;
    int dayFinal, monthFinal, yearFinal, hourFinal, minuteFinal;

    EditText eventName, note;
    TextView selectedTime, selectedDate;
    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        pick = findViewById(R.id.dateandtime);
        date = findViewById(R.id.selecteddate);
        time = findViewById(R.id.selectedtime);
        outputLL = findViewById(R.id.outputLL);
        eventName = findViewById(R.id.eventName);
        selectedDate = findViewById(R.id.selecteddate);
        selectedTime = findViewById(R.id.selectedtime);
        note = findViewById(R.id.note);

        db = new DatabaseHandler(this);

        pick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                year = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH);
                day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(CreateEventActivity.this,
                        CreateEventActivity.this, year, month, day);

                datePickerDialog.show();

            }
        });

    }

    public void insertEvent(View v){
        String name = eventName.getText().toString();
        String date = selectedDate.getText().toString();
        String time = selectedTime.getText().toString();
        String notes = note.getText().toString();
        if(name.equals("") || date.equals("")){
            Toast.makeText(getApplicationContext(), "Invalid Event", Toast.LENGTH_SHORT).show();
        }else{
            db.insertEvent(new Events(name, date, time, notes));
            Toast.makeText(getApplicationContext(), "Insert Successful", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        yearFinal = i;
        monthFinal = i1 + 1;
        dayFinal = i2;

        Calendar o = Calendar.getInstance();
        hour = o.get(Calendar.HOUR_OF_DAY);
        minute = o.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(CreateEventActivity.this,
                CreateEventActivity.this, hour, minute, DateFormat.is24HourFormat(this));

        timePickerDialog.show();
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        hourFinal = i;
        minuteFinal = i1;

        date.setText(dayFinal + "/" + monthFinal + "/" + yearFinal );
        time.setText(hourFinal + ":" + minuteFinal);
    }
}
