package louiz.com.leapic;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

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
                    }
                    else {
                        img.setImageResource(R.drawable.wrong);
                    }

                    editText.setText(matches.get(0));
                }
                else {
                    editText.setText("Vui lòng thử lại");
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
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_UP:
                        speechRecognizer.startListening(speechIntent);
                        editText.setText("Nói Hello nào :D");
                    break;
                    case MotionEvent.ACTION_DOWN:
                        editText.setText("");
                        editText.setText("Listening...");
                        speechRecognizer.startListening(speechIntent);
                    break;
                }
                return false;
            }
        });
    }
    private void checkPermission(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if(!(ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED)){
                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.parse("package:"+getPackageName()));
                startActivity(intent);
                finish();
            }
        }
    }


}
