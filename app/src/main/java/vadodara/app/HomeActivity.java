package vadodara.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    TextView emailed, password;
    RadioGroup gender;
    CheckBox androidcheck, ios, html, flutter, net;
    Button show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().setTitle("Home");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getExtras();
        String sEmail = bundle.getString("EMAIL");
        String sPassword = bundle.getString("PASSWORD");


        emailed = findViewById(R.id.home_email);
        password = findViewById(R.id.home_password);
        gender = findViewById(R.id.home_gender);

        emailed.setText(sEmail);
        password.setText(sPassword);

        androidcheck = findViewById(R.id.home_android);
        ios = findViewById(R.id.home_ios);
        flutter = findViewById(R.id.home_flutter);
        html = findViewById(R.id.home_html);
        net = findViewById(R.id.home_net);

        show = findViewById(R.id.home_show);



    show.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            StringBuilder sb = new StringBuilder();
            if (androidcheck.isChecked()) {
                sb.append(androidcheck.getText().toString() + "\n");
            }
            if (ios.isChecked()) {
                sb.append(ios.getText().toString() + "\n");
            }
            if (flutter.isChecked()) {
                sb.append(flutter.getText().toString() + "\n");
            }
            if (html.isChecked()) {
                sb.append(html.getText().toString() + "\n");
            }
            if (net.isChecked()) {
                sb.append(net.getText().toString() + "\n");
            }
            if(sb.toString().trim().equalsIgnoreCase("")){

            }
            else {
                new commenMethods(HomeActivity.this, sb.toString());
            }
        }
    });


        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                new commenMethods(HomeActivity.this,radioButton.getText().toString());
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id==android.R.id.home){
           onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        alertMethod();
    }

    private void alertMethod() {

        AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
        builder.setIcon(R.mipmap.ic_launcher_round);
        builder.setTitle("Exit Alert!");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishAffinity();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setNeutralButton("Ret us", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new commenMethods(HomeActivity.this, "Rate us");
            }
        });
        builder.setMessage("Are you sure want to exit!");
        builder.show();

    }
}