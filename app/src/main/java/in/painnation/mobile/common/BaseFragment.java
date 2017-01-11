package in.painnation.mobile.common;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v4.app.FragmentActivity;

/**
 * Created by codechefamit on 10/1/17.
 */
public abstract class BaseFragment extends Fragment {

    @StringRes
    public abstract int getTitle();

    public abstract String getFragmentTag();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public void replaceFragment(Fragment fragment) {
        ((BaseActivity) getActivity()).replaceFragment(fragment);
    }

    public Fragment getFragmentByTag( String tag){
        return ((BaseActivity) getActivity()).getFragmentByTag(tag);
    }

    public void addFragment( Fragment fragment ) {
        ((BaseActivity) getActivity()).addFragment(fragment);
    }

    public void setTitle(int resId) {
        if (getActivity() != null) {
            getActivity().setTitle(resId);
        }
    }

    public void setTitle(String title) {
        if (getActivity() != null) {
            getActivity().setTitle(title);
        }
    }

    public void setHeaderTitle(String title) {

    }

    public void setHeaderTitle(int stringResId) {
        setHeaderTitle(getString(stringResId));
    }

    public  void removeTopfragment() {
        ((BaseActivity) getActivity()).removeTopfragment();
    }

    public void removeFragmentByTag( String tag){
        ((BaseActivity) getActivity()).removeFragmentByTag( tag );
    }

    public  void showHomeFragment() {
        ((BaseActivity) getActivity()).showHomeFragment();
    }

    public boolean isActivityAlive() {
        FragmentActivity activity = (FragmentActivity) getActivity();
        if(activity != null && !activity.isFinishing()){
            return true;
        }
        return false;
    }

}