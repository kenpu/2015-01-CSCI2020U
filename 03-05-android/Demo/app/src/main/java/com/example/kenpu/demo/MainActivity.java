package com.example.kenpu.demo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)this.findViewById(R.id.likeButton);
        TextView counter = (TextView)this.findViewById(R.id.likeText);

        View.OnClickListener controller = new ClickListener(counter);
        button.setOnClickListener(controller);
    }

}
