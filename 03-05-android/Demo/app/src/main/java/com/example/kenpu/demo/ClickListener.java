package com.example.kenpu.demo;

import android.view.View;
import android.widget.TextView;

/**
 * Created by kenpu on 3/5/15.
 */
public class ClickListener implements View.OnClickListener {
    private int counter = 0;
    private TextView textView = null;
    public ClickListener(TextView textView) {
        this.textView = textView;
    }
    @Override
    public void onClick(View v) {
        counter += 1;
        String text = "" + counter;
        this.textView.setText(text);
    }
}
