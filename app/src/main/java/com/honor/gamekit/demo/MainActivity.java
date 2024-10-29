package com.honor.gamekit.demo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hihonor.mcs.system.game.GameManager;

public class MainActivity extends AppCompatActivity {
    private Button baseTestButton;
    private TextView textView;
    private Context myContext;
    private String TAG = "GAMEKIT_DEMO_SAXON";
    private GameManager gameManager = GameManager.getGameManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myContext = getApplicationContext();
        baseTestButton = findViewById(R.id.baseTest);
        textView = (TextView)findViewById(R.id.textView);

        baseTestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, gamekitBaseTest.class);
                startActivity(intent);
            };
        });
    }
}