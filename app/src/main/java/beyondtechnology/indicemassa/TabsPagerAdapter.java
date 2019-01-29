package beyondtechnology.indicemassa;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPagerAdapter extends FragmentPagerAdapter {

    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {

        switch (index) {

            case 0:
                return new Calculo();
            case 1:
                return new Classificacao();
            case 2:
                return new ItemFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 3;
    }
}