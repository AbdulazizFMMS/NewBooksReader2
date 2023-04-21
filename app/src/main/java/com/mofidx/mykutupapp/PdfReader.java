package com.mofidx.mykutupapp;

import static android.service.controls.ControlsProviderService.TAG;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
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
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class PdfReader extends AppCompatActivity {
    Boolean mode,rateus;
    String sunnymode,nightmode;
    Button btnnightmode,btnsunnymode;
    AlertDialog.Builder dialogBuilder;
    AlertDialog alertDialog;
    AdRequest adRequest;
//    private InterstitialAd mInterstitialAd;
PDFView pdfView;
int mcurrentpage,  intcurrentpage1 , intcurrentpage2,intcurrentpage3,intcurrentpage4,intcurrentpage5;
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
    AdView adView;
SharedPreferences sharedPreferences=null;
SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_reader);



        adRequest = new AdRequest.Builder().build();



//        // TODO: Add interstitial to your view hierarchy.
//        MobileAds.initialize(this, new OnInitializationCompleteListener() {
//            @Override
//            public void onInitializationComplete(InitializationStatus initializationStatus) {
//            }
//        });
//
//
//        InterstitialAd.load(this,getResources().getString(R.string.myinterstitial), adRequest,
//                new InterstitialAdLoadCallback() {
//                    @RequiresApi(api = Build.VERSION_CODES.R)
//                    @Override
//                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
//                        // The mInterstitialAd reference will be null until
//                        // an ad is loaded.
//                        mInterstitialAd = interstitialAd;
//                        Log.i(TAG, "onAdLoaded");
//                    }
//
//                    @Override
//                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
//                        // Handle the error
//                        Log.d(TAG, loadAdError.toString());
//                        mInterstitialAd = null;
//                    }
//                });

        // TODO: Add adView to your view hierarchy.
        adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId(getResources().getString(R.string.mybanner));

        adView = findViewById(R.id.adView);
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


//        if (mode){
//             sunnymode = sharedPreferences.getString("sunnymode","الوضع النهاري");
//        }




//        if (id[0]>51){
//            try {
//                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
//            } catch (android.content.ActivityNotFoundException anfe) {
//                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
//            }
//        }if (id[0]<0){
//            pdfView.this.finish();
//        }
//

