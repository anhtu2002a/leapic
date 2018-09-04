package louiz.com.leapic.activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import louiz.com.leapic.R;
import louiz.com.leapic.adapter.TopicAdapter;
import louiz.com.leapic.model.Topic;

public class TestActivity extends Activity {

    String DATABASE_NAME="LeaPic.sqlite";
    String DB_PATH_SUFFIX = "/databases/";
    SQLiteDatabase database = null;

    GridView gridView;
    ArrayList<Topic> topics;
    TopicAdapter adapter = null;


    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ProcessCopyDatabase();
        addControl();
        addEvent();
        showAllNames();
    }

    private void showAllNames() {

        database = openOrCreateDatabase(DATABASE_NAME,MODE_PRIVATE,null);
        Cursor cursor = database.rawQuery("select * FROM Topic",null);
        topics.clear();
        while (cursor.moveToNext()){

            int idTopic = cursor.getInt(0);
            String nameTopic = cursor.getString(1);
            int idType = cursor.getInt(2);
            byte[] imgTopic = cursor.getBlob(3);

            Topic topic = new Topic(idTopic,idType,nameTopic,imgTopic);
            topics.add(topic);
        }
        cursor.close();
        adapter.notifyDataSetChanged();


    }

    private void addEvent() {
    }

    private void addControl() {
        gridView = findViewById(R.id.gridTest);
        topics = new ArrayList<>();
        adapter = new TopicAdapter(this,R.layout.topic_items,topics);
        gridView.setAdapter(adapter);

    }

    private  void ProcessCopyDatabase(){
        File dbFile = getDatabasePath(DATABASE_NAME);
        if(!dbFile.exists()){
            try {
                CopyDataBaseFromAsset();

            }catch (Exception ex){
                Toast.makeText(this, ex.toString(),Toast.LENGTH_LONG).show();

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
