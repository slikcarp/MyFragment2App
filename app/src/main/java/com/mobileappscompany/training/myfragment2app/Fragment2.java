package com.mobileappscompany.training.myfragment2app;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class Fragment2 extends Fragment {

    private EditText editText;
    private Button button;

    public Fragment2() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment2, container, false);
        editText = (EditText) view.findViewById(R.id.editText2);
        button = (Button) view.findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMyText();
            }
        });

        setRetainInstance(true);

        return view;
    }

    public void sendMyText() {
        sendWithNoInterface();
    }

    private void sendWithNoInterface() {
        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.send21(editText.getText().toString());
    }

    public void setMyText(String text) {
        editText.setText(text);
    }
}
