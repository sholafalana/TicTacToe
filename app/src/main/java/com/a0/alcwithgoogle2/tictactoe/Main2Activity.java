package com.a0.alcwithgoogle2.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    //  Intent method
    public void playbutton (View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);


    }
    //  Intent method
    public void playbutton2 (View view) {
        Intent intent = new Intent(getApplicationContext(), Main4Activity.class);
        startActivity(intent);


    }
    //  Intent method
    public void about (View view) {
        Intent intent = new Intent(getApplicationContext(), Main3Activity.class);
        startActivity(intent);


    }


}
