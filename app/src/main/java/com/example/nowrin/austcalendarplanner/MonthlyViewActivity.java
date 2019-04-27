package com.example.nowrin.austcalendarplanner;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import com.prolificinteractive.materialcalendarview.spans.DotSpan;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;

public class MonthlyViewActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ImageButton floatBtn;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthly_view);

        floatBtn =  findViewById(R.id.floatingActionbtn);
        floatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CreateEventActivity.class);
                startActivity(intent);
            }
        });

        mDrawerLayout = findViewById(R.id.monthlyview);
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);

        final MaterialCalendarView MonthlyView = (MaterialCalendarView) findViewById(R.id.calendarView);
        MonthlyView.state().edit()
                .setFirstDayOfWeek(Calendar.SUNDAY)
                .setMinimumDate(CalendarDay.from(1900, 1, 1))
                .setMaximumDate(CalendarDay.from(2100, 12, 31))
                .setCalendarDisplayMode(CalendarMode.MONTHS)
                .commit();

        MonthlyView.setOnDateChangedListener(new OnDateSelectedListener(){
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                DateFormat formatter = SimpleDateFormat.getDateInstance();
                if (MonthlyView.getSelectedDate().equals(CalendarDay.from(2018, 0, 1)))
                    Toast.makeText(MonthlyViewActivity.this, "NEW YEAR\n" +  formatter.format(date.getDate()), Toast.LENGTH_SHORT).show();
                else if (MonthlyView.getSelectedDate().equals(CalendarDay.from(2018, 1, 21)))
                    Toast.makeText(MonthlyViewActivity.this, "Language Martyrs' Day\n" +  formatter.format(date.getDate()), Toast.LENGTH_SHORT).show();
                else if (MonthlyView.getSelectedDate().equals(CalendarDay.from(2018, 2, 17)))
                    Toast.makeText(MonthlyViewActivity.this, "Sheikh Mujibur Rahman's Birthday\n" +  formatter.format(date.getDate()), Toast.LENGTH_SHORT).show();
                else if (MonthlyView.getSelectedDate().equals(CalendarDay.from(2018, 2, 26)))
                    Toast.makeText(MonthlyViewActivity.this, "Independence Day\n" +  formatter.format(date.getDate()), Toast.LENGTH_SHORT).show();
                else if (MonthlyView.getSelectedDate().equals(CalendarDay.from(2018, 3, 14)))
                    Toast.makeText(MonthlyViewActivity.this, "Bengali New Year\n" +  formatter.format(date.getDate()), Toast.LENGTH_SHORT).show();
                else if (MonthlyView.getSelectedDate().equals(CalendarDay.from(2018, 3, 29)))
                    Toast.makeText(MonthlyViewActivity.this, "Buddha Purnima\n" +  formatter.format(date.getDate()), Toast.LENGTH_SHORT).show();
                else if (MonthlyView.getSelectedDate().equals(CalendarDay.from(2018, 4, 1)))
                    Toast.makeText(MonthlyViewActivity.this, "May Day\n" +  formatter.format(date.getDate()), Toast.LENGTH_SHORT).show();
                else if (MonthlyView.getSelectedDate().equals(CalendarDay.from(2018, 4, 2)))
                    Toast.makeText(MonthlyViewActivity.this, "Shab e-Barat\n" +  formatter.format(date.getDate()), Toast.LENGTH_SHORT).show();
                else if (MonthlyView.getSelectedDate().equals(CalendarDay.from(2018, 5, 12)))
                    Toast.makeText(MonthlyViewActivity.this, "Lailatul Qadr\n" +  formatter.format(date.getDate()), Toast.LENGTH_SHORT).show();
                else if (MonthlyView.getSelectedDate().equals(CalendarDay.from(2018, 5, 15)))
                    Toast.makeText(MonthlyViewActivity.this, "Jumatul Bidah\n" + "Eid ul-Fitr Holiday\n"+ formatter.format(date.getDate()), Toast.LENGTH_SHORT).show();
                else if (MonthlyView.getSelectedDate().equals(CalendarDay.from(2018, 5, 16)))
                    Toast.makeText(MonthlyViewActivity.this, "Eid ul-Fitr\n" +  formatter.format(date.getDate()), Toast.LENGTH_SHORT).show();
                else if (MonthlyView.getSelectedDate().equals(CalendarDay.from(2018, 5, 17)))
                    Toast.makeText(MonthlyViewActivity.this, "Eid ul-Fitr Holiday\n" +  formatter.format(date.getDate()), Toast.LENGTH_SHORT).show();
                else if (MonthlyView.getSelectedDate().equals(CalendarDay.from(2018, 7, 15)))
                    Toast.makeText(MonthlyViewActivity.this, "National Mourning Day\n" +  formatter.format(date.getDate()), Toast.LENGTH_SHORT).show();
                else if (MonthlyView.getSelectedDate().equals(CalendarDay.from(2018, 7, 21)))
                    Toast.makeText(MonthlyViewActivity.this, "Eid ul-Adha Holiday\n" +  formatter.format(date.getDate()), Toast.LENGTH_SHORT).show();
                else if (MonthlyView.getSelectedDate().equals(CalendarDay.from(2018, 7, 22)))
                    Toast.makeText(MonthlyViewActivity.this, "Eid ul-Adha\n" +  formatter.format(date.getDate()), Toast.LENGTH_SHORT).show();
                else if (MonthlyView.getSelectedDate().equals(CalendarDay.from(2018, 7, 23)))
                    Toast.makeText(MonthlyViewActivity.this, "Eid ul-Adha Day 2\n" +  formatter.format(date.getDate()), Toast.LENGTH_SHORT).show();
                else if (MonthlyView.getSelectedDate().equals(CalendarDay.from(2018, 8, 2)))
                    Toast.makeText(MonthlyViewActivity.this, "Janmashtami\n" +  formatter.format(date.getDate()), Toast.LENGTH_SHORT).show();
                else if (MonthlyView.getSelectedDate().equals(CalendarDay.from(2018, 8, 21)))
                    Toast.makeText(MonthlyViewActivity.this, "Ashura\n" +  formatter.format(date.getDate()), Toast.LENGTH_SHORT).show();
                else if (MonthlyView.getSelectedDate().equals(CalendarDay.from(2018, 9, 19)))
                    Toast.makeText(MonthlyViewActivity.this, "Durga Puja\n" +  formatter.format(date.getDate()), Toast.LENGTH_SHORT).show();
                else if (MonthlyView.getSelectedDate().equals(CalendarDay.from(2018, 10, 21)))
                    Toast.makeText(MonthlyViewActivity.this, "Eid e-Milad-un Nabi\n" +  formatter.format(date.getDate()), Toast.LENGTH_SHORT).show();
                else if (MonthlyView.getSelectedDate().equals(CalendarDay.from(2018, 11, 16)))
                    Toast.makeText(MonthlyViewActivity.this, "Victory Day\n" +  formatter.format(date.getDate()), Toast.LENGTH_SHORT).show();
                else if (MonthlyView.getSelectedDate().equals(CalendarDay.from(2018, 11, 25)))
                    Toast.makeText(MonthlyViewActivity.this, "Christmas Day\n" +  formatter.format(date.getDate()), Toast.LENGTH_SHORT).show();

                else if (MonthlyView.getSelectedDate().equals(CalendarDay.from(2017, 10, 9)))
                    Toast.makeText(MonthlyViewActivity.this, "Orientation & Reception for Freshers only\n" +  formatter.format(date.getDate()), Toast.LENGTH_SHORT).show();
                else if (MonthlyView.getSelectedDate().equals(CalendarDay.from(2017, 10, 11)))
                    Toast.makeText(MonthlyViewActivity.this, "All Classes Begin\n" +  formatter.format(date.getDate()), Toast.LENGTH_SHORT).show();
                else if (MonthlyView.getSelectedDate().equals(CalendarDay.from(2017, 11, 28)))
                    Toast.makeText(MonthlyViewActivity.this, "All Classes End\n" +  formatter.format(date.getDate()), Toast.LENGTH_SHORT).show();
                else if (MonthlyView.getSelectedDate().equals(CalendarDay.from(2017, 11, 29)))
                    Toast.makeText(MonthlyViewActivity.this, "Midterm Break Begins\n" +  formatter.format(date.getDate()), Toast.LENGTH_SHORT).show();
                else if (MonthlyView.getSelectedDate().equals(CalendarDay.from(2018, 0, 5)))
                    Toast.makeText(MonthlyViewActivity.this, "Midterm Break Ends\n" +  formatter.format(date.getDate()), Toast.LENGTH_SHORT).show();
                else if (MonthlyView.getSelectedDate().equals(CalendarDay.from(2018, 0, 6)))
                    Toast.makeText(MonthlyViewActivity.this, "All Classes Begin\n" +  formatter.format(date.getDate()), Toast.LENGTH_SHORT).show();
                else if (MonthlyView.getSelectedDate().equals(CalendarDay.from(2018, 1, 14)))
                    Toast.makeText(MonthlyViewActivity.this, "All Classes End\n" +  formatter.format(date.getDate()), Toast.LENGTH_SHORT).show();
                else if (MonthlyView.getSelectedDate().equals(CalendarDay.from(2018, 1, 15)))
                    Toast.makeText(MonthlyViewActivity.this, "Farewell for outgoing students only\n" +  formatter.format(date.getDate()), Toast.LENGTH_SHORT).show();
                else if (MonthlyView.getSelectedDate().equals(CalendarDay.from(2018, 1, 16)))
                    Toast.makeText(MonthlyViewActivity.this, "Preparatory Leave Begins\n" +  formatter.format(date.getDate()), Toast.LENGTH_SHORT).show();
                else if (MonthlyView.getSelectedDate().equals(CalendarDay.from(2018, 2, 2)))
                    Toast.makeText(MonthlyViewActivity.this, "Preparatory Leave Ends\n" +  formatter.format(date.getDate()), Toast.LENGTH_SHORT).show();
                else if (MonthlyView.getSelectedDate().equals(CalendarDay.from(2018,2, 3)))
                    Toast.makeText(MonthlyViewActivity.this, "Semester Final Examinations Begin\n" +  formatter.format(date.getDate()), Toast.LENGTH_SHORT).show();
                else if (MonthlyView.getSelectedDate().equals(CalendarDay.from(2018, 2, 22)))
                    Toast.makeText(MonthlyViewActivity.this, "Semester Final Examinations End\n" +  formatter.format(date.getDate()), Toast.LENGTH_SHORT).show();
                else if (MonthlyView.getSelectedDate().equals(CalendarDay.from(2018, 2, 24 )))
                    Toast.makeText(MonthlyViewActivity.this, "Result Publishing Begins\n" +  formatter.format(date.getDate()), Toast.LENGTH_SHORT).show();
                else if (MonthlyView.getSelectedDate().equals(CalendarDay.from(2018, 3, 5)))
                    Toast.makeText(MonthlyViewActivity.this, "Result Publishing Ends\n" +  formatter.format(date.getDate()), Toast.LENGTH_SHORT).show();
                else if (MonthlyView.getSelectedDate().equals(CalendarDay.from(2018, 3, 7)))
                    Toast.makeText(MonthlyViewActivity.this, "Clearance/Improvement/Carryover Examinations Begin\n" +  formatter.format(date.getDate()), Toast.LENGTH_SHORT).show();
                else if (MonthlyView.getSelectedDate().equals(CalendarDay.from(2018, 3, 19)))
                    Toast.makeText(MonthlyViewActivity.this, "Clearance/Improvement/Carryover Examinations End\n" +  formatter.format(date.getDate()), Toast.LENGTH_SHORT).show();
                else if (MonthlyView.getSelectedDate().equals(CalendarDay.from(2018, 3, 21)))
                    Toast.makeText(MonthlyViewActivity.this, "Orientation and Reception\n" +  formatter.format(date.getDate()), Toast.LENGTH_SHORT).show();
                else if (MonthlyView.getSelectedDate().equals(CalendarDay.from(2018, 3, 22)))
                    Toast.makeText(MonthlyViewActivity.this, "Classes Begin\n" +  formatter.format(date.getDate()), Toast.LENGTH_SHORT).show();


                else
                    Toast.makeText(getApplicationContext(), "" + formatter.format(date.getDate()), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item){

        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

//    public class EventDecorator implements DayViewDecorator {
//
//        private final int color;
//        private final HashSet<CalendarDay> dates;
//
//        public EventDecorator(int color, Collection<CalendarDay> dates) {
//            this.color = color;
//            this.dates = new HashSet<>(dates);
//        }
//
//        @Override
//        public boolean shouldDecorate(CalendarDay day) {
//            return dates.contains(day);
//        }
//
//        @Override
//        public void decorate(DayViewFacade view) {
//            view.addSpan(new DotSpan(5, color));
//        }
//    }

    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_schedule) {
            Intent i = new Intent(MonthlyViewActivity.this, AllEventsActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_dayView) {
            Intent i = new Intent(MonthlyViewActivity.this,DailyViewActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_weeklyView) {
            Intent i = new Intent(MonthlyViewActivity.this,WeeklyViewActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_monthView) {

        } else if (id == R.id.nav_showEvents) {
            Intent i = new Intent(MonthlyViewActivity.this, DefaultEventActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_settings) {

        } else if (id == R.id.nav_search) {

        }

        DrawerLayout drawer = findViewById(R.id.monthlyview);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
