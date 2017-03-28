package com.mobileappscompany.training.myfragment2app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class Fragment1 extends Fragment {

    private EditText editText;
    private Button button;

    public Fragment1() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment1, container, false);
        editText = (EditText) view.findViewById(R.id.editText1);
        button = (Button) view.findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMyText();
            }
        });

        setRetainInstance(true);

        return view;
    }

    private void sendMyText() {
//        sendWithNoInterface();
        sendWithInterface();
    }

    private void sendWithInterface() {
        Fragment1Interface fragment1 = (Fragment1Interface) getActivity();
        fragment1.send2Fragment2(editText.getText().toString());
    }

    private void sendWithNoInterface() {
        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.send22(editText.getText().toString());
    }

    public void setMyText(String text) {
        editText.setText(text);
    }

    public interface Fragment1Interface {
        void send2Fragment2(String text);
    }
}
