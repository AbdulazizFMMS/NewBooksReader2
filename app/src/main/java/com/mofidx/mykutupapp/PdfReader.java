package com.mofidx.mykutupapp;

import static android.service.controls.ControlsProviderService.TAG;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnDrawListener;
import com.github.barteksc.pdfviewer.listener.OnLongPressListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnTapListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


import java.util.Objects;

public class PdfReader extends AppCompatActivity {
    private AdView adView;
    Boolean mode,rateus,birsecildimi,ikisecildimi,ucsecildimi,dortsecildimi,bessecildimi;
    String sunnymode,nightmode;
    Button btnnightmode;



PDFView pdfView;
int mcurrentpage,  gotoPage;
String [] pdflar1= {"a11.pdf","a12.pdf","a13.pdf","a14.pdf","a15.pdf","a16.pdf","a17.pdf",
        "a18.pdf","a19.pdf","a110.pdf","a111.pdf","a112.pdf","a113.pdf","a114.pdf","a115.pdf","a116.pdf"
        ,"a117.pdf"};
String [] pdflar2= {"a21.pdf","a22.pdf","a23.pdf","a24.pdf","a25.pdf","a26.pdf","a27.pdf",
        "a28.pdf","a29.pdf","a210.pdf","a211.pdf","a212.pdf","a213.pdf","a214.pdf","a215.pdf","a216.pdf"
        ,"a217.pdf","a218.pdf","a219.pdf","a220.pdf","a221.pdf","a222.pdf","a223.pdf","a224.pdf"};

String [] pdflar3= {"a31.pdf","a32.pdf","a33.pdf","a34.pdf","a35.pdf","a36.pdf","a37.pdf",
        "a38.pdf","a39.pdf","a310.pdf","a311.pdf","a312.pdf"};

    String [] pdflar4= {"a41.pdf","A42.pdf","A43.pdf","A44.pdf","A45.pdf","A46.pdf","A47.pdf",
            "A48.pdf","A49.pdf","A410.pdf","A411-1.pdf","A411.pdf","A412.pdf","A413.pdf","A414.pdf","A415.pdf","A416.pdf"
            ,"A417.pdf"};


String [] pdflar5= {"a51.pdf","a52.pdf","a53.pdf","a54.pdf","a55.pdf","a56.pdf","a57.pdf",
            "a58.pdf","a59.pdf","a510.pdf","a511.pdf","a512.pdf"};

SharedPreferences sharedPreferences=null;
SharedPreferences.Editor editor;
    int hangikonusecildi1,hangikonusecildi2,hangikonusecildi3,hangikonusecildi4,hangikonusecildi5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_reader);

        // Create a new ad view.
        adView = findViewById(R.id.adView);

        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);




        //زر الرجوع يلي الصفحة السابقة
        //يتبع بالاسفل
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true); }

        btnnightmode = findViewById(R.id.btnnightmode);
//        btnsunnymode = findViewById(R.id.btnsunnymode);
        pdfView = findViewById(R.id.pdfView);


        sharedPreferences = getSharedPreferences("MofidxBooksReader",0);
//
//        intcurrentpage1 = sharedPreferences.getInt("intcurrentpage1",0);
//        intcurrentpage2 = sharedPreferences.getInt("intcurrentpage2",0);
//        intcurrentpage3 = sharedPreferences.getInt("intcurrentpage3",0);
//        intcurrentpage4 = sharedPreferences.getInt("intcurrentpage4",0);
//        intcurrentpage5 = sharedPreferences.getInt("intcurrentpage5",0);

        mode = sharedPreferences.getBoolean("mode",false);
        rateus = sharedPreferences.getBoolean("rateusboole",false);
