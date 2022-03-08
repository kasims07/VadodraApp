package vadodara.app;

import java.util.ArrayList;

public class GroupList {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    String name;
    int Image;

    public ArrayList<ChildList> getChildArrayLists() {
        return childArrayLists;
    }

    public void setChildArrayLists(ArrayList<ChildList> childArrayLists) {
        this.childArrayLists = childArrayLists;
    }

    ArrayList<ChildList> childArrayLists;

}
