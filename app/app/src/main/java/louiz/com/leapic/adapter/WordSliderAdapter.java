package louiz.com.leapic.adapter;

import android.content.Context;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import louiz.com.leapic.R;
import louiz.com.leapic.model.Word;


public class WordSliderAdapter extends PagerAdapter {

    private ArrayList<Word> wordList;
    private LayoutInflater inflater;
    private Context context;
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
    public Object instantiateItem(ViewGroup view, int position) {
        View imageLayout = inflater.inflate(R.layout.word_slider, view, false);
        assert imageLayout != null;
        final ImageView imageView =  imageLayout
                .findViewById(R.id.image);

        final TextView txtWord = imageLayout.findViewById(R.id.txtWord);
        txtWord.setText(wordList.get(position).getName());
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