//        Toast.makeText(this, ""+rateus, Toast.LENGTH_SHORT).show();

        sunnymode = sharedPreferences.getString("sunnymode","الوضع النهاري");
        nightmode = sharedPreferences.getString("nightmode","الوضع الليلي");




        gotoPage= getIntent().getIntExtra("gotopage",0);



             hangikonusecildi1 = getIntent().getIntExtra("posi_key1",-1);
             hangikonusecildi2 = getIntent().getIntExtra("posi_key2",-1);
             hangikonusecildi3 = getIntent().getIntExtra("posi_key3",-1);
             hangikonusecildi4 = getIntent().getIntExtra("posi_key4",-1);
             hangikonusecildi5 = getIntent().getIntExtra("posi_key5",-1);
             birsecildimi = getIntent().getBooleanExtra("birsecildimi",false);
             ikisecildimi = getIntent().getBooleanExtra("ikisecildimi",false);
             ucsecildimi = getIntent().getBooleanExtra("ucsecildimi",false);
             dortsecildimi = getIntent().getBooleanExtra("dortsecildimi",false);
             bessecildimi = getIntent().getBooleanExtra("bessecildimi",false);







        if (hangikonusecildi1 >= 0) {

            // كود يحفظ البيانات لاستعادتها من صفحة البداية
            editor = sharedPreferences.edit();
            editor.putInt("ensonokunankonu",hangikonusecildi1);
            editor.commit();

            pdfView.fromAsset(pdflar1[hangikonusecildi1])
                    .onPageChange(new OnPageChangeListener() {
                        @Override
                        public void onPageChanged(int page, int pageCount) {
                            mcurrentpage= page;
                        }
                    })

                    .defaultPage(gotoPage)
                    .scrollHandle(new DefaultScrollHandle(this,true))
                    .onLongPress(new OnLongPressListener() {
                        @Override
                        public void onLongPress(MotionEvent e) {
                            btnnightmode.setVisibility(View.VISIBLE);
//                            btnsunnymode.setVisibility(View.VISIBLE);

                        }
                    })
                    .onTap(new OnTapListener() {
                        @Override
                        public boolean onTap(MotionEvent e) {
                            btnnightmode.setVisibility(View.INVISIBLE);
                            return true;
                        }
                    })
                    .nightMode(mode) // toggle night mode
                    .load();

        }

        if (hangikonusecildi2 >=0) {
            // كود يحفظ البيانات لاستعادتها من صفحة البداية
            editor = sharedPreferences.edit();
            editor.putInt("ensonokunankonu",hangikonusecildi2);
            editor.commit();


            pdfView.fromAsset(pdflar2[hangikonusecildi2])
                    .onPageChange(new OnPageChangeListener() {
                        @Override
                        public void onPageChanged(int page, int pageCount) {
                            mcurrentpage= page;
                        }
                    })
                    .defaultPage(gotoPage)
                    .scrollHandle(new DefaultScrollHandle(this,true))
                    .onLongPress(new OnLongPressListener() {
                        @Override
                        public void onLongPress(MotionEvent e) {
                            btnnightmode.setVisibility(View.VISIBLE);
//                            btnsunnymode.setVisibility(View.VISIBLE);

                        }
                    })
                    .onTap(new OnTapListener() {
                        @Override
                        public boolean onTap(MotionEvent e) {
                            btnnightmode.setVisibility(View.INVISIBLE);
                            return true;
                        }
                    })
                    .nightMode(mode) // toggle night mode
                    .load();

        }


        if (hangikonusecildi3 >=0) {

            // كود يحفظ البيانات لاستعادتها من صفحة البداية
            editor = sharedPreferences.edit();
            editor.putInt("ensonokunankonu",hangikonusecildi3);
            editor.commit();

            pdfView.fromAsset(pdflar3[hangikonusecildi3])
                    .onPageChange(new OnPageChangeListener() {
                        @Override
                        public void onPageChanged(int page, int pageCount) {
                            mcurrentpage= page;
                        }
                    })
                    .defaultPage(gotoPage)
                    .scrollHandle(new DefaultScrollHandle(this,true))
                    .onLongPress(new OnLongPressListener() {
                        @Override
                        public void onLongPress(MotionEvent e) {
                            btnnightmode.setVisibility(View.VISIBLE);
//                            btnsunnymode.setVisibility(View.VISIBLE);

                        }
                    })
                    .onTap(new OnTapListener() {
                        @Override
                        public boolean onTap(MotionEvent e) {
                            btnnightmode.setVisibility(View.INVISIBLE);
                            return true;
                        }
                    })
                    .nightMode(mode) // toggle night mode
                    .load();

        }

        if (hangikonusecildi4 >=0) {

            // كود يحفظ البيانات لاستعادتها من صفحة البداية
            editor = sharedPreferences.edit();
            editor.putInt("ensonokunankonu",hangikonusecildi4);
            editor.commit();

            pdfView.fromAsset(pdflar4[hangikonusecildi4])
                    .onPageChange(new OnPageChangeListener() {
                        @Override
                        public void onPageChanged(int page, int pageCount) {
                            mcurrentpage= page;
                        }
                    })
                    .defaultPage(gotoPage)
                    .scrollHandle(new DefaultScrollHandle(this,true))
                    .onLongPress(new OnLongPressListener() {
                        @Override
                        public void onLongPress(MotionEvent e) {
                            btnnightmode.setVisibility(View.VISIBLE);
//                            btnsunnymode.setVisibility(View.VISIBLE);

                        }
                    })
                    .onTap(new OnTapListener() {
                        @Override
                        public boolean onTap(MotionEvent e) {
                            btnnightmode.setVisibility(View.INVISIBLE);
                            return true;
                        }
                    })
                    .nightMode(mode) // toggle night mode
                    .load();

        }

        if (hangikonusecildi5 >=0) {

            // كود يحفظ البيانات لاستعادتها من صفحة البداية
            editor = sharedPreferences.edit();
            editor.putInt("ensonokunankonu",hangikonusecildi5);
            editor.commit();

            pdfView.fromAsset(pdflar5[hangikonusecildi5])
                    .onPageChange(new OnPageChangeListener() {
                        @Override
                        public void onPageChanged(int page, int pageCount) {
                            mcurrentpage= page;
                        }
                    })
                    .defaultPage(gotoPage)
                    .scrollHandle(new DefaultScrollHandle(this,true))
                    .onLongPress(new OnLongPressListener() {
                        @Override
                        public void onLongPress(MotionEvent e) {
                            btnnightmode.setVisibility(View.VISIBLE);
//                            btnsunnymode.setVisibility(View.VISIBLE);

                        }
                    })
                    .onTap(new OnTapListener() {
                        @Override
                        public boolean onTap(MotionEvent e) {
                            btnnightmode.setVisibility(View.INVISIBLE);
                            return true;
                        }
                    })
                    .nightMode(mode) // toggle night mode
                    .load();

        }


        btnnightmode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mode == false){
                    editor = sharedPreferences.edit();
                    editor.putBoolean("mode",true);
                    editor.commit();

                    Intent intent = getIntent();
                    intent.putExtra("gotopage",mcurrentpage);
                    finish();
                    startActivity(intent);
                }
                if (mode == true){
                    editor = sharedPreferences.edit();
                    editor.putBoolean("mode",false);
                    editor.commit();

                    Intent intent = getIntent();
                    intent.putExtra("gotopage",mcurrentpage);
                    finish();
                    startActivity(intent);

                }


            }
        });


        if (!mode){
            btnnightmode.setText(""+nightmode);
            btnnightmode.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.dark_mode,0);

