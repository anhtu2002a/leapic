package louiz.com.leapic;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView btnSpeech, btnListen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setElevation(0);

        btnSpeech = findViewById(R.id.btnSpeech);
        btnListen = findViewById(R.id.btnListen);

        btnSpeech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SpeechActivity.class);
                startActivity(intent);
            }
        });
        btnListen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HomeEngActivity.class);
                startActivity(intent);
            }
        });

        Animation();



    }

    private void Animation() {
        btnListen.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_UP:
                        btnListen.setImageResource(R.drawable.headphones1);
                        break;
                    case MotionEvent.ACTION_DOWN:
                        btnListen.setImageResource(R.drawable.headphones3);
                        break;
                }
                return false;
            }
        });
        btnSpeech.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_UP:
                        btnSpeech.setImageResource(R.drawable.microphone1);
                        break;
                    case MotionEvent.ACTION_DOWN:
                        btnSpeech.setImageResource(R.drawable.microphone3);
                        break;
                }
                return false;
            }
        });
    }
}