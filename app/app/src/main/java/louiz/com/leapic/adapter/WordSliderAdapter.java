package louiz.com.leapic.adapter;

import android.content.Context;
import android.graphics.Bitmap;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Parcelable;
import android.speech.tts.TextToSpeech;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

import louiz.com.leapic.R;
import louiz.com.leapic.activity.ListenActivity;
import louiz.com.leapic.model.Word;


public class WordSliderAdapter extends PagerAdapter {

    private ArrayList<Word> wordList;
    private LayoutInflater inflater;
    private Context context;
    private TextToSpeech toSpeech;
    private  int result;
    public WordSliderAdapter(Context context, ArrayList<Word> wordList) {
        this.context = context;
        this.wordList = wordList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }


    @Override
    public int getCount() {
        return wordList.size();
    }



    @Override
    public Object instantiateItem(ViewGroup view, final int position) {

        View imageLayout = inflater.inflate(R.layout.word_slider, view, false);

        assert imageLayout != null;
        final ImageView img =  imageLayout
                .findViewById(R.id.image);
        final TextView txtWord = imageLayout.findViewById(R.id.txtWord);
        final TextView txtSpell = imageLayout.findViewById(R.id.txtSpell);
        final TextView txtMean = imageLayout.findViewById(R.id.txtMean);
        final FloatingActionButton btnVoice = imageLayout.findViewById(R.id.btnVoice);
        txtWord.setText(wordList.get(position).getName());
        txtSpell.setText(wordList.get(position).getSpell());
        txtMean.setText(wordList.get(position).getExMean());
        toSpeech=new TextToSpeech(context, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status==TextToSpeech.SUCCESS)
                {
                    result=toSpeech.setLanguage(Locale.US);
                }
                else
                {
                    Toast.makeText(context,"Tính năng này không khả dụng trên thiết bị của bạn",Toast.LENGTH_SHORT).show();
                }
            }
        });


        btnVoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED)
                {
                    Toast.makeText(context,"Tính năng này không khả dụng trên thiết bị của bạn", Toast.LENGTH_SHORT).show();
                }
                else
                {

                    toSpeech.speak(wordList.get(position).getName(),TextToSpeech.QUEUE_FLUSH,null);
                }

            }
        });

        byte[] imgWord = wordList.get(position).getPic();
        if(imgWord!=null){
            Bitmap bitmap = BitmapFactory.decodeByteArray(imgWord,0,imgWord.length);
            if(bitmap!=null)
            img.setImageBitmap(bitmap);
        }
        view.addView(imageLayout, 0);


        return imageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }


    @Override
    public void restoreState(@Nullable Parcelable state, @Nullable ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }





}
