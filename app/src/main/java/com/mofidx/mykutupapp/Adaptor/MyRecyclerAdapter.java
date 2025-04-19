//package com.mofidx.mykutupapp.Adaptor;
//
//
//import static android.content.ContentValues.TAG;
//
//import android.app.Activity;
//import android.content.Context;
//import android.content.Intent;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//
//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.FullScreenContentCallback;
//import com.google.android.gms.ads.LoadAdError;
//import com.google.android.gms.ads.interstitial.InterstitialAd;
//import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
//import com.mofidx.mykutupapp.NasheedActivity;
//import com.mofidx.mykutupapp.R;
//import com.mofidx.mykutupapp.SoundActivity;
//import com.mofidx.mykutupapp.listitem;
//
//import java.util.ArrayList;
//
//public class MyRecyclerAdapter  extends RecyclerView.Adapter<MyHolder> {
//    ArrayList<listitem> items;
//    Context context;
//    int theposition;
////    private InterstitialAd mInterstitialAd;
//
//    public MyRecyclerAdapter(ArrayList<listitem> items , Context c) {
//        this.items = items;
//        this.context = c;
//
////        loadAd();
//    }
//
//
//    @NonNull
//    @Override
//    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//
//        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_itme,parent , false);
//        MyHolder viewholder = new MyHolder(v);
//        return viewholder;
//
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
//        listitem items1 = items.get(position);
//        holder.img1.setImageResource(items1.getImg());
//        holder.txt1.setText(items1.getTitle());
//
//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                theposition = holder.getAdapterPosition();
//
//                gotothecontent();
//
////                if (theposition%2 == 0 || theposition == 1){
////
////                    if (mInterstitialAd != null) {
////                        mInterstitialAd.show((Activity) context);
////                    } else {
////                        Log.d("TAG", "The interstitial ad wasn't ready yet.");
////                    }
////
////                }
//
//
//
//
//
//
//
//
//            }
//        });
//
//    }
//
//
//
//    @Override
//    public int getItemCount() {
//        return items.size();
//    }
//
//
//
//
//
//
////    private void loadAd(){
////        AdRequest adRequest = new AdRequest.Builder().build();
////
////
////        InterstitialAd.load(context,context.getResources().getString(R.string.myinterstitialnasheeds), adRequest,
////                new InterstitialAdLoadCallback() {
////                    @Override
////                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
////                        // The mInterstitialAd reference will be null until
////                        // an ad is loaded.
////                        mInterstitialAd = interstitialAd;
////                        Log.i(TAG, "onAdLoaded");
////
////                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback(){
////
////                            @Override
////                            public void onAdDismissedFullScreenContent() {
////                                // Called when ad is dismissed.
////                                // Set the ad reference to null so you don't show the ad a second time.
////                                Log.d(TAG, "Ad dismissed fullscreen content.");
////
//////                                loadAd();
////
////                            }
////
////
////
////                            @Override
////                            public void onAdShowedFullScreenContent() {
////                                // Called when ad is shown.
////                                Log.d(TAG, "Ad showed fullscreen content.");
////                                mInterstitialAd = null;
////                            }
////                        });
////
////                    }
////
////                    @Override
////                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
////                        // Handle the error
////                        Log.d(TAG, loadAdError.toString());
////                        mInterstitialAd = null;
////                    }
////                });
////
////
////    }
//
//
//
//    private void gotothecontent() {
//
//        Intent intent1 = new Intent(context, NasheedActivity.class);
//        intent1.putExtra("pos_key", theposition);
//        context.startActivity(intent1);
//
//    }
//
//
//
//}
//
//
//
