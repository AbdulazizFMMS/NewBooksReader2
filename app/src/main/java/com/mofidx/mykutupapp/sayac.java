package com.mofidx.mykutupapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import androidx.appcompat.app.AlertDialog.Builder;
import androidx.appcompat.app.AlertDialog;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Html;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.badge.BadgeUtils;

import java.util.Calendar;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class sayac extends AppCompatActivity {
    DatePickerDialog datePickerDialog;
    Toolbar toolbar;
    TextView text1, text_view_progress;
    Button btnsifirla, btntarihisec;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sayac);

        toolbar = findViewById(R.id.toolbar);


        setSupportActionBar(toolbar);
        //لون النص للأكشن بار
        Objects.requireNonNull(getSupportActionBar()).setTitle((Html.fromHtml("<font  color=\"#FFFFFF\">" + getString(R.string.sayac_name) + "</font>")));






        progressBar = findViewById(R.id.progressBar1);
        text_view_progress = findViewById(R.id.text_view_progress);
        btnsifirla= findViewById(R.id.button_sifirla);
        btntarihisec = findViewById(R.id.button_tarihisec);


        ProgressBarAnimation anim = new ProgressBarAnimation(progressBar,text_view_progress, 0, 90);
        anim.setDuration(2500);
        progressBar.startAnimation(anim);





        initDatepicker();


//        btntarihisec.setText(getbuguntarihi());



btntarihisec.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        datePickerDialog.show();
    }
});

btnsifirla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialog(R.layout.dialog_postive_layout);
            }
        });






        //عداد الوقت

//        new CountDownTimer(16069000, 1000) { // adjust the milli seconds here
//
//            public void onTick(long millisUntilFinished) {
//
//                text1.setText("" + String.format(FORMAT,
//                        TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
//                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
//                                TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
//                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
//                                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
//            }
//
//            public void onFinish() {
//                text1.setText("done!");
//            }
//        }.start();






        //onCreate is here


    }


//    private String getbuguntarihi() {
//        Calendar calendar = Calendar.getInstance();
//        int year = calendar.get(Calendar.YEAR);
//        int month = calendar.get(Calendar.MONTH);
//        month = month+1;
//        int day = calendar.get(Calendar.DAY_OF_MONTH);
//
//        return ""+day+"/"+month+"/"+year;
//    }

    private void initDatepicker() {

        // دالة تخزن التاريخ اللذي تم اختياره
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month+1 ;
                String stringdate= ""+dayOfMonth+"/"+month+"/"+year;
                btntarihisec.setText(stringdate);
            }
        };

        // هنا نأتي بتاريخ اليوم والشهر والسنة الحاليين
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);



        datePickerDialog = new DatePickerDialog(this , androidx.appcompat.R.style.Theme_AppCompat_DayNight_Dialog_MinWidth , dateSetListener , year , month , day);
        // لجعل اقصى تاريخ هو تاريخ اليوم نستعمل الدالة
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
        //        // لجعل اقل تاريخ هو تاريخ اليوم نستعمل الدالة
//        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
    }


    private void showAlertDialog(int layout){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(sayac.this);
        View layoutView = getLayoutInflater().inflate(layout, null);
        Button dialogButton = layoutView.findViewById(R.id.btnDialog);
        dialogBuilder.setView(layoutView);
        AlertDialog alertDialog  =  dialogBuilder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
    }


}

