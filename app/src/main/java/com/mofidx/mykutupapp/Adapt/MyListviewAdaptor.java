package com.mofidx.mykutupapp.Adapt;

import static android.content.ContentValues.TAG;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.mofidx.mykutupapp.PdfReader;
import com.mofidx.mykutupapp.R;
import com.mofidx.mykutupapp.RecyclerviewKonular;

import java.util.ArrayList;

public class MyListviewAdaptor extends BaseAdapter {

//    public static InterstitialAd mmInterstitialAd;
    int hangikitab;
    int theposi;
    String []posi1_readed={"posi11","posi12","posi13","posi14","posi15","posi16","posi17","posi18","posi19"
            ,"posi110","posi111","posi112","posi113","posi114","posi115","posi116","posi117","posi118","posi119"};

    String []posi2_readed={"posi21","posi22","posi23","posi24","posi25","posi26","posi27","posi28","posi29"
            ,"posi210","posi211","posi212","posi213","posi214","posi215","posi216","posi217","posi218","posi219","posi220","posi221","posi222","posi223","posi224"};

    String []posi3_readed={"posi31","posi32","posi33","posi34","posi35","posi36","posi37","posi38","posi39"
            ,"posi310","posi311","posi312"};

    String []posi4_readed={"posi41","posi42","posi43","posi44","posi45","posi46","posi47","posi48","posi49"
            ,"posi410","posi411","posi412","posi413","posi414","posi415","posi416","posi417","posi418"};

    String []posi5_readed={"posi51","posi52","posi53","posi54","posi55","posi56","posi57","posi58","posi59"
            ,"posi510","posi511","posi512"};

    Context context ;
    SharedPreferences sharedPreferences=null;
    SharedPreferences.Editor editor;
    ArrayList<String> arrayList = new ArrayList<>();

    public MyListviewAdaptor(Context c, SharedPreferences sharedPreferences, ArrayList<String> arrayList,int hangikitab) {
        this.context = c;
        this.sharedPreferences = sharedPreferences;
        this.arrayList = arrayList;
        this.hangikitab = hangikitab;
//        loadAd();
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v==null){
            v= LayoutInflater.from(context).inflate(R.layout.custom_items,null,false);
        }
        TextView tv = v.findViewById(R.id.recycle_title1);
        ImageView imgreaded = v.findViewById(R.id.readedimg);
        CardView cardView = v.findViewById(R.id.cardlistviewforclick);
        String s = arrayList.get(position);
        tv.setText(s);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                theposi = position;

                gotothecontent();

//                if (theposi%2 == 0 || theposi == 1){
//                    if (mmInterstitialAd != null) {
//                        mmInterstitialAd.show((Activity) context);
//                    } else {
//                        Log.d("TAG", "The interstitial ad wasn't ready yet.");
//                    }
//
//                }


            }
        });


        if (hangikitab==0){
            int readed1 = sharedPreferences.getInt(posi1_readed[position],-1);
            if (readed1 == position){
                imgreaded.setVisibility(View.VISIBLE);
            } else {
                imgreaded.setVisibility(View.INVISIBLE);
            }
        }

        if (hangikitab==1){
            int readed2 = sharedPreferences.getInt(posi2_readed[position],-1);
            if (readed2 == position){
                imgreaded.setVisibility(View.VISIBLE);
            } else {
                imgreaded.setVisibility(View.INVISIBLE);
            }
        }
        if (hangikitab==2){
            int readed3 = sharedPreferences.getInt(posi3_readed[position],-1);
            if (readed3 == position){
                imgreaded.setVisibility(View.VISIBLE);
            } else {
                imgreaded.setVisibility(View.INVISIBLE);
            }
        }
        if (hangikitab==3){
            int readed4 = sharedPreferences.getInt(posi4_readed[position],-1);
            if (readed4 == position){
                imgreaded.setVisibility(View.VISIBLE);
            } else {
                imgreaded.setVisibility(View.INVISIBLE);
            }
        }

        if (hangikitab==4){
            int readed5 = sharedPreferences.getInt(posi5_readed[position],-1);
            if (readed5 == position){
                imgreaded.setVisibility(View.VISIBLE);
            } else {
                imgreaded.setVisibility(View.INVISIBLE);
            }
        }




        return v;
    }



