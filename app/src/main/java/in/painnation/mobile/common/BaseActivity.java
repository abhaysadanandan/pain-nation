package in.painnation.mobile.common;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import in.painnation.mobile.R;

/**
 * Created by codechefamit on 10/1/17.
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected String lastFragmentName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected abstract void backStackChangeListner( int backStackCount );

    public void addFragment(Fragment fragment) {
        if (fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.addOnBackStackChangedListener(getListener());

            android.app.FragmentTransaction transaction = fragmentManager.beginTransaction();

            transaction.addToBackStack(fragment.getClass().getSimpleName());
            getFragmentManager().getBackStackEntryCount();
            transaction.add(R.id.fragment_container, fragment, fragment.getClass().getSimpleName());
            transaction.commitAllowingStateLoss();
        }
    }

    public void replaceFragment(Fragment fragment) {
        if (fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.addOnBackStackChangedListener(getListener());

            android.app.FragmentTransaction transaction = fragmentManager.beginTransaction();

            transaction.addToBackStack(fragment.getClass().getSimpleName());
            getFragmentManager().getBackStackEntryCount();
            transaction.replace(R.id.fragment_container, fragment, fragment.getClass().getSimpleName());
            transaction.commitAllowingStateLoss();

        }
    }


    public Fragment getFragmentByTag(String tag){

        FragmentManager fragmentManager = getFragmentManager();

        Fragment fragment = fragmentManager.findFragmentByTag(tag);

        return fragment;

    }

    public void replaceFragmentWithSharedElement(Fragment fragment, View view, String transitionName) {
        if (fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.addOnBackStackChangedListener(getListener());

            android.app.FragmentTransaction transaction = fragmentManager.beginTransaction();

            transaction.addToBackStack(fragment.getClass().getSimpleName());
            getFragmentManager().getBackStackEntryCount();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                transaction.addSharedElement(view, transitionName);
            }
            transaction.replace(R.id.fragment_container, fragment,fragment.getClass().getSimpleName());
            transaction.commitAllowingStateLoss();

        }
    }

    public void removeFragment(Fragment fragment) {
        if (fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            android.app.FragmentTransaction transaction = fragmentManager
                    .beginTransaction();

            transaction.remove(fragment);
            transaction.commit();
            fragmentManager.popBackStack();
        }
    }



    public  void removeTopfragment() {
        FragmentManager fm = getFragmentManager();
        fm.popBackStack();
    }

    public void removeFragmentByTag (String tag) {
        FragmentManager fragmentManager = getFragmentManager();
        android.app.FragmentTransaction trans = fragmentManager.beginTransaction();
        Fragment frg = fragmentManager.findFragmentByTag(tag);
        trans.remove(frg);
        trans.commit();
        fragmentManager.popBackStack();
    }

     public void resetBackStack() {
        FragmentManager fm = getFragmentManager();
        for (int i = 1; i < fm.getBackStackEntryCount(); ++i) {
            fm.popBackStack();
        }
     }


    public void showHomeFragment() {
        FragmentManager fm = getFragmentManager();
        for (int i = 1; i < fm.getBackStackEntryCount(); ++i) {
            fm.popBackStack();
        }
    }

    public int getBackStackCount(){
        FragmentManager fm = getFragmentManager();
        return fm.getBackStackEntryCount();
    }


    private FragmentManager.OnBackStackChangedListener getListener() {
        FragmentManager.OnBackStackChangedListener result = new FragmentManager.OnBackStackChangedListener() {
            public void onBackStackChanged() {
                FragmentManager manager = getFragmentManager();

                if (manager != null) {
                    backStackChangeListner( getBackStackCount() );

                    BaseFragment currFrag = (BaseFragment) manager
                            .findFragmentById(R.id.fragment_container);

                    if( currFrag !=null && !lastFragmentName.equals(currFrag.getClass().getName())){
                        lastFragmentName = currFrag.getClass().getSimpleName();
                        currFrag.onResume();
                    }
                }
            }
        };
        return result;
    }

}