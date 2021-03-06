package louiz.com.leapic.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import louiz.com.leapic.R;

public class SpeechActivity extends AppCompatActivity {

    TextView editText;
    ImageView button;
    SpeechRecognizer speechRecognizer;
    Intent speechIntent;
    ImageView img;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech);
        checkPermission();
        getSupportActionBar().setElevation(0);
        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
        img = findViewById(R.id.img);
        speechIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        speechIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_PREFERENCE,
                "en");
        speechIntent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,
                getApplication().getPackageName());
        speechIntent.putExtra(RecognizerIntent.EXTRA_ONLY_RETURN_LANGUAGE_PREFERENCE,"en");
        speechIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_WEB_SEARCH);
        speechIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "en");
        speechIntent.putExtra(RecognizerIntent.EXTRA_ONLY_RETURN_LANGUAGE_PREFERENCE,"en");
        speechRecognizer.setRecognitionListener(new RecognitionListener() {
            @Override
            public void onReadyForSpeech(Bundle bundle) {

            }

            @Override
            public void onBeginningOfSpeech() {

            }

            @Override
            public void onRmsChanged(float v) {

            }

            @Override
            public void onBufferReceived(byte[] bytes) {

            }

            @Override
            public void onEndOfSpeech() {

            }

            @Override
            public void onError(int i) {

            }

            @Override
            public void onResults(Bundle bundle) {
                ArrayList<String> matches = bundle.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
                if(matches!=null){
                    if(matches.get(0).equalsIgnoreCase("hello")){
                        img.setImageResource(R.drawable.right);
                        button.setImageResource(R.drawable.microphone1);
                    }
                    else {
                        img.setImageResource(R.drawable.wrong);
                        button.setImageResource(R.drawable.microphone1);
                    }

                    editText.setText(matches.get(0));
                }
                else {
                    editText.setText("Vui lòng thử lại");
                    button.setImageResource(R.drawable.microphone1);
                }

            }

            @Override
            public void onPartialResults(Bundle bundle) {

            }

            @Override
            public void onEvent(int i, Bundle bundle) {

            }
        });

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {


                    case MotionEvent.ACTION_UP:
                        speechRecognizer.stopListening();
                        editText.setHint("Nói Hello nào :D");
                        button.setImageResource(R.drawable.microphone1);
                        break;
                    case MotionEvent.ACTION_DOWN:
                        editText.setText("");
                        editText.setText("Listening...");
                        speechRecognizer.startListening(speechIntent);
                        button.setImageResource(R.drawable.microphone2);
                        break;

                }
                return false;

            }
        });
    }

    private static final String[] RECORD_AUDIO = { Manifest.permission.RECORD_AUDIO};
    public void checkPermission()
    {
        int permission = ActivityCompat.checkSelfPermission(SpeechActivity.this, Manifest.permission.RECORD_AUDIO);
        if(permission != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(SpeechActivity.this,RECORD_AUDIO,1);
        }
    }


}
