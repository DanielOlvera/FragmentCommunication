package com.example.daniel.fragmentcommunication;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements BlankFragment.Callback{

    private static final String TAG = "MainActivity_TAG";
    private static final String MY_TAG = "MY_FRAGMENT_TAG";

    //Here is how to create a lookup
    public TextView textView;
    public Button button;
    private FrameLayout frameLayout;

    private BlankFragment blankFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        blankFragment = new BlankFragment();

        textView = (TextView) findViewById(R.id.a_main_text);
        button = (Button) findViewById(R.id.a_button);
        frameLayout = (FrameLayout) findViewById(R.id.a_main_frame);

        button.setOnClickListener(new View.OnClickListener() { //This is an anonimous classes
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: " + new Date());
            }
        });

        getSupportFragmentManager().beginTransaction().add(R.id.a_main_frame, blankFragment, MY_TAG).commit();
    }

    //Implement methods from fragment, that had implements the interface Callback
    @Override
    public void buttonClicked() {
        textView.setText("Whatever!");
    }
}
