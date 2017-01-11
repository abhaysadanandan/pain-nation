package in.painnation.mobile.login;

import android.os.Bundle;
import android.view.View;
import in.painnation.mobile.R;
import in.painnation.mobile.common.BaseActivity;

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        addFragment(LoginFragment.newInstance());
    }

    @Override
    protected void backStackChangeListner(int backStackCount) {

    }

    @Override
    public void onBackPressed() {

        if (getBackStackCount() > 1) {
            super.onBackPressed();
        } else {
            finish();
        }
    }

}
