package com.mofidx.mykutupapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;

import com.mofidx.mykutupapp.Adapt.MyListviewAdaptor;

import java.util.ArrayList;

public class RecyclerviewKonular extends AppCompatActivity {
    AlertDialog.Builder dialogBuilder;
    AlertDialog alertDialog;
    MyListviewAdaptor myListviewAdaptor;
    SharedPreferences sharedPreferences=null;
    SharedPreferences.Editor editor;
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

    int hangikitabkonulari;
    ListView ListView;
    ArrayList<String> diclist = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_konular);


        sharedPreferences = getSharedPreferences("MofidxBooksReader",0);
//        sharedPreferences = getSharedPreferences("readed",0);


        ListView = findViewById(R.id.list_view);
        hangikitabkonulari= getIntent().getIntExtra("openbook",-1);






        if(hangikitabkonulari==0){
            diclist.add(getString(R.string.konu11));
            diclist.add(getString(R.string.konu12));
            diclist.add(getString(R.string.konu13));
            diclist.add(getString(R.string.konu14));
            diclist.add(getString(R.string.konu15));
            diclist.add(getString(R.string.konu16));
            diclist.add(getString(R.string.konu17));
            diclist.add(getString(R.string.konu18));
            diclist.add(getString(R.string.konu19));
            diclist.add(getString(R.string.konu110));
            diclist.add(getString(R.string.konu111));
            diclist.add(getString(R.string.konu112));
            diclist.add(getString(R.string.konu113));
            diclist.add(getString(R.string.konu114));
            diclist.add(getString(R.string.konu115));
            diclist.add(getString(R.string.konu116));
            diclist.add(getString(R.string.konu117));


        }

        if (hangikitabkonulari==1){
            diclist.add(getString(R.string.konu21));
            diclist.add(getString(R.string.konu22));
            diclist.add(getString(R.string.konu23));
            diclist.add(getString(R.string.konu24));
            diclist.add(getString(R.string.konu25));
            diclist.add(getString(R.string.konu26));
            diclist.add(getString(R.string.konu27));
            diclist.add(getString(R.string.konu28));
            diclist.add(getString(R.string.konu29));
            diclist.add(getString(R.string.konu210));
            diclist.add(getString(R.string.konu211));
            diclist.add(getString(R.string.konu212));
            diclist.add(getString(R.string.konu213));
            diclist.add(getString(R.string.konu214));
            diclist.add(getString(R.string.konu215));
            diclist.add(getString(R.string.konu216));
            diclist.add(getString(R.string.konu217));
            diclist.add(getString(R.string.konu218));
            diclist.add(getString(R.string.konu219));
            diclist.add(getString(R.string.konu220));
            diclist.add(getString(R.string.konu221));
            diclist.add(getString(R.string.konu222));
            diclist.add(getString(R.string.konu223));
            diclist.add(getString(R.string.konu224));

        }
        if (hangikitabkonulari==2){
            diclist.add(getString(R.string.konu31));
            diclist.add(getString(R.string.konu32));
            diclist.add(getString(R.string.konu33));
            diclist.add(getString(R.string.konu34));
            diclist.add(getString(R.string.konu35));
            diclist.add(getString(R.string.konu36));
            diclist.add(getString(R.string.konu37));
            diclist.add(getString(R.string.konu38));
            diclist.add(getString(R.string.konu39));
            diclist.add(getString(R.string.konu310));
            diclist.add(getString(R.string.konu311));
            diclist.add(getString(R.string.konu312));
        }

        if (hangikitabkonulari==3){
            diclist.add(getString(R.string.konu40));
            diclist.add(getString(R.string.konu41));
            diclist.add(getString(R.string.konu42));
            diclist.add(getString(R.string.konu44));
            diclist.add(getString(R.string.konu45));
            diclist.add(getString(R.string.konu46));
            diclist.add(getString(R.string.konu47));
            diclist.add(getString(R.string.konu48));
            diclist.add(getString(R.string.konu49));
            diclist.add(getString(R.string.konu410));
            diclist.add(getString(R.string.konu411_1));
            diclist.add(getString(R.string.konu412));
            diclist.add(getString(R.string.konu413));
            diclist.add(getString(R.string.konu414));
            diclist.add(getString(R.string.konu415));
            diclist.add(getString(R.string.konu416));
            diclist.add(getString(R.string.konu417));
            diclist.add(getString(R.string.konu418));
        }
        if (hangikitabkonulari==4){

            diclist.add(getString(R.string.konu51));
            diclist.add(getString(R.string.konu52));
            diclist.add(getString(R.string.konu53));
            diclist.add(getString(R.string.konu54));
            diclist.add(getString(R.string.konu55));
            diclist.add(getString(R.string.konu56));
            diclist.add(getString(R.string.konu57));
            diclist.add(getString(R.string.konu58));
            diclist.add(getString(R.string.konu59));
            diclist.add(getString(R.string.konu510));
            diclist.add(getString(R.string.konu511));
            diclist.add(getString(R.string.konu512));
        }




        myListviewAdaptor = new MyListviewAdaptor(this, sharedPreferences, diclist , hangikitabkonulari);
        ListView.setAdapter(myListviewAdaptor);




        ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (hangikitabkonulari==0){
                    editor = sharedPreferences.edit();
                    editor.putInt(posi1_readed[position], position);
                    editor.commit();
                    Intent intent1 = new Intent(RecyclerviewKonular.this, PdfReader.class);
                    intent1.putExtra("posi_key1", position);
                    startActivity(intent1);
                }

                if (hangikitabkonulari==1){
                    editor = sharedPreferences.edit();
                    editor.putInt(posi2_readed[position], position);
                    editor.commit();
                    Intent intent1 = new Intent(RecyclerviewKonular.this, PdfReader.class);
                    intent1.putExtra("posi_key2", position);
                    startActivity(intent1);
                }
                if (hangikitabkonulari==2){
                    editor = sharedPreferences.edit();
                    editor.putInt(posi3_readed[position], position);
                    editor.commit();
                    Intent intent1 = new Intent(RecyclerviewKonular.this, PdfReader.class);
                    intent1.putExtra("posi_key3", position);
                    startActivity(intent1);
                }
                if (hangikitabkonulari==3){
                    editor = sharedPreferences.edit();
                    editor.putInt(posi4_readed[position], position);
                    editor.commit();
                    Intent intent1 = new Intent(RecyclerviewKonular.this, PdfReader.class);
                    intent1.putExtra("posi_key4", position);
                    startActivity(intent1);
                }
                if (hangikitabkonulari==4){
                    editor = sharedPreferences.edit();
                    editor.putInt(posi5_readed[position], position);
                    editor.commit();
                    Intent intent1 = new Intent(RecyclerviewKonular.this, PdfReader.class);
                    intent1.putExtra("posi_key5", position);
                    startActivity(intent1);
                }



            }
        });

        ListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                showAlertDialog(R.layout.dialog_postive_layout_reded,position);

                return true;
            }
        });





