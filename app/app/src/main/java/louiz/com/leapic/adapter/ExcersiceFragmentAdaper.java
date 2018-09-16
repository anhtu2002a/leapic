package louiz.com.leapic.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import louiz.com.leapic.fragment.Excersice1Fragment;
import louiz.com.leapic.fragment.Excersice2Fragment;

public class ExcersiceFragmentAdaper extends FragmentPagerAdapter{

    private Context mContext;
    private String categoryId;
    public ExcersiceFragmentAdaper(Context context, FragmentManager fm, String categoryId) {
        super(fm);

        mContext = context;
        this.categoryId = categoryId;

    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Ex1";
            case 1:
                return "Ex1";


            default:
                return null;
        }
    }

    // This determines the fragment for each tab
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            Excersice1Fragment ex1 = new Excersice1Fragment();
            Bundle bundle = new Bundle();
            bundle.putString("categoryId",categoryId);
            ex1.setArguments(bundle);
            return ex1;


        } else{
            Excersice1Fragment ex2 = new Excersice1Fragment();
            Bundle data = new Bundle();//Use bundle to pass data
            data.putString("categoryId", categoryId);//put string, int, etc in bundle with a key value
            ex2.setArguments(data);
            return ex2;

    }


    // This determines the number of tabs

    // This determines the title for each tab





    }


}


