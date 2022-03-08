package vadodara.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.ExpandedMenuView;

import android.os.Bundle;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;

public class ExpandDemoActivity extends AppCompatActivity {

    ExpandableListView expandableListView;
    String []technology = {"Android","Flutter","ios","React Native"};
    int[] imageArray = {R.drawable.android,R.drawable.flutter,R.drawable.ios,R.drawable.react_native};

    ArrayList<GroupList> arrayList;


    String[] androidArray = {"Intent","Activity","TabBar","ActionBar","SplashScreen"};
    String[] flutterArray = {"dart","UI/UX","fun","Easy"};
    String[] iosArray = {"Expensive","Strong Security","Unique"};
    String[] reactnativeArray = {"Noje js","Web Development","API","Java Script"};

    ArrayList<ChildList> childArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expand_demo);
        expandableListView = findViewById(R.id.expand_demo);

        arrayList = new ArrayList<>();
        for (int i=0; i<technology.length; i++){
            GroupList list = new GroupList();
            list.setName(technology[i]);
            list.setImage(imageArray[i]);


            if (i==0){
                childArrayList = new ArrayList<>();
                for (int j=0; j<androidArray.length; j++){
                    ChildList child = new ChildList();
                    child.setChildName(androidArray[j]);
                    childArrayList.add(child);
                }
                list.setChildArrayLists(childArrayList);
            }
            if (i==1){
                childArrayList = new ArrayList<>();
                for (int j=0; j< flutterArray.length; j++){
                    ChildList child = new ChildList();
                    child.setChildName(flutterArray[j]);
                    childArrayList.add(child);
                }
                list.setChildArrayLists(childArrayList);
            }
            if (i==2){
                childArrayList = new ArrayList<>();
                for (int j=0; j<iosArray.length; j++){
                    ChildList child = new ChildList();
                    child.setChildName(iosArray[j]);
                    childArrayList.add(child);
                }
                list.setChildArrayLists(childArrayList);
            }
            if (i==3){
                childArrayList = new ArrayList<>();
                for (int j=0; j<reactnativeArray.length; j++){
                    ChildList child = new ChildList();
                    child.setChildName(reactnativeArray[j]);
                    childArrayList.add(child);
                }
                list.setChildArrayLists(childArrayList);
            }
            arrayList.add(list);
        }
        ExpandAdapter adapter = new ExpandAdapter(ExpandDemoActivity.this,arrayList);
        expandableListView.setAdapter(adapter);


    }
}