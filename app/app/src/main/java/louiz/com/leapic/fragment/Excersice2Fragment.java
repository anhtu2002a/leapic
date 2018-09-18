package louiz.com.leapic.fragment;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import louiz.com.leapic.R;
import louiz.com.leapic.adapter.TopicAdapter;
import louiz.com.leapic.model.Topic;

import static android.content.Context.MODE_PRIVATE;

public class Excersice2Fragment extends Fragment {


    String DATABASE_NAME="LeaPic.sqlite";
    String DB_PATH_SUFFIX = "/databases/";
    SQLiteDatabase database = null;


    public Excersice2Fragment(){

    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View PageTree = inflater.inflate(R.layout.fragment_excersice2_eng,container,false);

        return  PageTree;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ProcessCopyDatabase();


    }
    private void showAllNames() {

        database = getContext().openOrCreateDatabase(DATABASE_NAME,MODE_PRIVATE,null);
        Cursor cursor = database.rawQuery("select * FROM Topic",null);



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
