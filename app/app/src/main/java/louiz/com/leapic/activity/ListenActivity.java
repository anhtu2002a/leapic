package louiz.com.leapic.activity;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Locale;

import louiz.com.leapic.R;

public class ListenActivity extends AppCompatActivity {
    String txtCheck;
    TextToSpeech toSpeech;
    EditText editText;
    ImageView img;
    ImageView btnListen;
    String text;
    Button btnCheck;
    int result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listen);
        editText= findViewById(R.id.editText);
        btnListen=findViewById(R.id.btnListen);
        img = findViewById(R.id.img);
        text = "Hello";
        getSupportActionBar().setElevation(0);
        toSpeech=new TextToSpeech(ListenActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status==TextToSpeech.SUCCESS)
                {
                    result=toSpeech.setLanguage(Locale.US);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Feature not supported in your device",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnListen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED)
                {
                    Toast.makeText(getApplicationContext(),"Feature not supported in your device", Toast.LENGTH_SHORT).show();
                }
                else
                {

                    toSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null);
                }
            }
        });

        btnCheck = findViewById(R.id.btnCheck);
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtCheck = editText.getText().toString();
                if(txtCheck.equalsIgnoreCase(text)){
                    img.setImageResource(R.drawable.right);
                    editText.setText(txtCheck);
                }
                else {
                    img.setImageResource(R.drawable.wrong);
                    editText.setText(txtCheck);
                }
            }
        });


    }
}
