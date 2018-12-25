package sanilk.com.userinterfaceandnavigation;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ViewPagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        ViewPager viewPager = (ViewPager)findViewById(R.id.activity_view_pager_view_pager);
        viewPager.setAdapter(new MyFragmentPageStateAdapter(getSupportFragmentManager()));

    }

    private class MyFragmentPageStateAdapter extends FragmentStatePagerAdapter{

        public MyFragmentPageStateAdapter(FragmentManager fm){
            super(fm);
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public Fragment getItem(int i) {
            if(i==0){
                return new ViewPagerFragment1();
            }else{
                return new ViewPagerFragment2();
            }
        }
    }
}
