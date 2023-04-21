package com.mofidx.mykutupapp;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import androidx.appcompat.app.AlertDialog.Builder;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.material.badge.BadgeUtils;
import com.tomer.fadingtextview.FadingTextView;

import org.joda.time.Period;
import org.joda.time.PeriodType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;


public class sayac extends AppCompatActivity {

    private InterstitialAd mInterstitialAd;
    CardView cardViewZallah;
    boolean sifirlasa = true;
    String sdate, edate, finaldate;
    SharedPreferences sharedPreferences = null;
    SharedPreferences.Editor editor;
    int result;
    AnimationDrawable animationDrawable;
    ImageView imgup;
    TextView txtitem2, txtitem22, txtitem223, txtitem2234, txtlevel;
    FadingTextView txtup;
    AlertDialog.Builder dialogBuilder;
    AlertDialog alertDialog;
    DatePickerDialog datePickerDialog;
    Toolbar toolbar;
    TextView text1, text_view_progress;
    Button btnsifirla, btntarihisec;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    ProgressBar progressBar;
    DatePickerDialog.OnDateSetListener dateSetListener1, getDateSetListener2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sayac);

        toolbar = findViewById(R.id.toolbarsayac);


        setSupportActionBar(toolbar);
        //لون النص للأكشن بار
        Objects.requireNonNull(getSupportActionBar()).setTitle((Html.fromHtml("<font  color=\"#FFFFFF\">" + getString(R.string.sayac_name) + "</font>")));

        cardViewZallah =findViewById(R.id.cardzalah);

        progressBar = findViewById(R.id.progressBar1);
        //text level
        txtlevel = findViewById(R.id.txtlevel);
        // البطارية
        imgup = findViewById(R.id.imgup);
        // بداية التحدي
        txtitem2 = findViewById(R.id.txtitem2);
        // نهاية التحدي
        txtitem22 = findViewById(R.id.txtitem22);
        // اكملت  10 ايام
        txtup = findViewById(R.id.txtup);
        // الايام المتبقية
        txtitem223 = findViewById(R.id.txtitem223);
        // تاريخ اليوم مخفي
        txtitem2234 = findViewById(R.id.txtitem2234);

        //
        text_view_progress = findViewById(R.id.text_view_progress);
        btnsifirla = findViewById(R.id.button_sifirla);
        btntarihisec = findViewById(R.id.button_tarihisec);

        txtup.shuffle();

        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this,getResources().getString(R.string.myinterstitialsayac), adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                        Log.i(TAG, "onAdLoaded");
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        Log.d(TAG, loadAdError.toString());
                        mInterstitialAd = null;
                    }
                });

        sharedPreferences = getSharedPreferences("sayacfile", 0);

        //التاريخ اللذي تم تحديده سابقا
        sdate = sharedPreferences.getString("StrDateSelected", "00/00/0000");
        //تاريخ اليوم الذي تم تخزينه سابقا
        finaldate = sharedPreferences.getString("StrDatetoday", "00/00/0000");
       //تاريخ اليوم
        edate = simpleDateFormat.format(Calendar.getInstance().getTime());


        if (!sdate.equals("00/00/0000")) {


            try {
                Date date1 = simpleDateFormat.parse(sdate);
                Date date2 = simpleDateFormat.parse(edate);


                long startDate = date1.getTime();
                long endDate = date2.getTime();

                if (startDate <= endDate) {
//                    Calendar c = Calendar.getInstance();
                    Period period = new Period(startDate, endDate, PeriodType.days());
//                    Period period1 = new Period(startDate,endDate , PeriodType.yearMonthDay());
//                        int days = period1.getDays();
//                        int months = period1.getMonths();
//                        int years = period1.getYears();
//                        int month1 = c.get(Calendar.MONTH);
//                        int day1 = c.get(Calendar.DAY_OF_MONTH);
//                        int years1 = c.get(Calendar.YEAR);
                    result = period.getDays();

                    //بداية التجدي
                    txtitem2.setText("" + simpleDateFormat.format(date1));
                    // نهاية التحدي
                    incrementtoDate(sdate, 90);


                    if (result <= 89) {
                        ProgressBarAnimation anim = new ProgressBarAnimation(progressBar, text_view_progress, 0, result);
                        anim.setDuration(800);
                        progressBar.startAnimation(anim);
                        txtitem223.setText("" + (90 - result)); // الايام المتبقية
                        Toast.makeText(getApplicationContext(), "لقد اجتزت" + " " + result + " يوم", Toast.LENGTH_SHORT).show();


                    }
                    if (result >= 90) {
                        imgup.setBackgroundResource(R.drawable.battery_full);
                        txtitem223.setText("" + 0); // الايام المتبقية
                        ProgressBarAnimation anim = new ProgressBarAnimation(progressBar, text_view_progress, 0, 90);
                        anim.setDuration(800);
                        progressBar.startAnimation(anim);
                        Toast.makeText(getApplicationContext(), "لقد اجتزت" + " " + result + " يوم", Toast.LENGTH_SHORT).show();
                    }
                    int oran = (result/90)*100;
                    if (result <= 13) {
                        txtlevel.setText("المستوى الاول");
                        txtlevel.setTextColor(getResources().getColor(R.color.red));
                        //battery1
                        imgup.setBackgroundResource(R.drawable.animation0);
                        animationDrawable = (AnimationDrawable) imgup.getBackground();
                        animationDrawable.start();
                    }
                    if ( result>=14 && result <= 28 ) {

                        txtlevel.setText("المستوى الثاني");
                        txtlevel.setTextColor(getResources().getColor(R.color.orange));
                        //battery1
                        imgup.setBackgroundResource(R.drawable.animation1);
                        animationDrawable = (AnimationDrawable) imgup.getBackground();
                        animationDrawable.start();

                    }
                    if (result>=29 && result <= 45) {
                        txtlevel.setText("المستوى الثالث");
                        txtlevel.setTextColor(getResources().getColor(R.color.yellow));
                        //battery1
                        imgup.setBackgroundResource(R.drawable.animation2);
                        animationDrawable = (AnimationDrawable) imgup.getBackground();
                        animationDrawable.start();

                    }
                    if  (result>=46 && result <= 64) {
                        txtlevel.setText("المستوى الرابع");
                        txtlevel.setTextColor(getResources().getColor(R.color.green));
                        //battery1
                        imgup.setBackgroundResource(R.drawable.animation3);
                        animationDrawable = (AnimationDrawable) imgup.getBackground();
                        animationDrawable.start();

                    }
                    if (result >= 65 && result < 90) {
                        txtlevel.setText("المستوى الأخير");
                        txtlevel.setTextColor(getResources().getColor(R.color.greenextra));
                        //battery1
                        imgup.setBackgroundResource(R.drawable.animation4);
                        animationDrawable = (AnimationDrawable) imgup.getBackground();
                        animationDrawable.start();

                    }


                }

            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

        }

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

                if (!text_view_progress.getText().toString().equals("0/90")) {
                    //مربع الحوار الذي يخرج بشكل مربع وفيه زر
                    showAlertDialog(R.layout.dialog_postive_layout);
                }

            }
        });




        cardViewZallah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(sayac.this, ActivityZalah.class);
                startActivity(i); // invoke the SecondActivity.
            }
        });


        if (result==0) {
            btnsifirla.setBackgroundColor(getResources().getColor(R.color.sifirla_pressed));
        }else{
            btnsifirla.setBackgroundColor(getResources().getColor(R.color.sifirla_unpressed));
        }
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


        // دالة تلتقط و تخزن التاريخ اللذي تم اختياره
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                String stringdate = "" + dayOfMonth + "/" + month + "/" + year;
//                btntarihisec.setText(stringdate);
                txtitem2234.setText(stringdate);

                // التاريخ الذي تم تحديده
                String sdate = txtitem2234.getText().toString();
                //تاريخ اليوم
                String edate = simpleDateFormat.format(Calendar.getInstance().getTime());


                editor = sharedPreferences.edit();
                editor.putString("StrDateSelected", sdate);
                editor.putString("StrDatetoday", edate);
                editor.commit();


                if (mInterstitialAd != null) {
                    mInterstitialAd.show(sayac.this);
                } else {
                    Log.d("TAG", "The interstitial ad wasn't ready yet.");
                }


                try {
                    Date date1 = simpleDateFormat.parse(sdate);
                    Date date2 = simpleDateFormat.parse(edate);


                    long startDate = date1.getTime();
                    long endDate = date2.getTime();

                    if (startDate <= endDate) {
//                        Calendar c = Calendar.getInstance();
                        Period period = new Period(startDate, endDate, PeriodType.days());
//                        Period period1 = new Period(startDate,endDate , PeriodType.yearMonthDay());
//                        int days = period1.getDays();
//                        int months = period1.getMonths();
//                        int years = period1.getYears();
//                        int month1 = c.get(Calendar.MONTH);
//                        int day1 = c.get(Calendar.DAY_OF_MONTH);
//                        int years1 = c.get(Calendar.YEAR);
                        int result = period.getDays();

                        //بداية التجدي
                        txtitem2.setText(stringdate);
                        // نهاية التحدي
                        incrementtoDate(sdate, 90);
                        String ndate = txtitem22.getText().toString();


                        if (result <= 89) {
                            ProgressBarAnimation anim = new ProgressBarAnimation(progressBar, text_view_progress, 0, result);
                            anim.setDuration(800);
                            progressBar.startAnimation(anim);
                            txtitem223.setText("" + (90 - result)); // الايام المتبقية
                            Toast.makeText(getApplicationContext(), "لقد اجتزت" + " " + result + " يوم", Toast.LENGTH_SHORT).show();

                        }
                        if (result >= 90) {
                            imgup.setBackgroundResource(R.drawable.battery_full);
                            txtitem223.setText("" + 0); // الايام المتبقية
                            ProgressBarAnimation anim = new ProgressBarAnimation(progressBar, text_view_progress, 0, 90);
                            anim.setDuration(800);
                            progressBar.startAnimation(anim);
                            Toast.makeText(getApplicationContext(), "لقد اجتزت" + " " + result + " يوم", Toast.LENGTH_SHORT).show();
                        }

                        int oran = (result/90)*100;
                        if (result <= 13) {
                            txtlevel.setText("المستوى الاول");
                            txtlevel.setTextColor(getResources().getColor(R.color.red));
                            //battery1
                            imgup.setBackgroundResource(R.drawable.animation0);
                            animationDrawable = (AnimationDrawable) imgup.getBackground();
                            animationDrawable.start();
                        }
                        if ( result>=14 && result <= 28 ) {

                            txtlevel.setText("المستوى الثاني");
                            txtlevel.setTextColor(getResources().getColor(R.color.orange));
                            //battery1
                            imgup.setBackgroundResource(R.drawable.animation1);
                            animationDrawable = (AnimationDrawable) imgup.getBackground();
                            animationDrawable.start();

                        }
                        if (result>=29 && result <= 45) {
                            txtlevel.setText("المستوى الثالث");
                            txtlevel.setTextColor(getResources().getColor(R.color.yellow));
                            //battery1
                            imgup.setBackgroundResource(R.drawable.animation2);
                            animationDrawable = (AnimationDrawable) imgup.getBackground();
                            animationDrawable.start();

                        }
                        if  (result>=46 && result <= 64) {
                            txtlevel.setText("المستوى الرابع");
                            txtlevel.setTextColor(getResources().getColor(R.color.green));
                            //battery1
                            imgup.setBackgroundResource(R.drawable.animation3);
                            animationDrawable = (AnimationDrawable) imgup.getBackground();
                            animationDrawable.start();

                        }
                        if (result >= 65 && result < 90) {
                            txtlevel.setText("المستوى الأخير");
                            txtlevel.setTextColor(getResources().getColor(R.color.greenextra));
                            //battery1
                            imgup.setBackgroundResource(R.drawable.animation4);
                            animationDrawable = (AnimationDrawable) imgup.getBackground();
                            animationDrawable.start();

                        }

                        if (result==0) {
                            btnsifirla.setBackgroundColor(getResources().getColor(R.color.sifirla_pressed));
                        }else{
                            btnsifirla.setBackgroundColor(getResources().getColor(R.color.sifirla_unpressed));
                        }

                    }

                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }

            }
        };

        // هنا نأتي بتاريخ اليوم والشهر والسنة الحاليين
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);


        datePickerDialog = new DatePickerDialog(this, android.R.style.Theme_Material_Dialog_MinWidth, dateSetListener, year, month, day);

        // لجعل اقصى تاريخ هو تاريخ اليوم نستعمل الدالة
