package com.example.mybmiapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
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
                // Get input values
                String weightStr = editWeight.getText().toString();
                String feetStr = editHeightFeet.getText().toString();
                String inchesStr = editHeightInches.getText().toString();

                // Validate empty fields
                if (weightStr.isEmpty() || feetStr.isEmpty() || inchesStr.isEmpty()) {
                    textResult.setText(R.string.fill_fields);
                    return;
                }

                // Parse values
                double weight = Double.parseDouble(weightStr);
                double feet = Double.parseDouble(feetStr);
                double inches = Double.parseDouble(inchesStr);

                // Convert height to meters
                double totalInches = (feet * 12) + inches;
                double heightMeters = totalInches * 0.0254;} catch (NumberFormatException e) {
                throw new RuntimeException(e);}})


            // Calculate BMI
    ;}}