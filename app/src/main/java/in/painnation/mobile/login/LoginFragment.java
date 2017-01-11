package in.painnation.mobile.login;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import in.painnation.mobile.R;
import in.painnation.mobile.common.BaseFragment;

/**
 * Created by codechefamit on 10/1/17.
 */

public class LoginFragment extends BaseFragment {
    private View view;
    private final String TAG = this.getClass().getSimpleName();
    @Override
    public int getTitle() {
        return R.string.frg_title_blank;}

    @Override
    public String getFragmentTag() {
        return null;
    }

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_login, container, false);
        TextView txtWelcome=(TextView)view.findViewById(R.id.txtWelcome);
        TextView txtPain=(TextView)view.findViewById(R.id.txtPain);
//        Typeface font = Typeface.createFromAsset(view.getAssets(), "Roboto-Bold.ttf");
//        txtPain.setTypeface(font);
//        txtWelcome.setTypeface(font);
        return  view;
    }
}
