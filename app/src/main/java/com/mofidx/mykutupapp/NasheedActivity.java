//package com.mofidx.mykutupapp;
//
//import static android.content.ContentValues.TAG;
//
//import android.media.MediaPlayer;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.SeekBar;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.content.res.AppCompatResources;
//
//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.LoadAdError;
//import com.google.android.gms.ads.interstitial.InterstitialAd;
//import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
//
//public class NasheedActivity extends AppCompatActivity {
//
//    MediaPlayer sound = new MediaPlayer();
//    int id;
//    SeekBar seekBar;
//    ImageView pausesong,playsong, song_back, song_after,song_img,songslidescreen;
//    TextView tvTitle, tvCurrentTime, tvTotalTime,songname;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_nasheed);
//
//        seekBar =  findViewById(R.id.seekBar);
//        song_img =  findViewById(R.id.song_img);
//        songslidescreen =  findViewById(R.id.song_slide_screen);
//        pausesong =  findViewById(R.id.song_play1);
//        playsong =  findViewById(R.id.song_play2);
//        song_back =  findViewById(R.id.song_back);
//        song_after =  findViewById(R.id.song_after);
//        tvTitle =  findViewById(R.id.tvTitle);
//        tvCurrentTime = findViewById(R.id.tvCurrentTime);
//        tvTotalTime =  findViewById(R.id.tvTotalTime);
//        songname =  findViewById(R.id.song_name);
//
////        /*ads
//
//
//        id=getIntent().getIntExtra("pos_key",0);
//
////        song_img.setImageDrawable(getResources().getDrawable(SoundActivity.MP3Sounds[id]));
//        song_img.setImageDrawable(AppCompatResources.getDrawable(this,SoundActivity.Photos));
//        sound = MediaPlayer.create(NasheedActivity.this, SoundActivity.MP3Sounds[id]);
//        songname.setText(SoundActivity.Titles[id]);
//
////        if (!sound.isPlaying()) {
////            Thread updateSeekBar;
////                    updateSeekBar = new Thread() {
////                        @Override
////                        public void run() {
////                            int SoundDuration = sound.getDuration();
////                            int currentPostion = 0;
////                            seekBar.setMax(SoundDuration);
////                            while (currentPostion < SoundDuration) {
////                                try {
////                                    sleep(100);
////                                    currentPostion = sound.getCurrentPosition();
////                                    seekBar.setProgress(currentPostion);
////
////                                } catch (InterruptedException e) {
////                                    e.printStackTrace();
////                                }
////                            }
////                        }
////                    };
////                    sound.start();
////                    updateSeekBar.start();
////
////                }
//
//
//        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
//                if (b) sound.seekTo(i);
//                SoundTime();
//
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//
//            }
//        });
//
//
//
//
//        pausesong.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sound.pause();
//                playsong.setVisibility(View.VISIBLE);
//                pausesong.setVisibility(View.GONE);
//            }
//        });
//        playsong.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                  if (!sound.isPlaying()) {
//                    Thread updateSeekBar;
//                    updateSeekBar = new Thread() {
//                        @Override
//                        public void run() {
//                            int SoundDuration = sound.getDuration();
//                            int currentPostion = 0;
//                            seekBar.setMax(SoundDuration);
//                            while (currentPostion < SoundDuration) {
//                                try {
//                                    sleep(100);
//                                    currentPostion = sound.getCurrentPosition();
//                                    seekBar.setProgress(currentPostion);
//
//                                } catch (InterruptedException e) {
//                                    e.printStackTrace();
//                                }
//                            }
//                        }
//                    };
//                    sound.start();
//                    updateSeekBar.start();
//                    playsong.setVisibility(View.GONE);
//                    pausesong.setVisibility(View.VISIBLE);
//                }
//
//            }
//        });
//
//
//
//        song_after.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sound.stop();
//
//                playsong.setVisibility(View.VISIBLE);
//                pausesong.setVisibility(View.GONE);
//                id = id+1;
//                try {
//                    song_img.setImageDrawable(AppCompatResources.getDrawable(NasheedActivity.this,SoundActivity.Photos));
//                    sound = MediaPlayer.create(NasheedActivity.this, SoundActivity.MP3Sounds[id]);
//                    songname.setText(SoundActivity.Titles[id]);
//                    SoundTime();
//                } catch (Exception e){
//                    Toast.makeText(NasheedActivity.this, "لقد وصلت الى الاخير بالفعل!", Toast.LENGTH_SHORT).show();
//                    id = id-1;
//                    sound = MediaPlayer.create(NasheedActivity.this, SoundActivity.MP3Sounds[id]);
//                }
//
//            }
//        });
//        song_back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sound.stop();
//
//                playsong.setVisibility(View.VISIBLE);
//                pausesong.setVisibility(View.GONE);
//                id = id-1;
//                try {
//
//                    song_img.setImageDrawable(AppCompatResources.getDrawable(NasheedActivity.this,SoundActivity.Photos));
//                    sound = MediaPlayer.create(NasheedActivity.this, SoundActivity.MP3Sounds[id]);
//                    songname.setText(SoundActivity.Titles[id]);
//                    SoundTime();
//                } catch (Exception e){
//                    Toast.makeText(NasheedActivity.this, "انت في اول محاضرة بالفعل!", Toast.LENGTH_SHORT).show();
//                    id = id+1;
//                    sound = MediaPlayer.create(NasheedActivity.this, SoundActivity.MP3Sounds[id]);
//                }
//            }
//        });
//
//        songslidescreen.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sound.pause();
//                finish();
//            }
//        });
//
//
//
//
//
//
//
//
//            }
//
//
//    private void SoundTime() {
//        seekBar.setMax(sound.getDuration());
//        int tim = (seekBar.getMax() / 1000);
//        int m = tim / 60;
//        int s = tim % 60;
//        //////
//        int tim0 = (seekBar.getProgress() / 1000);
//        int m0 = tim0 / 60;
//        int s0 = tim0 % 60;
//
//        if (s0<10){
//            //التوتال تايم والكرنت تايم معكوسين
//        tvTotalTime.setText(m0 + " : 0" + s0);
//
//        }else {
//            tvTotalTime.setText(m0 + " : " + s0);
//
//        }
//        if (s<10){
//            tvCurrentTime.setText(m + " : 0" + s);
//
//        }else{
//            tvCurrentTime.setText(m + " : " + s);
//        }
//    }
//
//
//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        sound.stop();
//    }
//}