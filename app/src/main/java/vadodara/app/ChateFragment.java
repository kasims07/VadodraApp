package vadodara.app;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;


public class ChateFragment extends Fragment {

    String[] technologyArray = {"User 1","User 2","User 3","User 4","User 5","User 6","User 7","User 8","User 9"};
    String[] description = {"message 1","message 2","message 3","message 4","message 5","message 6","message 7","message 8","message 9"};
    int[] imageArray = {R.drawable.u1,R.drawable.u2,R.drawable.u3,R.drawable.u4,R.drawable.u5,R.drawable.u6,R.drawable.u7,R.drawable.u8,R.drawable.u9};
    ListView listView;

    ArrayList<ChatList> arrayList;




    public ChateFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chate, container, false);
        listView = view.findViewById(R.id.chate_list_view);

        arrayList = new ArrayList<>();
        for(int i=0; i< technologyArray.length; i++){
            ChatList list = new ChatList();
            list.setName(technologyArray[i]);
            list.setImage(imageArray[i]);
            list.setDescription(description[i]);
            arrayList.add(list);
        }

        ChatAdapter adapter = new ChatAdapter(getActivity(),arrayList);
        listView.setAdapter(adapter);








        return view;


    }

}