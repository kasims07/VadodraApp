package vadodara.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class DpActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dp);

        getSupportActionBar().hide();

        imageView = findViewById(R.id.custom_dp_image_activity);

        Bundle bundle = getIntent().getExtras();
        int uImage = bundle.getInt("uImage");

        imageView.setImageResource(uImage);
    }
}