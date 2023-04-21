package com.mofidx.mykutupapp;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;

import android.content.Intent;
import android.content.SharedPreferences;

import android.os.Bundle;

import android.view.View;

import android.widget.ImageView;


import com.google.android.material.imageview.ShapeableImageView;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;




public class MainActivity extends AppCompatActivity {
ImageView img90main,NewHabit , podcast;
SharedPreferences sharedPreferences = null;
SharedPreferences.Editor editor;
    ShapeableImageView book1, book2, book3, book4 , book5;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img90main = findViewById(R.id.sayac90main);
        NewHabit = findViewById(R.id.newhabit);
        podcast = findViewById(R.id.podcast);

        sharedPreferences = getSharedPreferences("MofidxBooksReader",0);
        podcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent i = new Intent(MainActivity.this, SoundActivity.class);
            startActivity(i);
            }
        });


        img90main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goto1 = new Intent(MainActivity.this, sayac.class);
                startActivity(goto1);
            }
        });
        NewHabit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goto1 = new Intent(MainActivity.this, MainActivityAlarm.class);
                startActivity(goto1);
            }
        });



        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        book1 = findViewById(R.id.book1);
        book2 = findViewById(R.id.book2);
        book3 = findViewById(R.id.book3);
        book4 = findViewById(R.id.book4);
        book5 = findViewById(R.id.book5);

        book1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goto1 = new Intent(MainActivity.this, BookDetails.class);
                goto1.putExtra("bookindex", 0);
                startActivity(goto1);
            }
        });

        book2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goto2 = new Intent(MainActivity.this, BookDetails.class);
                goto2.putExtra("bookindex", 1);
                startActivity(goto2);
            }
        });

        book3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goto3 = new Intent(MainActivity.this, BookDetails.class);
                goto3.putExtra("bookindex", 2);
                startActivity(goto3);
            }
        });

        book4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goto4 = new Intent(MainActivity.this, BookDetails.class);
                goto4.putExtra("bookindex", 3);
                startActivity(goto4);
            }
        });

        book5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goto4 = new Intent(MainActivity.this, BookDetails.class);
                goto4.putExtra("bookindex", 4);
                startActivity(goto4);
            }
        });


    }

//    //main_menu_create
//
//    @SuppressLint("UseCompatLoadingForDrawables")
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        //MenuInflater inflater = getMenuInflater();
//        //inflater.inflate(R.menu.menu_main,menu);
//        menu.add(0, 1, 1, menuIconWithText(getResources().getDrawable(R.drawable.ic_shareee), "شارك التطبيق"));
//        menu.add(0, 2, 2, menuIconWithText(getResources().getDrawable(R.drawable.ic_exitt), "اغلاق"));
//
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        if(item.getItemId()==1){
//
//            Intent myintent = new Intent(Intent.ACTION_SEND);
//            myintent.setType("text/plain");
//            String Sharebody = "تعلَّم كيف توقف الإباحية  : https://play.google.com/store/apps/details?id=com.mofidx.mykutupapp ";
//            //String sharelink = "";
//            //myintent.putExtra(Intent.EXTRA_SUBJECT, sharelink);
//            myintent.putExtra(Intent.EXTRA_TEXT, Sharebody);
//            startActivity(Intent.createChooser(myintent, "شارك التطبيق مع اصدقائك :"));
//        }
//        if(item.getItemId()==2){
//            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//            builder.setMessage("هل تريد اغلاق التطبيق");
//            builder.setCancelable(true);
//
//            builder.setNegativeButton("نعم", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    MainActivity.this.finish();
//                }
//            });
//
//            builder.setPositiveButton("لا", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    dialog.cancel();
//                }
//            });
//            AlertDialog alertDialog = builder.create();
//            alertDialog.show();
//
//            //finish();
//            //System.exit(0);
//        }
//        return true;
//
//
//    }
//
//    private CharSequence menuIconWithText(Drawable r, String title) {
//
//        r.setBounds(0, 0, r.getIntrinsicWidth(), r.getIntrinsicHeight());
//        SpannableString sb = new SpannableString("    " + title);
//        ImageSpan imageSpan = new ImageSpan(r, ImageSpan.ALIGN_BOTTOM);
//        sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//
//        return sb;}


    @Override
    protected void onDestroy() {
        super.onDestroy();
        editor = sharedPreferences.edit();
        editor.putBoolean("isbackpressed", true);
        editor.commit();

    }
}