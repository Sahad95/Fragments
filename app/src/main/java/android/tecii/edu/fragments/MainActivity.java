package android.tecii.edu.fragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends MainCallbacks {
    android.app.FragmentTransaction ft;
    FragmentRed redFragment;
    FragmentBlue blueFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ft = getFragmentManager().beginTransaction();
        blueFragment = FragmentBlue.newInstance("first-blue");
        ft.replace(R.id.main_holder_blue,blueFragment);
        ft.commit();

        ft = getFragmentManager().beginTransaction();
        redFragment = FragmentRed.newInstance("first-red");
        ft.replace(R.id.main_holder_red,redFragment);
        ft.commit();
    }

    @Override
    public void onAttachFragment(android.app.Fragment fragment){
        super.onAttachFragment(fragment);
        if (fragment.getClass() == FragmentRed.class){
            redFragment = (FragmentRed)fragment;
        }
        if (fragment.getClass() == FragmentBlue.class){
            blueFragment = (FragmentBlue)fragment;
        }
    }

    @Override
    public void onMsgFromFragToMain(String sender, String strValue){
        Toast.makeText(getApplication()," MAIN GOT MSG >> "+sender+"\n"+strValue,Toast.LENGTH_LONG)
                .show();

        if (sender.equals("RED-FRAG")){

        }

        if(sender.equals("BLUE-FRAG")){
            redFragment.onMsgFromMainToFragment("\nSender: "+sender+"\nMsg: "+strValue);
        }
    }

}
