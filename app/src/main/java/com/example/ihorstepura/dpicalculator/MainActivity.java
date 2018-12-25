package com.example.ihorstepura.dpicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText1;
    EditText editText2;
    EditText editText3;

    TextView textView1;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText_1);
        editText2 = findViewById(R.id.editText_2);
        editText3 = findViewById(R.id.editText_3);

        textView1 = findViewById(R.id.textView_1);
        textView2 = findViewById(R.id.textView_2);
    }

    public void onClick(View view) {
        String size = editText1.getText().toString();
        String orientH = editText2.getText().toString();
        String orientV = editText3.getText().toString();

        if (size.isEmpty() | orientH.isEmpty() | orientV.isEmpty()) {
            Toast.makeText(this, "Some field is empty", Toast.LENGTH_LONG).show();
        } else {

            int a = Integer.parseInt(orientH);
            int b = Integer.parseInt(orientV);
            double num_size = Double.parseDouble(size);

            double c = Math.sqrt((a * a) + (b * b));
            double dpi = c / num_size;

            String dp = String.valueOf(dpi);
            textView1.setText(dp);

            if (dpi <= 120) {
                textView2.setText("LDPI");
            } else if (dpi <= 160) {
                textView2.setText("MDPI");
            } else if (dpi <= 240) {
                textView2.setText("HDPI");
            } else if (dpi <= 320) {
                textView2.setText("XHDPI");
            } else if (dpi <= 480) {
                textView2.setText("XXHDPI");
            } else if (dpi <= 640) {
                textView2.setText("XXXHDPI");
            }
        }
    }

    public void onExitClick(View view) {
        finish();
    }
}
