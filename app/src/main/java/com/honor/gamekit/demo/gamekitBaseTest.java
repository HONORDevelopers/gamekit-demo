package com.honor.gamekit.demo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hihonor.mcs.system.scheduling.Scheduling;
import com.hihonor.mcs.system.scheduling.Scheduling.SchedulingCallback;
import com.hihonor.mcs.system.game.GameManager;

public class gamekitBaseTest extends AppCompatActivity {
    private Button registerGameButton;

    private Button unregisterGameButton;

    private Button setSceneHintButton;

    private Button updateGameSettingButton;

    private Button setRemindTimeButton;

    private Button setTPHotCtrlAreaButton;

    private Button clrTPHotCtrlAreaButton;

    private Button updateGameStatusButton;

    private TextView textView;

    private Context myContext;


    private String TAG = "GAMEKIT_DEMO_SAXON";

    private GameManager gameManager = GameManager.getGameManager();
    Scheduling scheduling = new Scheduling();
    private int registerResult = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamekit_base_test);
        myContext = getApplicationContext();
        registerGameButton = findViewById(R.id.registerGame);
        unregisterGameButton = findViewById(R.id.unregisterGame);
        setSceneHintButton = findViewById(R.id.setScene);
        updateGameSettingButton = findViewById(R.id.updateGameSetting);
        setRemindTimeButton = findViewById(R.id.setRemindTime);
        setTPHotCtrlAreaButton = findViewById(R.id.setTPHotCtrlArea);
        clrTPHotCtrlAreaButton = findViewById(R.id.clrTPHotCtrlArea);
        updateGameStatusButton = findViewById(R.id.updateGameStatus);
        textView = (TextView)findViewById(R.id.textView);

        registerGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String majorVersion = "majorVersion1";
                String minVersion = "minVersion2";
                boolean isSuccess = gameManager.registerGame(majorVersion, minVersion);
                if (isSuccess) {
                    textView.setText("APP registration successful !");
                    Log.d(TAG, "registerGame success. majorVersion " + majorVersion);
                } else {
                    textView.setText("APP registration failed !");
                    Log.d(TAG, "registerGame failed. minVersion " + minVersion);
                }
                registerApp();
            };
        });

        unregisterGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameManager.unregisterGame();
                textView.setText("unregisterGame, send message {unregisterGame}");
            }
        });
        setSceneHintButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameManager.setSceneHint(31, 1, 0);
                textView.setText("setSceneHint, send message 31, 1, 0");
            }
        });

        updateGameSettingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle gameSettingInfo = new Bundle();
                gameSettingInfo.putInt("fps", 30);
                gameSettingInfo.putInt("resolution", 3);
                gameSettingInfo.putInt("picQuality", 3);
                gameSettingInfo.putInt("antiAliasing", 3);
                gameSettingInfo.putInt("shadow", 0);
                gameManager.updateGameSetting(gameSettingInfo);
                textView.setText("updateGameSetting, sendMessage is " + gameSettingInfo.toString());
            }
        });
        updateGameStatusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle updateGameStatusInfo = new Bundle();
                updateGameStatusInfo.putInt("playerCount", 10);
                updateGameStatusInfo.putInt("latency", 60);
                gameManager.updateGameStatus(updateGameStatusInfo);
                textView.setText("clearTPHotCtrlAreaButton, sendMessage is " + updateGameStatusInfo.toString());
            }
        });
        setRemindTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle gameSettingInfo = new Bundle();
                gameSettingInfo.putInt("reBirth", 10);
                gameSettingInfo.putInt("launch", 60);
                gameManager.setRemindTime(gameSettingInfo);
                textView.setText("setRemindTime, sendMessage is " + gameSettingInfo.toString());
            }
        });
        setTPHotCtrlAreaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameManager.setTPHotCtrlArea(1,110, 235, 50, 5);
                textView.setText("setTPHotCtrlArea, sendMessage is {1,3, 235, 3333,553234, 5}");
            }
        });
        clrTPHotCtrlAreaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameManager.clearTPHotCtrlArea(1);
                textView.setText("clearTPHotCtrlAreaButton, sendMessage is {1}");
            }
        });
    }

    private SchedulingCallback schedulingCallback = new SchedulingCallback()
    {
        @Override
        public void notifyRegisterResult(int res) {
            Log.d(TAG, "Resgister info = " + res);
        }
        @Override
        public void notifySceneResult(int res) {
            Log.d(TAG, "Scene info = " + res);
        }
        @Override
        public void notifyThreadResult(int res) {
            Log.d(TAG, "Thread info = " + res);
        }
    };

    public void registerApp() {
        registerResult = scheduling.registerApp(schedulingCallback);
        Log.i(TAG, "register： " + registerResult);
    }
}