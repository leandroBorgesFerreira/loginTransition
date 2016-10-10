package br.com.simplepass.logintransition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import static android.view.FrameMetrics.ANIMATION_DURATION;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        Button registerBackButton = (Button) findViewById(R.id.register_back);
        registerBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    public void insertForm(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View v = viewGroup.getChildAt(i);
            ViewPropertyAnimator animator = v.animate()
                    .scaleX(1)
                    .scaleY(1)
                    //.alpha(100)
                    .setDuration(450);

            animator.setStartDelay(300 + 100 * i);
            animator.start();
        }
    }


    public void onResume(){
        super.onResume();
        LinearLayout formView = (LinearLayout) findViewById(R.id.register_form);
        insertForm(formView);
    }
}
