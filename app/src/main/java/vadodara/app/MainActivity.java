package vadodara.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button login;
    EditText email, password;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    String passwordPattern = "[a-zA-Z0-9\\\\!\\\\@\\\\#\\\\$]{8,24}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        login = findViewById(R.id.main_login);
        email = findViewById(R.id.main_email);
        password = findViewById(R.id.main_password);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!email.getText().toString().matches(emailPattern)){
                    new commenMethods(MainActivity.this, "Not Valid email");
                    email.setError("Enter Valid email");
                }else if(!password.getText().toString().matches(passwordPattern)){
                    password.setError("Enter Strong Password");
                }
                else if (email.getText().toString().equals("admin@gmail.com") && password.getText().toString().equalsIgnoreCase("Admin@123")){
                    new commenMethods(MainActivity.this, "Login sucessfull");
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("EMAIL",email.getText().toString());
                    bundle.putString("PASSWORD",password.getText().toString());
                    intent.putExtras(bundle);
                    startActivity(intent);
                }else {
                    new commenMethods(MainActivity.this, "Wrong id and Password");
                }
            }
        });

    }
}