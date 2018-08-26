package louiz.com.leapic.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import louiz.com.leapic.Fragment.GameEngFragment;
import louiz.com.leapic.Fragment.LearnEngFragment;
import louiz.com.leapic.Fragment.SettingEngFragment;

public class FragmentAdaper  extends FragmentPagerAdapter{

    private Context mContext;

    public FragmentAdaper(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Học";
            case 1:
                return "Game";
            case 2:
                return "Cài Đặt";

            default:
                return null;
        }
    }

    // This determines the fragment for each tab
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new LearnEngFragment();
        } else if (position == 1){
            return new GameEngFragment();
        } else{
            return new SettingEngFragment();

    }

    // This determines the number of tabs

    // This determines the title for each tab





    }
}


