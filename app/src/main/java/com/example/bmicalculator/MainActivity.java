package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView resultName, resultBMI, resultCondition;
        EditText userName, userWeight, userHeightFt, userHeightIn;
        Button calBtn;
        LinearLayout llMain;

        resultName = findViewById(R.id.resultName);
        resultBMI = findViewById(R.id.resultBMI);
        resultCondition = findViewById(R.id.resultCondition);
        userName = findViewById(R.id.userName);
        userWeight = findViewById(R.id.userWeight);
        userHeightFt = findViewById(R.id.userHeightFt);
        userHeightIn = findViewById(R.id.userHeightIn);
        calBtn = findViewById(R.id.calBtn);
        llMain = findViewById(R.id.llMain);

        calBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usrNm = userName.getText().toString();
                double usrWgt = Integer.parseInt(userWeight.getText().toString());
                double usrHgtFt = Integer.parseInt(userHeightFt.getText().toString());
                double usrHgtIn = Integer.parseInt(userHeightIn.getText().toString());
                double usrHgt = (usrHgtFt * 0.3048) + (usrHgtIn * 0.0254);
                double usrBMI = usrWgt / (usrHgt * usrHgt);

                if (usrBMI < 18.5) {
                    resultName.setText("Hi! " + usrNm);
                    resultBMI.setText("Your BMI is " + new DecimalFormat("##.##").format(usrBMI));
                    resultCondition.setText("You are Underweight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.clrUW));
                } else if (usrBMI > 24.5) {
                    resultName.setText("Hi! " + usrNm);
                    resultBMI.setText("Your BMI is " + new DecimalFormat("##.##").format(usrBMI));
                    resultCondition.setText("You are Overweight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.clrOW));
                } else {
                    resultName.setText("Hi! " + usrNm);
                    resultBMI.setText("Your BMI is " + new DecimalFormat("##.##").format(usrBMI));
                    resultCondition.setText("You are good");
                    llMain.setBackgroundColor(getResources().getColor(R.color.clrH));
                }
            }
        });
    }
}