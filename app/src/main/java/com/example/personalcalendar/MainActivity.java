package com.example.personalcalendar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.app.RemoteActionCompatParcelizer;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Define the variable of CalendarView type
    // and TextView type;
    CalendarView calender;
    TextView date_view;
    Button addbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        calender = (CalendarView) findViewById(R.id.calender);
        date_view = (TextView) findViewById(R.id.date_view);
        addbtn = (Button) findViewById(R.id.addbtn);

        // Add Listener in calendar
        calender.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            // method to get the value of days, months and years when date is selected by user.
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth)
            {

                // Store the value of date with format in String type
                // Add 1 in month because month index starts with 0 (Jan should be = 1)
                String Date = (month + 1) + "-" + dayOfMonth + "-" + year;

                // set this date in TextView for Display
                date_view.setText(Date);
                addbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Auto-generated method stub
                        final Dialog dialog = new Dialog(MainActivity.this);
                        dialog.setContentView(R.layout.activity_main);
                        dialog.setTitle("Save New Number");
                        dialog.setCancelable(true);
                        dialog.show();

                            String msg = ((EditText)dialog.findViewById(R.id.editTextDialogUserInput)).getText().toString();
                          //  String number = ((EditText)dialog.findViewById(R.id.numberText)).getText().toString();
                    }
                });
            }
        });

    }
}

