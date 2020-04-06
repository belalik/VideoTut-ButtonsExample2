package com.example.android.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    Button button1;
    Button button2;
    Button button3;
    Button button4;

    TextView textView;

    ConstraintLayout mainLayout;

    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = findViewById(R.id.main_layout);

        editText = findViewById(R.id.editText);

        button1 = findViewById(R.id.button1);
        button1.setText("SPECIAL");

        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);

        textView = findViewById(R.id.textview1);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        mainLayout.setBackgroundColor(getRandomColor());
        textView.setTextSize(getRandomTextSize());

        Log.i(TAG, "to id toy view einai: "+v.getId());

        switch (v.getId()) {

            case R.id.button1:
                Toast.makeText(this, "special button clicked", Toast.LENGTH_SHORT).show();
                String specialText = editText.getText().toString();
                textView.setText(specialText);
                break;
            case R.id.button2:
                Toast.makeText(this, "button 2 clicked", Toast.LENGTH_SHORT).show();
                textView.setText("button 2");
                break;
            case R.id.button3:
                Toast.makeText(this, "button 3 clicked", Toast.LENGTH_SHORT).show();
                textView.setText("button 3");
                break;
            case R.id.button4:
                Toast.makeText(this, "button 4 clicked", Toast.LENGTH_SHORT).show();
                textView.setText("button 4");
                break;
        }

    }

    private int getRandomColor() {
        Random rnd = new Random();
        int red = rnd.nextInt(255);
        int green = rnd.nextInt(255);
        int blue = rnd.nextInt(255);

        int color = Color.argb(255, red, green, blue);

        return color;
    }

    /**
     * Method which returns a random number between 15 and 30.
     * @return int - size of text
     */
    private int getRandomTextSize() {
        int textSize = ThreadLocalRandom.current().nextInt(15, 30);
        return textSize;
    }
}