//on Create
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_editor.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.menu_readed, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        if (item.getItemId()==R.id.delete_all_data){
            editor = sharedPreferences.edit();
            if (hangikitabkonulari==0){

                for (int i =0; i<posi1_readed.length; i++){
                    editor.remove(posi1_readed[i]);
                }
            }
            if (hangikitabkonulari==1){
                for (int i =0; i<posi2_readed.length; i++){
                    editor.remove(posi2_readed[i]);
                }
            }
            if (hangikitabkonulari==2){
                for (int i =0; i<posi3_readed.length; i++){
                    editor.remove(posi3_readed[i]);
                }
            }
            if (hangikitabkonulari==3){
                for (int i =0; i<posi4_readed.length; i++){
                    editor.remove(posi4_readed[i]);
                }
            }
            if (hangikitabkonulari==4){
                for (int i =0; i<posi5_readed.length; i++){
                    editor.remove(posi5_readed[i]);
                }
            }
            editor.commit();
            myListviewAdaptor.notifyDataSetChanged();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



    private void showAlertDialog(int layout, int position){
        dialogBuilder = new AlertDialog.Builder(RecyclerviewKonular.this);
        View layoutView = getLayoutInflater().inflate(layout, null);
        Button dialogButton = layoutView.findViewById(R.id.btnDialog);
        Button dialogButton1 = layoutView.findViewById(R.id.btnDialog1);
        dialogBuilder.setView(layoutView);
        alertDialog  =  dialogBuilder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        alertDialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
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
                alertDialog.dismiss();
                editor=sharedPreferences.edit();
                if (hangikitabkonulari==0){
                    editor.remove(posi1_readed[position]);
                }
                if (hangikitabkonulari==1){
                    editor.remove(posi2_readed[position]);
                }
                if (hangikitabkonulari==2){
                    editor.remove(posi3_readed[position]);
                }
                if (hangikitabkonulari==3){
                    editor.remove(posi4_readed[position]);
                }
                if (hangikitabkonulari==4){
                    editor.remove(posi5_readed[position]);
                }
                editor.commit();
                myListviewAdaptor.notifyDataSetChanged();
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        myListviewAdaptor.notifyDataSetChanged();
    }



}