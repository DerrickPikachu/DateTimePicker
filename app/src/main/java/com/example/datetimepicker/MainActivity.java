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
            String d = Integer.toString(i) + "/" + Integer.toString(i1+1) + "/" + Integer.toString(i2);
            date.setText(d);
        }

        @Override
        public void onTimeSet(TimePicker timePicker, int i, int i1) {
            String t = Integer.toString(i) + ":" + Integer.toString(i1);
            time.setText(t);
        }
    }

    private TextView date, time;
    private MainListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listener = new MainListener();

        date = findViewById(R.id.setDate);
        time = findViewById(R.id.setTime);
        date.setOnClickListener(listener);
        time.setOnClickListener(listener);
    }

    private void showDatePicker() {
        new DatePickerDialog(this, listener, 2019, 9 ,12).show();
    }

    private void showTimePicker() {
        new TimePickerDialog(this, listener, 0,0,true).show();
    }
}