//    private void loadAd(){
//        AdRequest adRequest = new AdRequest.Builder().build();
//
//
//        InterstitialAd.load(context,context.getResources().getString(R.string.myinterstitial), adRequest,
//                new InterstitialAdLoadCallback() {
//                    @Override
//                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
//                        // The mInterstitialAd reference will be null until
//                        // an ad is loaded.
//                        mmInterstitialAd = interstitialAd;
//                        Log.i(TAG, "onAdLoaded");
//
//                        mmInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback(){
//
//                            @Override
//                            public void onAdDismissedFullScreenContent() {
//                                // Called when ad is dismissed.
//                                // Set the ad reference to null so you don't show the ad a second time.
//                                Log.d(TAG, "Ad dismissed fullscreen content.");
//
//                                loadAd();
//
//                            }
//
//                            @Override
//                            public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
//                                super.onAdFailedToShowFullScreenContent(adError);
//
//                                mmInterstitialAd = null;
//
//                            }
//
//                            @Override
//                            public void onAdShowedFullScreenContent() {
//                                // Called when ad is shown.
//                                Log.d(TAG, "Ad showed fullscreen content.");
//
//                                mmInterstitialAd = null;
//
//                            }
//                        });
//
//                    }
//
//
//                    @Override
//                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
//                        // Handle the error
//                        Log.d(TAG, loadAdError.toString());
//                        mmInterstitialAd = null;
//                    }
//                });
//
//
//    }

    private void gotothecontent() {
        if (hangikitab==0){
            editor = sharedPreferences.edit();
            editor.putInt(posi1_readed[theposi], theposi);
            editor.putInt("ensonhangikitabsecildi",hangikitab);
            editor.commit();
            Intent intent1 = new Intent(context, PdfReader.class);
            intent1.putExtra("posi_key1", theposi);
            intent1.putExtra("birsecildimi",true);
            context.startActivity(intent1);
        }

        if (hangikitab==1){
            editor = sharedPreferences.edit();
            editor.putInt(posi2_readed[theposi], theposi);
            editor.putInt("ensonhangikitabsecildi",hangikitab);
            editor.commit();
            Intent intent1 = new Intent(context, PdfReader.class);
            intent1.putExtra("posi_key2", theposi);
            intent1.putExtra("ikisecildimi",true);
            context.startActivity(intent1);
        }
        if (hangikitab==2){
            editor = sharedPreferences.edit();
            editor.putInt(posi3_readed[theposi], theposi);
            editor.putInt("ensonhangikitabsecildi",hangikitab);
            editor.commit();
            Intent intent1 = new Intent(context, PdfReader.class);
            intent1.putExtra("posi_key3", theposi);
            intent1.putExtra("ucsecildimi",true);

            context.startActivity(intent1);
        }
        if (hangikitab==3){
            editor = sharedPreferences.edit();
            editor.putInt(posi4_readed[theposi], theposi);
            editor.putInt("ensonhangikitabsecildi",hangikitab);
            editor.commit();
            Intent intent1 = new Intent(context, PdfReader.class);
            intent1.putExtra("posi_key4", theposi);
            intent1.putExtra("dortsecildimi",true);

            context.startActivity(intent1);
        }
        if (hangikitab==4){
            editor = sharedPreferences.edit();
            editor.putInt(posi5_readed[theposi], theposi);
            editor.putInt("ensonhangikitabsecildi",hangikitab);
            editor.commit();
            Intent intent1 = new Intent(context, PdfReader.class);
            intent1.putExtra("posi_key5", theposi);
            intent1.putExtra("bessecildimi",true);
            context.startActivity(intent1);
        }
    }
}
