package louiz.com.leapic.fragment;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import louiz.com.leapic.R;
import louiz.com.leapic.activity.ExcersiceActivity;
import louiz.com.leapic.adapter.TopicAdapter;
import louiz.com.leapic.model.Topic;
import louiz.com.leapic.model.Word;

import static android.content.Context.MODE_PRIVATE;

public class Excersice1Fragment extends Fragment {


    String DATABASE_NAME="LeaPic.sqlite";
    String DB_PATH_SUFFIX = "/databases/";
    SQLiteDatabase database = null;
    private String categoryId;
    Button btnCheck;
    ImageView img1;
    TextView txtWord;
    ArrayList<Word> wordsList = new ArrayList<>();
    public Excersice1Fragment( ){

    };


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View PageTree = inflater.inflate(R.layout.fragment_excersice1_eng,container,false);

        return  PageTree;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ProcessCopyDatabase();
        img1 = view.findViewById(R.id.img1);
        txtWord = view.findViewById(R.id.txtWord);

        showAllNames();


    }



    private void showAllNames() {
        categoryId = getArguments().getString("categoryId");
        database = getContext().openOrCreateDatabase(DATABASE_NAME,MODE_PRIVATE,null);
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
        txtWord.findViewById(R.id.txtWord);
        if(categoryId==null){
            txtWord.setText("méo có");
        }
        txtWord.setText(categoryId);

        img1.findViewById(R.id.img1);

        cursor.close();





    }

    private void addEvent() {

    }



    private  void ProcessCopyDatabase(){
        File dbFile = getActivity().getDatabasePath(DATABASE_NAME);
        if(!dbFile.exists()){
            try {
                CopyDataBaseFromAsset();

            }catch (Exception ex){
                Toast.makeText(getContext(), ex.toString(),Toast.LENGTH_LONG).show();

            }
        }


    }

    private void CopyDataBaseFromAsset() {
        try{
            InputStream myInput = getContext().getAssets().open(DATABASE_NAME);
            String outFileName = GetPath();
            File f = new File(getContext().getApplicationInfo().dataDir+DB_PATH_SUFFIX);
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
        return getContext().getApplicationInfo().dataDir+DB_PATH_SUFFIX+DATABASE_NAME;

    }



}
