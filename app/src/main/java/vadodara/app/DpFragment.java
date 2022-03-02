package vadodara.app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class DpFragment extends Fragment {

    ImageView imageView;


    public DpFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dp, container, false);
        imageView = view.findViewById(R.id.custom_dp_image);
        Bundle bundle = getArguments();
        int uImage = bundle.getInt("uImage");
        imageView.setImageResource(uImage);

        return view;
    }
}