package louiz.com.leapic.activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

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
    int position;
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
        Intent intent = getIntent();
        final String categoryId = intent.getStringExtra("categoryId");
        database = openOrCreateDatabase(DATABASE_NAME,MODE_PRIVATE,null);
        Cursor cursor = database.rawQuery("select * FROM Word where TopicId = "+categoryId,null);
        wordsList.clear();
        while (cursor.moveToNext()){
            int idWord = cursor.getInt(0);
            String nameWord = cursor.getString(1);
            String spell = cursor.getString(3);
            String mean = cursor.getString(4);
            byte[] pic = cursor.getBlob(8);
            Word word = new Word(idWord,nameWord,spell,mean,pic);
            wordsList.add(word);
        }
        cursor.close();
        adapter.notifyDataSetChanged();
    }

    private void addControl() {
        viewPager = findViewById(R.id.viewpager);
        adapter = new WordSliderAdapter(LearnEngActivity.this,wordsList);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(position,true);
     

    }

    private void addEvent() {
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