//        int openwhichbook = getIntent().getIntExtra("openbook", 0);

        int hangikonusecildi1 = getIntent().getIntExtra("posi_key1",-1);
        int hangikonusecildi2 = getIntent().getIntExtra("posi_key2",-1);
        int hangikonusecildi3 = getIntent().getIntExtra("posi_key3",-1);
        int hangikonusecildi4 = getIntent().getIntExtra("posi_key4",-1);
        int hangikonusecildi5 = getIntent().getIntExtra("posi_key5",-1);



        if (hangikonusecildi1 >= 0) {

            pdfView.fromAsset(pdflar1[hangikonusecildi1])
//
//                    .onPageChange(new OnPageChangeListener() {
//                        @Override
//                        public void onPageChanged(int page, int pageCount) {
//                            editor = sharedPreferences.edit();
//                            editor.putInt("intcurrentpage1",page);
//                            editor.commit();
//                            if(page+1 == 137){
//                                if (!rateus){
//                                    showAlertDialog(R.layout.dialog_postive_layout1);
//                                }
//
//                            }
//
//
//                        }
//
//                    })
//                    .defaultPage(intcurrentpage1)
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

            pdfView.fromAsset(pdflar2[hangikonusecildi2])
//                    .onPageChange(new OnPageChangeListener() {
//                        @Override
//                        public void onPageChanged(int page, int pageCount) {
//                            editor = sharedPreferences.edit();
//                            editor.putInt("intcurrentpage2",page);
//                            editor.commit();
//                            if(page+1 == 110){
//                                if (!rateus){
//                                    showAlertDialog(R.layout.dialog_postive_layout1);
//                                }
//                            }
//
//                        }
//
//                    })
//                    .defaultPage(intcurrentpage2)
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

            pdfView.fromAsset(pdflar3[hangikonusecildi3])
//                    .onPageChange(new OnPageChangeListener() {
//                        @Override
//                        public void onPageChanged(int page, int pageCount) {
//                            editor = sharedPreferences.edit();
//                            editor.putInt("intcurrentpage2",page);
//                            editor.commit();
//                            if(page+1 == 110){
//                                if (!rateus){
//                                    showAlertDialog(R.layout.dialog_postive_layout1);
//                                }
//                            }
//
//                        }
//
//                    })
//                    .defaultPage(intcurrentpage2)
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

            pdfView.fromAsset(pdflar4[hangikonusecildi4])
//                    .onPageChange(new OnPageChangeListener() {
//                        @Override
//                        public void onPageChanged(int page, int pageCount) {
//                            editor = sharedPreferences.edit();
//                            editor.putInt("intcurrentpage2",page);
//                            editor.commit();
//                            if(page+1 == 110){
//                                if (!rateus){
//                                    showAlertDialog(R.layout.dialog_postive_layout1);
//                                }
//                            }
//
//                        }
//
//                    })
//                    .defaultPage(intcurrentpage2)
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

            pdfView.fromAsset(pdflar5[hangikonusecildi5])
//                    .onPageChange(new OnPageChangeListener() {
//                        @Override
//                        public void onPageChanged(int page, int pageCount) {
//                            editor = sharedPreferences.edit();
//                            editor.putInt("intcurrentpage2",page);
//                            editor.commit();
//                            if(page+1 == 110){
//                                if (!rateus){
//                                    showAlertDialog(R.layout.dialog_postive_layout1);
//                                }
//                            }
//
//                        }
//
//                    })
//                    .defaultPage(intcurrentpage2)
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
//        if (openwhichbook == 2) {
//
//            pdfView.fromAsset("A3.pdf")
//                    .onPageChange(new OnPageChangeListener() {
//                        @Override
//                        public void onPageChanged(int page, int pageCount) {
//                            editor = sharedPreferences.edit();
//                            editor.putInt("intcurrentpage3",page);
//                            editor.commit();
//                            if(page+1 == 110){
//                                if (!rateus){
//                                    showAlertDialog(R.layout.dialog_postive_layout1);
//                                }
//                            }
//
//                        }
//
//                    })
//                    .defaultPage(intcurrentpage3)
//                    .scrollHandle(new DefaultScrollHandle(this,true))
//                    .onLongPress(new OnLongPressListener() {
//                        @Override
//                        public void onLongPress(MotionEvent e) {
//                            btnnightmode.setVisibility(View.VISIBLE);
////                            btnsunnymode.setVisibility(View.VISIBLE);
//
//                        }
//                    })
//                    .onTap(new OnTapListener() {
//                        @Override
//                        public boolean onTap(MotionEvent e) {
//                            btnnightmode.setVisibility(View.INVISIBLE);
//                            return true;
//                        }
//                    })
//                    .nightMode(mode) // toggle night mode
//                    .load();
//
//
//
//        }
//
//        if (openwhichbook == 3) {
//            pdfView.fromAsset("A4.pdf")
//                    .onPageChange(new OnPageChangeListener() {
//                        @Override
//                        public void onPageChanged(int page, int pageCount) {
//                            editor = sharedPreferences.edit();
//                            editor.putInt("intcurrentpage4",page);
//                            editor.commit();
//                            if(page+1 == 128){
//                                if (!rateus){
//                                    showAlertDialog(R.layout.dialog_postive_layout1);
//                                }
//                            }
//
//                        }
//
//                    })
//                    .defaultPage(intcurrentpage4)
//                    .scrollHandle(new DefaultScrollHandle(this,true))
//                    .onLongPress(new OnLongPressListener() {
//                        @Override
//                        public void onLongPress(MotionEvent e) {
//                            btnnightmode.setVisibility(View.VISIBLE);
////                            btnsunnymode.setVisibility(View.VISIBLE);
//
//                        }
//                    })
//                    .onTap(new OnTapListener() {
//                        @Override
//                        public boolean onTap(MotionEvent e) {
//                            btnnightmode.setVisibility(View.INVISIBLE);
//                            return true;
//                        }
//                    })
//                    .nightMode(mode) // toggle night mode
//                    .load();
//
//
//
//        }
//
//        if (openwhichbook == 4) {
//            pdfView.fromAsset("A5.pdf")
//                    .onPageChange(new OnPageChangeListener() {
//                        @Override
//                        public void onPageChanged(int page, int pageCount) {
//                            editor = sharedPreferences.edit();
//                            editor.putInt("intcurrentpage5",page);
//                            editor.commit();
//                            if(page+1 == 69){
//
//                                showAlertDialog(R.layout.dialog_postive_layout1);
//
//                            }
//
//                        }
//
//                    })
//                    .defaultPage(intcurrentpage5)
//                    .scrollHandle(new DefaultScrollHandle(this,true))
//                    .onLongPress(new OnLongPressListener() {
//                        @Override
//                        public void onLongPress(MotionEvent e) {
//                            btnnightmode.setVisibility(View.VISIBLE);
////                            btnsunnymode.setVisibility(View.VISIBLE);
//
//                        }
//                    })
//                    .onTap(new OnTapListener() {
//                        @Override
//                        public boolean onTap(MotionEvent e) {
//                            btnnightmode.setVisibility(View.INVISIBLE);
//                            return true;
//                        }
//                    })
//                    .nightMode(mode) // toggle night mode
//                    .load();
//
//
//        }

        btnnightmode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mode == false){
                    editor = sharedPreferences.edit();
                    editor.putBoolean("mode",true);
                    editor.commit();

                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);
                }
                if (mode == true){
                    editor = sharedPreferences.edit();
                    editor.putBoolean("mode",false);
                    editor.commit();

                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);
                }


            }
        });
//        btnsunnymode.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                editor = sharedPreferences.edit();
//                editor.putBoolean("mode",false);
//                editor.commit();
//            }
//        });

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



    private void showAlertDialog(int layout){
        dialogBuilder = new AlertDialog.Builder(PdfReader.this);
        View layoutView = getLayoutInflater().inflate(layout, null);
        Button dialogButton = layoutView.findViewById(R.id.btnDialog);
        Button dialogButton1 = layoutView.findViewById(R.id.btnDialog1);
        dialogBuilder.setView(layoutView);
        alertDialog  =  dialogBuilder.create();
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
                editor.putBoolean("rateusboole",true);
                editor.commit();
                alertDialog.dismiss();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("market://details?id=" + getPackageName()));
                startActivity(i);
            }
        });
    }




}