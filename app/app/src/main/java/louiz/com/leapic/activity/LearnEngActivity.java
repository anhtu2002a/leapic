package louiz.com.leapic.activity;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;
import com.geniusforapp.fancydialog.FancyAlertDialog;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Locale;

import louiz.com.leapic.R;
import louiz.com.leapic.adapter.WordSliderAdapter;
import louiz.com.leapic.model.Word;

public class LearnEngActivity extends AppCompatActivity {
    String DATABASE_NAME="LeaPic.sqlite";
    String DB_PATH_SUFFIX = "/databases/";
    SQLiteDatabase database = null;
    ArrayList<Word> wordsList = new ArrayList<>();
    ViewPager viewPager;
    PagerAdapter adapter;
    CardView btnCardEnd;
    Button btnEnd;
    RoundCornerProgressBar progress;
    private TextToSpeech toSpeech;
    int position;
    Intent intent;
    String categoryId;
    private  int result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_eng);
        getSupportActionBar().setElevation(0);
        ProcessCopyDatabase();
        addControl();
        importWordList();
        addEvent();

    }

    private void importWordList() {
        intent = getIntent();
        categoryId = intent.getStringExtra("categoryId");
        database = openOrCreateDatabase(DATABASE_NAME,MODE_PRIVATE,null);
        Cursor cursor = database.rawQuery("select * FROM Word where TopicId = "+categoryId+" and Learned = 0",null);
        wordsList.clear();
        while (cursor.moveToNext()){

            int idWord = cursor.getInt(0);
            String nameWord = cursor.getString(1);
            String spell = cursor.getString(3);
            String mean = cursor.getString(4);
            byte[] pic = cursor.getBlob(8);
            int learn = cursor.getInt(5);
            if(learn==0 && wordsList.size() < 5){
                Word word = new Word(idWord,nameWord,spell,mean,pic,learn);
                wordsList.add(word);
            }

        }
        cursor.close();
        adapter.notifyDataSetChanged();
    }

    private void addControl() {
        viewPager = findViewById(R.id.viewpager);
        adapter = new WordSliderAdapter(LearnEngActivity.this,wordsList,categoryId);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(position,true);
        progress = findViewById(R.id.progress_1);
        progress.setProgressColor(R.color.colorIcon);
        progress.setProgressBackgroundColor(R.color.colorTrans);
        progress.setMax(100);
        progress.setProgress(20);
        btnCardEnd = findViewById(R.id.btnCardEnd);
        btnEnd = findViewById(R.id.btnEnd);





    }

    private void addEvent() {

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {

                switch (i){
                    case 0:
                        progress.setProgress(20);
                        btnCardEnd.setVisibility(View.INVISIBLE);
                        break;
                    case 1:
                        progress.setProgress(40);
                        btnCardEnd.setVisibility(View.INVISIBLE);
                        break;
                    case 2:
                        progress.setProgress(60);
                        btnCardEnd.setVisibility(View.INVISIBLE);
                        break;
                    case 3:
                        progress.setProgress(80);
                        btnCardEnd.setVisibility(View.INVISIBLE);
                        break;
                    case 4:
                        progress.setProgress(100);
                        btnCardEnd.setVisibility(View.VISIBLE);
                        break;
                        default:
                            progress.setProgress(20);
                            btnCardEnd.setVisibility(View.INVISIBLE);
                            break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ExcersiceActivity.class);
                intent.putExtra("categoryId",categoryId);
                startActivity(intent);
            }
        });
    }

    private  void ProcessCopyDatabase(){
        File dbFile = getDatabasePath(DATABASE_NAME);
        if(!dbFile.exists()){
            try {
                CopyDataBaseFromAsset();

            }catch (Exception ex){
                Toast.makeText(getApplication(), ex.toString(),Toast.LENGTH_LONG).show();

            }
        }


    }

    private void CopyDataBaseFromAsset() {
        try{
            InputStream myInput = getAssets().open(DATABASE_NAME);
            String outFileName = GetPath();
            File f = new File(getApplicationInfo().dataDir+DB_PATH_SUFFIX);
            if(!f.exists()){
                f.mkdir();
            }
            OutputStream myOutput = new FileOutputStream(outFileName);

            byte[] buffer = new byte[1024];
            int lengt;
            while((lengt = myInput.read(buffer))>0){
                myOutput.write(buffer,0,lengt);
            }
            myOutput.flush();
            myOutput.close();
            myInput.close();

        }catch (Exception ex){
            Log.e("error_whilecopy",ex.toString());
        }
    }

    private String GetPath(){
        return getApplicationInfo().dataDir+DB_PATH_SUFFIX+DATABASE_NAME;

    }



}
