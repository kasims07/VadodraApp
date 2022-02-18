package vadodara.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class SpinnerListActivity extends AppCompatActivity {

    Spinner spinner;
    String []technology = {"Android","Flutter","ios","php",".net","HTML","Java","NodeJs"};
    ListView listView;
    //AutoCompleteTextView autoCompleteTextView;
    EditText message;
    ArrayList<String> arrayList;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        arrayList = new ArrayList<>();
        for(int i=0; i<technology.length; i++){
            arrayList.add(technology[i]);
        }
        listView = findViewById(R.id.spinner_gridview);
        ArrayAdapter gridadapter = new ArrayAdapter(SpinnerListActivity.this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(gridadapter);

        button = findViewById(R.id.spinner_button);
        message = findViewById(R.id.spinner_autocomplet);

        spinner = findViewById(R.id.spinner);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList.add(message.getText().toString());
                gridadapter.notifyDataSetChanged();
                message.setText("");
            }
        });

        ArrayAdapter adapter = new ArrayAdapter(SpinnerListActivity.this, android.R.layout.simple_list_item_1, arrayList);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_checked);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                new commenMethods(SpinnerListActivity.this,technology[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });







        /*autoCompleteTextView = findViewById(R.id.spinner_autocomplet);
        ArrayAdapter autoadapter = new ArrayAdapter(SpinnerListActivity.this, android.R.layout.simple_list_item_1, arrayList);
        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setAdapter(autoadapter);*/




    }
}