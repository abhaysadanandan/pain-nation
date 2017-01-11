package in.painnation.mobile.ui.home;

import android.os.Bundle;

import in.painnation.mobile.R;
import in.painnation.mobile.common.BaseActivity;

/**
 * Created by codechefamit on 12/1/17.
 */

public class HomeActivity extends BaseActivity {
    private static final String TAG = HomeActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        addFragment( HomeFragment.newInstance());
    }


    @Override
    protected void backStackChangeListner(int backStackCount) {

    }
}
