package com.example.android.colawar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int coca=0;

    public void coca_increment(View view) {
        coca=coca+1;
    }

    int pepsi=0;
    public void pepsi_increment(View view) {
        pepsi=pepsi+1;
    }

    public void display(View view) {
        String message1="TOTAL COCA-COLA IS "+coca+" vs "+"TOTAL PEPSI IS "+pepsi;
        displayMessage(message1);
    }

    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.disp_text_view);
        priceTextView.setText(message);
    }
}
