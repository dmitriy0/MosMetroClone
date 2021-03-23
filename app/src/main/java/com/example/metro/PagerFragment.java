package com.example.metro;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerFragment extends FragmentStatePagerAdapter {
    private String tabTitles[] = new String[] { "Важное", "Статьи", "Twitter"};
    //integer to count number of tabs
    int tabCount;


    public PagerFragment(@NonNull FragmentManager fm,int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    //Overriding method getItem

    public Fragment getItem(int  position) {
        //Returning the current tabs
        switch (position) {
            case 0:
                Important tab1 = new Important();
                return tab1;
            case 1:
                Articles tab2 = new Articles();
                return tab2;
            case 2:
                Twitter tab3 = new Twitter();
                return tab3;

            default:
                return null;
        }
    }
    @Override public CharSequence getPageTitle(int position) {
        // генерируем заголовок в зависимости от позиции
        return tabTitles[position];
    }

    @Override
    public int getCount() {
        return tabCount;
    }


}
