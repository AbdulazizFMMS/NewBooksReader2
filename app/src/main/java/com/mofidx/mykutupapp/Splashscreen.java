//package com.mofidx.mykutupapp;
//
//import static androidx.lifecycle.Lifecycle.Event.ON_START;
//import static com.mofidx.mykutupapp.data.AlarmReminderProvider.LOG_TAG;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.lifecycle.OnLifecycleEvent;
//
//import android.app.Application;
//import android.content.Intent;
//import android.content.SharedPreferences;
//import android.os.Bundle;
//import android.os.Handler;
//
//import android.util.Log;
//import android.view.WindowManager;
//
//import android.widget.ProgressBar;
//import android.widget.TextView;
//
//
//import com.google.android.gms.ads.MobileAds;
//import com.google.android.gms.ads.initialization.InitializationStatus;
//import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
//
//import com.tomer.fadingtextview.FadingTextView;
//
//
//
//public class Splashscreen extends AppCompatActivity {
//
//    SharedPreferences sharedPreferences = null;
//    SharedPreferences.Editor editor;
//
//   boolean isBackPressed ;
//    TextView textView2;
//FadingTextView fadingTextView;
//
//ProgressBar progressBar2;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_splashscreen);
//
//
//
//
//        sharedPreferences = getSharedPreferences("MofidxBooksReader",0);
//
//        progressBar2 =findViewById(R.id.progressBar2);
//        textView2 =findViewById(R.id.txt2);
//        fadingTextView =findViewById(R.id.fadingTextView);
//
////        fadingTextView.setTexts(texts);
//        fadingTextView.shuffle();
//
//        progressBar2.setMax(100);
//        progressBar2.setScaleY(2f);
//
//        progressAnimaion();
//
//// This method is used so that your splash activity can cover the entire screen.
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
//
////        setContentView(R.layout.activity_main); // this will bind your MainActivity.class file with activity_main.
//
////        isBackPressed= sharedPreferences.getBoolean("isbackpressed", false);
////        if (!isBackPressed){
////            new Handler().postDelayed(new Runnable() {
////                @Override
////                public void run() {
////
////
////                    Application application = getApplication();
////
////                    // If the application is not an instance of MyApplication, log an error message and
////                    // start the MainActivity without showing the app open ad.
////                    if (!(application instanceof MyApplication)) {
////                        Log.e(LOG_TAG, "Failed to cast application to MyApplication.");
////                        startMainActivity();
////                        return;
////                    }
////
////                    // Show the app open ad.
////                    ((MyApplication) application).showAdIfAvailable(Splashscreen.this,new MyApplication.OnShowAdCompleteListener() {
////
////                        @Override
////                        public void onShowAdComplete() {
////                            startMainActivity();
////                        }
////                    });
////
////
////
////                }
////            }, 3500);
////        }else {
////            Intent i = new Intent(Splashscreen.this, MainActivity.class);
////            startActivity(i); // invoke the SecondActivity.
////            finish();
////            editor = sharedPreferences.edit();
////            editor.putBoolean("isbackpressed", false);
////            editor.commit();
////        }
//
//
//
//
//    }
//
//    private void progressAnimaion() {
//        ProgressBarAnimationForSplashscreen progressBarAnimationForSplashscreen = new ProgressBarAnimationForSplashscreen(progressBar2  ,textView2, 0f,100f);
//        progressBarAnimationForSplashscreen.setDuration(2500);
//        progressBar2.setAnimation(progressBarAnimationForSplashscreen);
//
//    }
//
//
//
//    /** Start the MainActivity. */
//    public void startMainActivity() {
//        // Intent is used to switch from one activity to another.
//        Intent i = new Intent(Splashscreen.this, MainActivity.class);
//        startActivity(i); // invoke the SecondActivity.
//        finish(); // the current activity will get finished.
//
//    }
//
//
//
//
//
//}