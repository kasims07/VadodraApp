package vadodara.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import java.util.ArrayList;

public class ChatAdapter extends BaseAdapter {

    Context context;
    ArrayList<ChatList> arrayList;

    public ChatAdapter(Context activity, ArrayList<ChatList>arrayList) {
        context = activity;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.coustom_chat,null);
        ImageView imageView = view.findViewById(R.id.custom_chate_image);
        TextView textView = view.findViewById(R.id.custom_chate_name);
        TextView textView1 = view.findViewById(R.id.custom_chate_description);

        textView.setText(arrayList.get(position).getName());
        textView1.setText(arrayList.get(position).getDescription());
        imageView.setImageResource(arrayList.get(position).getImage());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,User1Activity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name",arrayList.get(position).getName());
                bundle.putString("description",arrayList.get(position).getDescription());
                bundle.putInt("image",arrayList.get(position).getImage());
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DpActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("uImage",arrayList.get(position).getImage());
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        return view;
    }


}
