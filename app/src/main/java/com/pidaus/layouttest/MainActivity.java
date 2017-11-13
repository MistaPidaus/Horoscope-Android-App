package com.pidaus.layouttest;

import android.os.Bundle;
import android.app.Activity;
import java.util.Calendar;
import android.app.DatePickerDialog;
import android.view.View;

import android.widget.DatePicker;
import android.widget.EditText;
import android.content.Intent;

public class MainActivity extends Activity {
    EditText date;
    DatePickerDialog datePickerDialog;

    public static final String EXTRA_MESSAGE = "com.pidaus.layouttest.MESSAGE";
    public static final String EXTRA_MESSAGE2 = "com.pidaus.layouttest.MESSAGE2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // initiate the date picker and a button
        date = (EditText) findViewById(R.id.date);
        // perform click event on edit text
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                date.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });
    }
    //DisplayResult
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayActivity.class);
        EditText editText = (EditText) findViewById(R.id.name);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        //
        EditText editText2 = (EditText) findViewById(R.id.date);
        String message2 = editText2.getText().toString();
        intent.putExtra(EXTRA_MESSAGE2, message2);
        startActivity(intent);
    }
}