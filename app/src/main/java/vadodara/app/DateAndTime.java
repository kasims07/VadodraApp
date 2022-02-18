package vadodara.app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DateAndTime extends AppCompatActivity {

    EditText dateEdit, timeEdit;
    Calendar calendar;
    int iHour, iMint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_and_time);

        dateEdit = findViewById(R.id.date_editText);
        timeEdit = findViewById(R.id.time_editTaxt);

        calendar = Calendar.getInstance();

        TimePickerDialog.OnTimeSetListener timeClick = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                iHour = hourOfDay;
                iMint = minute;

                String sAMPM = "";
                if(iHour>12){
                    sAMPM = "PM";
                    iHour-=12;
                }else if(iHour==12){
                    sAMPM = "PM";
                }else if(iHour==0){
                    sAMPM = "AM";
                }else {
                    sAMPM = "AM";
                }

                timeEdit.setText(iHour+" : "+iMint+" "+sAMPM);


            }
        };

        DatePickerDialog.OnDateSetListener dateClick = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR,year);
                calendar.set(Calendar.MONTH,month);
                calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                dateEdit.setText(dateFormat.format(calendar.getTime()));


            }
        };

        dateEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(DateAndTime.this,dateClick,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        timeEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TimePickerDialog(DateAndTime.this,timeClick,iHour,iMint,false).show();
            }
        });
    }
}