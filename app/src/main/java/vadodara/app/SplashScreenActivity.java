package vadodara.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;

public class SplashScreenActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();

        imageView = findViewById(R.id.splash_whatsapp);
        AlphaAnimation animation = new AlphaAnimation(0,1);
        animation.setDuration(1500);
        imageView.startAnimation(animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                new commenMethods(SplashScreenActivity.this,TabDemoActivity.class);
                finish();

            }
        },3000);
    }
}