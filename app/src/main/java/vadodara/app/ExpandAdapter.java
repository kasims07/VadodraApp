package vadodara.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ExpandAdapter extends BaseExpandableListAdapter {

    Context context;
    ArrayList<GroupList> arrayList;
    LayoutInflater layoutInflater;

    public ExpandAdapter(ExpandDemoActivity expandDemoActivity, ArrayList<GroupList> arrayList) {
        this.context = expandDemoActivity;
        this.arrayList = arrayList;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getGroupCount() {
        return arrayList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return arrayList.get(groupPosition).getChildArrayLists().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return arrayList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return arrayList.get(groupPosition).getChildArrayLists().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.custome_group,null);
        TextView name = convertView.findViewById(R.id.custom_group_name);
        ImageView image = convertView.findViewById(R.id.custom_group_image);
        name.setText(arrayList.get(groupPosition).getName());
        image.setImageResource(arrayList.get(groupPosition).getImage());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.custome_child,null);
        TextView childname = convertView.findViewById(R.id.custom_child_name);
        childname.setText(arrayList.get(groupPosition).getChildArrayLists().get(childPosition).getChildName());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
