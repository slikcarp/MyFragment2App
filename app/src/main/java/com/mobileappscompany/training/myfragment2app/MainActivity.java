package com.mobileappscompany.training.myfragment2app;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Fragment1.Fragment1Interface {

    private Fragment1 fragment1;
    private Fragment2 fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        fragment1 = new Fragment1();
//        fragment2 = new Fragment2();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragment1 = (Fragment1) fragmentManager.findFragmentById(R.id.forF1);
        if(fragment1 == null || !fragment1.isInLayout()) {
            fragment1 = new Fragment1();
            fragmentTransaction.add(R.id.forF1, fragment1);
        }

        fragment2 = (Fragment2) fragmentManager.findFragmentById(R.id.forF2);
        if(fragment2 == null || !fragment2.isInLayout()) {
            fragment2 = new Fragment2();
            fragmentTransaction.add(R.id.forF2, fragment2);
        }

        fragmentTransaction.commit();
    }

    public void send22(String text) {
        fragment2.setMyText(text);
    }

    public void send21(String text) {
        fragment1.setMyText(text);
    }

    @Override
    public void send2Fragment2(String text) {
        fragment2.setMyText(text);
    }
}
