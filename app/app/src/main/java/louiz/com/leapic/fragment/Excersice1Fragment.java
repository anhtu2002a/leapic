package louiz.com.leapic.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.geniusforapp.fancydialog.FancyAlertDialog;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Random;

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
    CardView card1,card2,card3,card4;
    ImageView img1,img2,img3,img4;
    TextView txt1,txt2,txt3,txt4,hint1,hint2,hint3,hint4,txtQues;
    ArrayList<Word> wordsList = new ArrayList<>();
    ArrayList<Word> ran_exWord;
    Word check1;
    int check2;
    int count = 0;
    int clicked = 0;
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
        img2 = view.findViewById(R.id.img2);
        img3 = view.findViewById(R.id.img3);
        img4 = view.findViewById(R.id.img4);
        txt1 = view.findViewById(R.id.txt1);
        txt2 = view.findViewById(R.id.txt2);
        txt3 = view.findViewById(R.id.txt3);
        txt4 = view.findViewById(R.id.txt4);
        hint1 = view.findViewById(R.id.hint1);
        hint2 = view.findViewById(R.id.hint2);
        hint3 = view.findViewById(R.id.hint3);
        hint4 = view.findViewById(R.id.hint4);
        card1 = view.findViewById(R.id.card1);
        card2 = view.findViewById(R.id.card2);
        card3 = view.findViewById(R.id.card3);
        card4 = view.findViewById(R.id.card4);
        txtQues = view.findViewById(R.id.txtQues);
        btnCheck = view.findViewById(R.id.btnCheck);
        showAllNames();
        addEvent();
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
            if(learn==0 ){
                Word word = new Word(idWord,nameWord,spell,mean,pic,learn);
                wordsList.add(word);
            }


        }
        Random r = new Random();
        ArrayList<Word> exWord = new ArrayList<>();
        exWord.add(wordsList.get(count));
        check1 = wordsList.get(count);
        wordsList.remove(wordsList.get(count));
        for(int i = 0;i<3;i++){
            int x = r.nextInt(wordsList.size());
            exWord.add(wordsList.get(x));
            wordsList.remove(x);
        }
        ran_exWord = new ArrayList<>();
        for(int i = 0;i<exWord.size();i+=0){
            int x = r.nextInt(exWord.size());
            ran_exWord.add(exWord.get(x));
            exWord.remove(x);
        }


        txt1.setText(ran_exWord.get(0).getName());
        txt2.setText(ran_exWord.get(1).getName());
        txt3.setText(ran_exWord.get(2).getName());
        txt4.setText(ran_exWord.get(3).getName());
        hint1.setText(ran_exWord.get(0).getId()+"");
        hint2.setText(ran_exWord.get(1).getId()+"");
        hint3.setText(ran_exWord.get(2).getId()+"");
        hint4.setText(ran_exWord.get(3).getId()+"");
        img1.setImageBitmap(decodeDB(0));
        img2.setImageBitmap(decodeDB(1));
        img3.setImageBitmap(decodeDB(2));
        img4.setImageBitmap(decodeDB(3));
        txtQues.setText(check1.getExMean()+" trong tiếng Anh là ?");
        cursor.close();





    }

    private Bitmap decodeDB(int i) {
        byte[] imgWord = ran_exWord.get(i).getPic();
        if(imgWord!=null){
            Bitmap bitmap = BitmapFactory.decodeByteArray(imgWord,0,imgWord.length);
            if(bitmap!=null)
                return bitmap;
        }
        return null;
    }

    private void addEvent() {
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cardClick(card1,hint1);

            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardClick(card2,hint2);
            }
        });
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardClick(card3,hint3);
            }
        });
        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardClick(card4,hint4);
            }
        });
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count==4){
                    if(check1.getId()==check2)
                    {
                        FancyAlertDialog.Builder alert = new FancyAlertDialog.Builder(getContext())
                                .setimageResource(R.drawable.done)
                                .setTextTitle("Chính Xác!")
                                .setTextSubTitle("Cùng Đến Từ Tiếp Theo Nào!")
                                .setBody("")
                                .setPositiveButtonText("Tiếp Tục")
                                .setPositiveColor(R.color.colorPositive)
                                .setOnPositiveClicked(new FancyAlertDialog.OnPositiveClicked() {
                                    @Override
                                    public void OnClick(View view, Dialog dialog) {
                                        Intent intent = new Intent(getContext(),ExcersiceActivity.class);
                                        intent.putExtra("categoryId",categoryId);
                                        intent.putExtra("page",1);
                                        getContext().startActivity(intent);
                                    }
                                })
                                .setBodyGravity(FancyAlertDialog.TextGravity.CENTER)
                                .setTitleGravity(FancyAlertDialog.TextGravity.CENTER)
                                .setSubtitleGravity(FancyAlertDialog.TextGravity.CENTER)
                                .setButtonsGravity(FancyAlertDialog.PanelGravity.CENTER)
                                .setCancelable(false)
                                .build();
                        alert.show();
                    }
                    else {
                        FancyAlertDialog.Builder alert = new FancyAlertDialog.Builder(getContext())
                                .setimageResource(R.drawable.wrong)
                                .setTextTitle("Không Chính Xác!")
                                .setTextSubTitle("Cùng Chọn Lại Xem!")
                                .setBody("")
                                .setPositiveButtonText("Chọn Lại")
                                .setPositiveColor(R.color.colorNegative)
                                .setOnPositiveClicked(new FancyAlertDialog.OnPositiveClicked() {
                                    @Override
                                    public void OnClick(View view, Dialog dialog) {
                                        resetCard();
                                        dialog.dismiss();
                                    }
                                })
                                .setBodyGravity(FancyAlertDialog.TextGravity.CENTER)
                                .setTitleGravity(FancyAlertDialog.TextGravity.CENTER)
                                .setSubtitleGravity(FancyAlertDialog.TextGravity.CENTER)
                                .setButtonsGravity(FancyAlertDialog.PanelGravity.CENTER)
                                .setCancelable(false)
                                .build();
                        alert.show();
                    }
                }else {
                    if(check1.getId()==check2)
                    {
                        FancyAlertDialog.Builder alert = new FancyAlertDialog.Builder(getContext())
                                .setimageResource(R.drawable.done)
                                .setTextTitle("Chính Xác!")
                                .setTextSubTitle("Cùng Đến Từ Tiếp Theo Nào!")
                                .setBody("")
                                .setPositiveButtonText("Tiếp Tục")
                                .setPositiveColor(R.color.colorPositive)
                                .setOnPositiveClicked(new FancyAlertDialog.OnPositiveClicked() {
                                    @Override
                                    public void OnClick(View view, Dialog dialog) {
                                        count++;
                                        resetCard();
                                        updateWord();
                                    }
                                })
                                .setBodyGravity(FancyAlertDialog.TextGravity.CENTER)
                                .setTitleGravity(FancyAlertDialog.TextGravity.CENTER)
                                .setSubtitleGravity(FancyAlertDialog.TextGravity.CENTER)
                                .setButtonsGravity(FancyAlertDialog.PanelGravity.CENTER)
                                .setCancelable(false)
                                .build();
                        alert.show();
                    }
                    else {
                        FancyAlertDialog.Builder alert = new FancyAlertDialog.Builder(getContext())
                                .setimageResource(R.drawable.wrong)
                                .setTextTitle("Không Chính Xác!")
                                .setTextSubTitle("Cùng Chọn Lại Xem!")
                                .setBody("")
                                .setPositiveButtonText("Chọn Lại")
                                .setPositiveColor(R.color.colorNegative)
                                .setOnPositiveClicked(new FancyAlertDialog.OnPositiveClicked() {
                                    @Override
                                    public void OnClick(View view, Dialog dialog) {
                                        resetCard();
                                        dialog.dismiss();
                                    }
                                })
                                .setBodyGravity(FancyAlertDialog.TextGravity.CENTER)
                                .setTitleGravity(FancyAlertDialog.TextGravity.CENTER)
                                .setSubtitleGravity(FancyAlertDialog.TextGravity.CENTER)
                                .setButtonsGravity(FancyAlertDialog.PanelGravity.CENTER)
                                .setCancelable(false)
                                .build();
                        alert.show();
                    }
                }

            }
        });

    }

    private void updateWord() {

        Cursor cursor = database.rawQuery("select * FROM Word where TopicId = "+categoryId+" and Learned = 0",null);
        wordsList.clear();
        while (cursor.moveToNext()){
            int idWord = cursor.getInt(0);
            String nameWord = cursor.getString(1);
            String spell = cursor.getString(3);
            String mean = cursor.getString(4);
            byte[] pic = cursor.getBlob(8);
            int learn = cursor.getInt(5);
            if(learn==0 ){
                Word word = new Word(idWord,nameWord,spell,mean,pic,learn);
                wordsList.add(word);
            }


        }
        Random r = new Random();
        ArrayList<Word> exWord = new ArrayList<>();
        exWord.add(wordsList.get(count));
        check1 = wordsList.get(count);
        wordsList.remove(wordsList.get(count));
        for(int i = 0;i<3;i++){
            int x = r.nextInt(wordsList.size());
            exWord.add(wordsList.get(x));
            wordsList.remove(x);
        }
        ran_exWord = new ArrayList<>();
        for(int i = 0;i<exWord.size();i+=0){
            int x = r.nextInt(exWord.size());
            ran_exWord.add(exWord.get(x));
            exWord.remove(x);
        }
        txt1.setText(ran_exWord.get(0).getName());
        txt2.setText(ran_exWord.get(1).getName());
        txt3.setText(ran_exWord.get(2).getName());
        txt4.setText(ran_exWord.get(3).getName());
        hint1.setText(ran_exWord.get(0).getId()+"");
        hint2.setText(ran_exWord.get(1).getId()+"");
        hint3.setText(ran_exWord.get(2).getId()+"");
        hint4.setText(ran_exWord.get(3).getId()+"");
        img1.setImageBitmap(decodeDB(0));
        img2.setImageBitmap(decodeDB(1));
        img3.setImageBitmap(decodeDB(2));
        img4.setImageBitmap(decodeDB(3));
        txtQues.setText(check1.getExMean()+" trong tiếng Anh là ?");
        cursor.close();
    }

    private void cardClick(CardView card, TextView hint) {
        resetCard();
        card.setCardElevation(0);
        card.setBackgroundColor(getResources().getColor(R.color.colorPicker));
        check2 = Integer.parseInt(hint.getText().toString());

    }

    private void resetCard() {
        card1.setCardElevation(10);
        card2.setCardElevation(10);
        card3.setCardElevation(10);
        card4.setCardElevation(10);
        card1.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        card2.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        card3.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        card4.setBackgroundColor(getResources().getColor(R.color.colorWhite));
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
