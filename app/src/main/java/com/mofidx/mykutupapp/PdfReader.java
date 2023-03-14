package com.mofidx.mykutupapp;

import static android.service.controls.ControlsProviderService.TAG;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
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
    AdRequest adRequest;
//    private InterstitialAd mInterstitialAd;
PDFView pdfView;
int mcurrentpage,  intcurrentpage1 , intcurrentpage2,intcurrentpage3,intcurrentpage4,intcurrentpage5;
//String [] pdflar= {"A1.pdf","A2.pdf","A3.pdf","A4.pdf","A5.pdf"};
//String [] intersitiallar= {"intcurrentpage1","intcurrentpage2","intcurrentpage3","intcurrentpage4","intcurrentpage5"};

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


        pdfView = findViewById(R.id.pdfView);


        sharedPreferences = getSharedPreferences("MofidxBooksReader",0);

        intcurrentpage1 = sharedPreferences.getInt("intcurrentpage1",0);
        intcurrentpage2 = sharedPreferences.getInt("intcurrentpage2",0);
        intcurrentpage3 = sharedPreferences.getInt("intcurrentpage3",0);
        intcurrentpage4 = sharedPreferences.getInt("intcurrentpage4",0);
        intcurrentpage5 = sharedPreferences.getInt("intcurrentpage5",0);




        int openwhichbook = getIntent().getIntExtra("openbook", 0);

        if (openwhichbook == 0) {



            pdfView.fromAsset("A1.pdf")
                    .onPageChange(new OnPageChangeListener() {
                        @Override
                        public void onPageChanged(int page, int pageCount) {
                            editor = sharedPreferences.edit();
                            editor.putInt("intcurrentpage1",page);
                            editor.commit();

                        }

                    })
                    .defaultPage(intcurrentpage1)
                    .spacing(2)
                    .load();



        }

        if (openwhichbook == 1) {



            pdfView.fromAsset("A2.pdf")
                    .onPageChange(new OnPageChangeListener() {
                        @Override
                        public void onPageChanged(int page, int pageCount) {
                            editor = sharedPreferences.edit();
                            editor.putInt("intcurrentpage2",page);
                            editor.commit();

                        }

                    })
                    .defaultPage(intcurrentpage2)
                    .spacing(2)
                    .load();


        }

        if (openwhichbook == 2) {

            pdfView.fromAsset("A3.pdf")
                    .onPageChange(new OnPageChangeListener() {
                        @Override
                        public void onPageChanged(int page, int pageCount) {
                            editor = sharedPreferences.edit();
                            editor.putInt("intcurrentpage3",page);
                            editor.commit();

                        }

                    })
                    .defaultPage(intcurrentpage3)
                    .spacing(2)
                    .load();



        }

        if (openwhichbook == 3) {
            pdfView.fromAsset("A4.pdf")
                    .onPageChange(new OnPageChangeListener() {
                        @Override
                        public void onPageChanged(int page, int pageCount) {
                            editor = sharedPreferences.edit();
                            editor.putInt("intcurrentpage4",page);
                            editor.commit();

                        }

                    })
                    .defaultPage(intcurrentpage4)
                    .spacing(2)
                    .load();



        }
        if (openwhichbook == 4) {
            pdfView.fromAsset("A5.pdf")
                    .onPageChange(new OnPageChangeListener() {
                        @Override
                        public void onPageChanged(int page, int pageCount) {
                            editor = sharedPreferences.edit();
                            editor.putInt("intcurrentpage5",page);
                            editor.commit();

                        }

                    })
                    .defaultPage(intcurrentpage5)
                    .spacing(2)
                    .load();


        }

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

}