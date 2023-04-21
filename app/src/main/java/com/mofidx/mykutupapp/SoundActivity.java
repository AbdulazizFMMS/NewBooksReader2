package com.mofidx.mykutupapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.mofidx.mykutupapp.Adaptor.MyRecyclerAdapter;
import com.mofidx.mykutupapp.Adaptor.RecyclerTouchListener;

import java.util.ArrayList;


public class SoundActivity extends AppCompatActivity {

    ArrayList<listitem> listitems = new ArrayList<>();

    static int Photos = R.drawable.podcastplayer;
    static String[] Titles = {"ماذا تفعل إذا جاءتك الرغبة الشديدة ", "هل للعادة السرية فوائد ؟",
            "الرغبة الملحة للاستمناء ما السبب وإلى متى تستمر؟", "كيف تكره الاستمناء والاباحية (العلاج التنفيري)", "كيف تبدل العادة السرية وخطورة هذا التبديل!"
            , "إعادة توجيه الانتباه ومنحنى الشهوة", "كيف توقف الشعور القوي جدا جدا بالاشتهاء للاستمناء", "طرق تشتيت الانتباه للتعامل مع الرغبات المُلِّحة الشديدة",
            " الشعور بالرغبة المُلِّحة للاستمناء فرصة يجب استغلالها!", " كيف ترفض عروض الانتكاسة؟","هل الزواج حلا ؟","مدة التعافي من ضعف الانتصاب","خمس أساطير حول العادة السرية"," سرعة القذف ما الحل؟","مكتئب ومحبط وكسول هل الإباحية السبب؟","رسالة إلى عزيزتي الإباحية"};
    static int[] MP3Sounds = {R.raw.z01,R.raw.z1, R.raw.z2, R.raw.z3, R.raw.z4, R.raw.z5, R.raw.z6, R.raw.z7, R.raw.z8, R.raw.z9, R.raw.z10, R.raw.z11, R.raw.z12, R.raw.z13, R.raw.z14, R.raw.z15};


    RecyclerView recyclerView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound);

        recyclerView = findViewById(R.id.recycler_view);



        for (int i = 0; i < Titles.length; i++) {
            listitems.add(new listitem(Titles[i], Photos, MP3Sounds[i]));
        }








        MyRecyclerAdapter adapter = new MyRecyclerAdapter(listitems);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(lm);
        recyclerView.setAdapter(adapter);




        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {

                Intent intent1 = new Intent(SoundActivity.this, NasheedActivity.class);
                intent1.putExtra("pos_key", position);
                startActivity(intent1);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));



}

}