//            editor = sharedPreferences.edit();
//            editor.putString("nightmode","الوضع الليلي");
//            editor.commit();
        }

        if (mode){
            btnnightmode.setText(""+sunnymode);
            btnnightmode.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.sunny_mode,0);
//            editor = sharedPreferences.edit();
//            editor.putBoolean("mode",false);
//            editor.putString("sunnymode","الوضع النهاري");
//            editor.commit();
        }



        // onCreate is HERE !!!!!!!!!!!!!
    }



    //تكملة
    //زر الرجوع يلي الصفحة السابقة
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId()==android.R.id.home){
            finish();
            return super.onOptionsItemSelected(item);}
        return false;
    }



//    private void showAlertDialog(int layout){
//        dialogBuilder = new AlertDialog.Builder(PdfReader.this);
//        View layoutView = getLayoutInflater().inflate(layout, null);
//        Button dialogButton = layoutView.findViewById(R.id.btnDialog);
//        Button dialogButton1 = layoutView.findViewById(R.id.btnDialog1);
//        dialogBuilder.setView(layoutView);
//        alertDialog  =  dialogBuilder.create();
//        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        alertDialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
//        alertDialog.show();
//        dialogButton1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                alertDialog.dismiss();
//            }
//        });
//        dialogButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                editor.putBoolean("rateusboole",true);
//                editor.commit();
//                alertDialog.dismiss();
//                Intent i = new Intent(Intent.ACTION_VIEW);
//                i.setData(Uri.parse("market://details?id=" + getPackageName()));
//                startActivity(i);
//            }
//        });
//    }





    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}