//        Calendar cal=Calendar.getInstance();
//        cal.add(Calendar.DAY_OF_MONTH,1);
//        long afteronday=cal.getTimeInMillis();
//        datePickerDialog.getDatePicker().setMaxDate(afteronday);
//        datePickerDialog.getWindow().setBackgroundDrawable(getDrawable(R.color.white));
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
        //        // لجعل اقل تاريخ هو تاريخ اليوم نستعمل الدالة
//        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
    }


    //Alert Dialog
    private void showAlertDialog(int layout) {
        dialogBuilder = new AlertDialog.Builder(sayac.this);
        View layoutView = getLayoutInflater().inflate(layout, null);
        Button dialogButton = layoutView.findViewById(R.id.btnDialog);
        Button dialogButton1 = layoutView.findViewById(R.id.btnDialog1);
        dialogBuilder.setView(layoutView);
        alertDialog = dialogBuilder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        alertDialog.show();
        dialogButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mInterstitialAd != null) {
                    mInterstitialAd.show(sayac.this);
                } else {
                    Log.d("TAG", "The interstitial ad wasn't ready yet.");
                }

                // نعم قم بتصفير العداد
                btnsifirla.setBackgroundColor(getResources().getColor(R.color.sifirla_pressed));

                ProgressBarAnimation anim = new ProgressBarAnimation(progressBar, text_view_progress, result, 0);
                    anim.setDuration(700);
                    progressBar.startAnimation(anim);


                    // بداية التحدي
                    txtitem2.setText("" + simpleDateFormat.format(Calendar.getInstance().getTime()));
                    String sdate1 = txtitem2.getText().toString();
                    // نهاية التحدي
                    try {
                        incrementtoDate(sdate1, 90);
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }

                    String ndate = txtitem22.getText().toString();

                    editor = sharedPreferences.edit();
                    editor.putString("StrDateSelected", sdate1);
                    editor.putString("StrDatetoday", ndate);
                    editor.commit();

                    // الايام المتبقية
                    txtitem223.setText("" +90); // الايام المتبقية

                    alertDialog.dismiss();


                    //battery1
                    imgup.setBackgroundResource(R.drawable.animation0);
                    animationDrawable = (AnimationDrawable) imgup.getBackground();
                    animationDrawable.start();
                    txtlevel.setText("المستوى الاول");
                    txtlevel.setTextColor(getResources().getColor(R.color.red));




            }
        });



    }

    public void incrementtoDate(String date, int modafilyh) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(date));
        c.add(Calendar.DATE, modafilyh);
        String dte = sdf.format(c.getTime()).toString();
        txtitem22.setText(dte);

    }

}

