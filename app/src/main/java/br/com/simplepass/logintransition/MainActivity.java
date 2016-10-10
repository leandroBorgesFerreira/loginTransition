package br.com.simplepass.logintransition;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button mLoginBtn;
    private Button mRegisterBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLoginBtn = (Button) findViewById(R.id.login_btn);
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                    ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(
                            MainActivity.this,
                            new Pair<>(findViewById(R.id.login_btn), "login_transition"));

                    startActivity(intent, activityOptions.toBundle());
                } else{
                    startActivity(intent);
                }
            }
        });

        mRegisterBtn = (Button) findViewById(R.id.register_btn);
        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                    ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(
                            MainActivity.this,
                            new Pair<>(findViewById(R.id.register_btn), "register_transition"));

                    startActivity(intent, activityOptions.toBundle());
                } else{
                    startActivity(intent);
                }
            }
        });

    }
}
