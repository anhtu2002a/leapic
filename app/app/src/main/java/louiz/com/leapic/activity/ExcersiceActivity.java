package louiz.com.leapic.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import louiz.com.leapic.R;
import louiz.com.leapic.adapter.ExcersiceFragmentAdaper;
import louiz.com.leapic.adapter.HomeFragmentAdaper;
import louiz.com.leapic.customClass.CustomViewPager;
import louiz.com.leapic.model.Word;

public class ExcersiceActivity extends AppCompatActivity {
    CustomViewPager viewPager;
    ExcersiceFragmentAdaper adapter;
    String categoryId;
    int page;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excersice  );
        getSupportActionBar().setElevation(0);
        viewPager =  findViewById(R.id.viewpager);
        viewPager.setPagingEnabled(false);
        Intent intent = getIntent();
        categoryId = intent.getStringExtra("categoryId");
        page = intent.getIntExtra("page",0);
        adapter = new ExcersiceFragmentAdaper(this,getSupportFragmentManager(),categoryId,page);
        viewPager.setAdapter(adapter);

    }



}
