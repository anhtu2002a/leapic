package louiz.com.leapic.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import louiz.com.leapic.R;

public class SettingEngFragment extends Fragment {

    public SettingEngFragment(){

    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View PageTree = inflater.inflate(R.layout.fragment_setting_eng,container,false);
        return  PageTree;

    }
}
