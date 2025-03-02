package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editWeight = findViewById(R.id.editWeight);
        EditText editHeightFeet = findViewById(R.id.editHeightFeet);
        EditText editHeightInches = findViewById(R.id.editHeightInches);
        Button btnCalculate = findViewById(R.id.btnCalculate);
        TextView textResult = findViewById(R.id.textResult);

        btnCalculate.setOnClickListener(v -> {
            try {
                String weightStr = editWeight.getText().toString();
                String feetStr = editHeightFeet.getText().toString();
                String inchesStr = editHeightInches.getText().toString();

                if (weightStr.isEmpty() || feetStr.isEmpty() || inchesStr.isEmpty()) {
                    textResult.setText(R.string.fill_fields);
                    return;
                }

                double weight = Double.parseDouble(weightStr);
                double feet = Double.parseDouble(feetStr);
                double inches = Double.parseDouble(inchesStr);

                // Convert height to meters
                double totalInches = (feet * 12) + inches;
                double heightMeters = totalInches * 0.0254;

                // Calculate BMI
                double bmi = weight / (heightMeters * heightMeters);

                // Display result
                if (bmi < 18.5) {
                    textResult.setText(R.string.underweight);
                } else if (bmi < 25) {
                    textResult.setText(R.string.normal);
                } else {
                    textResult.setText(R.string.overweight);
                }

            } catch (NumberFormatException e) {
                textResult.setText(R.string.invalid_input);
            }
        });
    }
}