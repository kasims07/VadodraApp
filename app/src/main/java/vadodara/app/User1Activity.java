package vadodara.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class User1Activity extends AppCompatActivity {

    TextView textView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user1);

        getSupportActionBar().hide();

        imageView = findViewById(R.id.custom_chate_image);
        textView = findViewById(R.id.text_user);

        Bundle bundle = getIntent().getExtras();
        String uName = bundle.getString("name");
        int uImage = bundle.getInt("image");

        imageView.setImageResource(uImage);
        textView.setText(uName);


    }
}