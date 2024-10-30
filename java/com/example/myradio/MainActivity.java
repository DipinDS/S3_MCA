package com.example.myradio;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    CheckBox c1,c2,c3;
    RadioGroup r;
    RadioButton r1,r2;
    Button b1;
    TextView t1;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        c1 =(CheckBox) findViewById(R.id.c1);
        c2 =(CheckBox) findViewById(R.id.c2);

        r1 = (RadioButton) findViewById(R.id.r1);
        r2 =(RadioButton) findViewById(R.id.r2);
        t1 = (TextView) findViewById(R.id.t1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String s[] = new String[3];
               t1.setText("");
                if(c1.isChecked())
                    t1.setText(t1.getText().toString()+" "+c1.getText());
                if(c2.isChecked())
                    t1.setText(t1.getText().toString()+" "+c2.getText());
                if(c3.isChecked())
                    t1.setText(t1.getText().toString()+" "+c3.getText());

            }
        });

        r = (RadioGroup) findViewById(R.id.r);
        r.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.r){
                    Toast.makeText(getApplicationContext(),r1.getText().toString(),Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(getApplicationContext(),r2.getText().toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}