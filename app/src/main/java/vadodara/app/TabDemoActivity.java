package vadodara.app;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class TabDemoActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_demo);
        getSupportActionBar().setTitle("WhatsApp");

        tabLayout = findViewById(R.id.tabBar);
        viewPager = findViewById(R.id.tab_view);

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });
        viewPager.setAdapter(new tabdemoAdapter(getSupportFragmentManager()));


    }

    private class tabdemoAdapter extends FragmentPagerAdapter {
        public tabdemoAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return "CHATS";
                case 1:
                    return "STATUS";
                case 2:
                    return "CALLS";
            }
            return super.getPageTitle(position);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new ChatsFragment();
                case 1:
                    return new StatusFragment();
                case 2:
                    return new CallFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}