package com.example.datetimepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private class MainListener implements View.OnClickListener, DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.setDate) {
                showDatePicker();
            }
            else if (view.getId() == R.id.setTime) {
                showTimePicker();
            }
        }

        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            String d = i + "/" + (i1+1) + "/" + i2;

            if (i1+1 == 9 && i2 == 28) {
                hello.setText("Say hello to your teacher!!");
            }
            else {
                hello.setText("");
            }

            date.setText(d);
        }

        @Override
        public void onTimeSet(TimePicker timePicker, int i, int i1) {
            String t = i + ":" + i1;
            time.setText(t);
        }
    }

    private Calendar calendar;
    private TextView date, time, hello;
    private MainListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listener = new MainListener();
        calendar = Calendar.getInstance();

        date = findViewById(R.id.setDate);
        time = findViewById(R.id.setTime);
        hello = findViewById(R.id.sayHello);
        date.setOnClickListener(listener);
        time.setOnClickListener(listener);
    }

    private void showDatePicker() {
        new DatePickerDialog(this, listener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) ,Calendar.DAY_OF_MONTH).show();
    }

    private void showTimePicker() {
        new TimePickerDialog(this, listener, 0,0,true).show();
    }
}
