package com.mofidx.mykutupapp;

import static android.service.controls.ControlsProviderService.TAG;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.material.imageview.ShapeableImageView;


//import com.google.android.gms.ads.interstitial.InterstitialAd;
//import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class BookDetails extends AppCompatActivity {


    ShapeableImageView bookimage;
    TextView name, desc, pages;
    Button readbookbtn , btnshare;

//    int [] images = new int[] {R.drawable.a1, R.drawable.a2 ,R.drawable.a3 ,R.drawable.a4 ,R.drawable.a5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);








        //زر الرجوع يلي الصفحة السابقة
        //يتبع بالاسفل
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true); }


        bookimage = findViewById(R.id.bookimage);
        name = findViewById(R.id.bookname);
        desc = findViewById(R.id.bookdescription);
        pages = findViewById(R.id.booknoofpages);
        readbookbtn = findViewById(R.id.btn_readbook);
        btnshare = findViewById(R.id.btn_btnshare);

        int image = getIntent().getExtras().getInt("bookindex", 0);

        if (image == 0) {
            bookimage.setImageResource(R.drawable.a1);
            name.setText("تأثيرات الاباحية على الدماغ");
            desc.setText("يلجأ البعض إلى مُشاهدة الأفلام الإباحيّة لزيادة الإثارة وتعزيز الرّغبة الجنسيّة، من دون معرفة أنّ الأمر قد ينتهي بهم في دوامة الإدمان على هذه العادة. ويُسبّب الإدمان على الأفلام الإباحيّة العديد من الأضرار على مُختلف الصعد لا سيّما على صعيد الدّماغ.");
            pages.setText("137 صفحة");

            readbookbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(BookDetails.this,  RecyclerviewKonular.class);
                    intent.putExtra("openbook", 0);
                    startActivity(intent);
                }
            });

        }

        if (image == 1) {
            bookimage.setImageResource(R.drawable.a2);
            name.setText("سبیل التعافي من إدمان الإباحیة");
            desc.setText("اقدم لكم - في البدایة - تجربة لأحد المتخصصین في علاج إدمان الإباحیة و ھو شاب أمریكي یدعى \n" +
                    "ألیكس و كان ھو نفسھ یعاني من إدمان المواد الإباحیة و كافح حتى شفي من ھذا المرض خلال \n" +
                    "عامین منذ عام ٢٠٠٨ وحتى عام ٢");
            pages.setText("110 صفحة");

            readbookbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(BookDetails.this,  RecyclerviewKonular.class);
                    intent.putExtra("openbook", 1);
                    startActivity(intent);
                }
            });

        }

        if (image == 2) {
            bookimage.setImageResource(R.drawable.a3);
            name.setText("كيف تقلع عن  الاباحية للأبد ");
            desc.setText("كتب شون راسيل في مقدمة كتابه: كيف تقلع عن الإباحية؟ يقول:\n" +
                    "\n" +
                    "قبل كل شيء، مبارك عليكم أنكم اخذتم تلك الخطوة الاولى نحو تحسين حياتكم\n" +
                    "والإقلاع عن الإباحية؛ من أجل أن تكونوا أشخاصاً صالحين.\n" +
                    "اسمحوا لي ان أقول لكم : إن الإقلاع عن الاباحية ليس بالأمر السهل .\n" +
                    "أنا أعرف ذلك من تجربتي الشخصية.\n" +
                    "منذ 3 سنوات كنت واحدا من أكبر مدمني الاباحية.\n" +
                    "حسنًا ربما قضيت أكثر من 10 أعوام وكأنني عبد للإباحية وممارسة \n" +
                    "العادة السرية، لقد أحببتهما كثيراً...");
            pages.setText("110 صفحة");

            readbookbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(BookDetails.this,  RecyclerviewKonular.class);
                    intent.putExtra("openbook", 2);
                    startActivity(intent);
                }
            });

        }

        if (image == 3) {
            bookimage.setImageResource(R.drawable.a4);
            name.setText("هوايات وعادات كيف نحارب الإباحية\n" +
                    "بتغيير نمط حياتنا؟");
            desc.setText("هذا الكتاب الذي بين أيدينا والذي أعتبره من الكتب \n" +
                    "الرائعة والفريدة التي ألّفت لعلاج إدمان الإباحية لأنها ناقشت بصورة مركزة \n" +
                    "أهم محور وخطوة للتعافي من الإدمان بصورة عامة وإدمان الإباحية بصورة \n" +
                    "خاصة حيث تكلمت بعمق حول كيفية تغيير نمط الحياة الذي يعيشه المدمن \n" +
                    "عبر تغيير عاداته السيئة بأخرى صحية جيدة وممارسة هوايات ونشاطات \n" +
                    "تعيد تشكيل نمط الحياة إلى الافضل وبالتالي يحدث التعافي.");
            pages.setText("128 صفحة");

            readbookbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    Intent intent = new Intent(BookDetails.this,  RecyclerviewKonular.class);
                    intent.putExtra("openbook", 3);
					

					
                    startActivity(intent);
                }
            });

        }
        if (image == 4) {
            bookimage.setImageResource(R.drawable.a5);
            name.setText(" الخطوات السبعة للشفاء\n من إدمان الإباحیة");
            desc.setText("ما ھو إدمان الإباحیة وتعریفھا ؟ \n" +
                    "لكي نفھم ما ھو إدمان الإباحیة علینا ان نعرف أولا أنه  لا یوجد تعریف إكلینیكي موحد \n" +
                    "للإدمان.\n" +
                    "لاحظ أخي أن مؤلف ھذا الكتاب د كیفن سكینر مؤلف كتاب \" علاج إدمان الإباحیة \n" +
                    "، الأدوات الأساسیة للشفاء \"، لاحظ إنھ لیس بمسلم وأنھ غربي، حیث الإباحیة مصرح \n" +
                    "بھا عندھم وحیث التبرج و السفور و الاختلاط و العلاقات المحرمة متاحة في أوسع \n" +
                    "صورة لھا، ومع ذلك فھو یعتبر علمیا أن المستوى الأول للإدمان أن تشاھد المواد \n" +
                    "الإباحیة مرة أو مرتین في العام، فھم قد أوصلتھم التجارب والمعاناة أن ھذه بدایة \n" +
                    "الطریق إلى الھاویة");
            pages.setText("69 صفحة");

            readbookbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(BookDetails.this,  RecyclerviewKonular.class);
                    intent.putExtra("openbook", 4);
                    startActivity(intent);
					

					
                }
            });

        }

        btnshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(Intent.ACTION_SEND);
                myintent.setType("text/plain");
                String Sharebody = "تعلَّم كيف توقف الإباحية  : https://play.google.com/store/apps/details?id=com.mofidx.mykutupapp ";
                //String sharelink = "";
                //myintent.putExtra(Intent.EXTRA_SUBJECT, sharelink);
                myintent.putExtra(Intent.EXTRA_TEXT, Sharebody);
                startActivity(Intent.createChooser(myintent, "شارك التطبيق مع اصدقائك :"));
            }
        });


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