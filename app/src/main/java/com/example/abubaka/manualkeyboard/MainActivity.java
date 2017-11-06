package com.example.abubaka.manualkeyboard;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnKeyListener, KeyboardView.OnKeyboardActionListener {

    private static final String TAG = "MainActivity";
    private KeyboardView keyboardView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        keyboardView = (KeyboardView) findViewById(R.id.keyboardView);
        Keyboard keyboard = new Keyboard(this, R.xml.number_pad);
        keyboardView.setKeyboard(keyboard);
        keyboardView.setEnabled(true);
        keyboardView.setPreviewEnabled(true);
        keyboardView.setOnKeyListener(this);
        keyboardView.setOnKeyboardActionListener(this);
        keyboardView.setPreviewEnabled(false);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//            keyboardView.setBackground(new ColorDrawable(getResources().getColor(R.color.colorDefaultKeyboardBackground)));
//        }else{
//            keyboardView.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorDefaultKeyboardBackground)));
//        }

        EditText editText = (EditText) findViewById(R.id.edt);

        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleKeyboardVisibility();
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
            }

        });

    }
    private void toggleKeyboardVisibility() {

        int visibility = keyboardView.getVisibility();
        switch (visibility) {
            case View.VISIBLE:
                keyboardView.setVisibility(View.INVISIBLE);
                break;
            case View.GONE:
            case View.INVISIBLE:
                keyboardView.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        Log.d("MainActivity", "onKey? keyCode=" + keyCode);
        return false;
    }

    @Override
    public void onPress(int primaryCode) {

    }

    @Override
    public void onRelease(int primaryCode) {

    }

    @Override
    public void onKey(int primaryCode, int[] keyCodes) {
        Log.d(TAG, "onKey? primaryCode=" + primaryCode);
        int n1 = 0; // -1 count
        for (int keyCode : keyCodes) {
            if (keyCode == -1) {
                n1++;
                continue;
            }
            Log.v(TAG, "keyCode=" + keyCode);
        }
        Log.v(TAG, "keyCode=-1 *" + n1);
    }


    @Override
    public void onText(CharSequence text) {

    }

    @Override
    public void swipeLeft() {

    }

    @Override
    public void swipeRight() {

    }

    @Override
    public void swipeDown() {

    }

    @Override
    public void swipeUp() {

    }
}


