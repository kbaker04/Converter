package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String itemSelected;
    Integer selectedIndex;
    EditText mainInput;

    TextView labelOne;
    TextView labelTwo;
    TextView labelThree;

    TextView resultOne;
    TextView resultTwo;
    TextView resultThree;

    String noValue = "Please enter a value";
    String msg = "Please enter a value to convert";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // input
        mainInput = findViewById(R.id.mainInput);

        // text views - labels
        labelOne = findViewById(R.id.labelOne);
        // typeOne.setText("");
        labelTwo = findViewById(R.id.labelTwo);
        // typeTwo.setText("");
        labelThree = findViewById(R.id.labelThree);
        // typeThree.setText("");

        // text views - values
        resultOne = findViewById(R.id.resultOne);
        // resultOne.setText("");
        resultTwo = findViewById(R.id.resultTwo);
        // resultTwo.setText("");
        resultThree = findViewById(R.id.resultThree);
        // resultThree.setText("");

        // spinner
        Spinner spinner = findViewById(R.id.measureSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.measurements, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        itemSelected = adapterView.getItemAtPosition(i).toString();
        mainInput.setText(R.string.default_value);
        selectedIndex = i;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void measureButton(View view) {
        if (selectedIndex != 0) {
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        }
        else if (!TextUtils.isEmpty(mainInput.getText().toString())) {
            Float inputValue = Float.parseFloat(mainInput.getText().toString());

            // set labels
            labelOne.setText(R.string.centimetre_label);
            labelTwo.setText(R.string.foot_label);
            labelThree.setText(R.string.inch_label);

            // set calculations
            Float cm = inputValue * 100;
            resultOne.setText(String.format("%.0f", cm));

            Double foot = inputValue * 3.280839895;
            resultTwo.setText(String.format("%.2f", foot));

            Double inch = inputValue * 39.3700787402;
            resultThree.setText(String.format("%.2f", inch));
        } else {
            Toast.makeText(getApplicationContext(), noValue, Toast.LENGTH_LONG).show();
        }
    }

    public void tempButton(View view) {
        if (selectedIndex != 1) {
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        }
        else if (!TextUtils.isEmpty(mainInput.getText().toString())) {
            Float inputValue = Float.parseFloat(mainInput.getText().toString());

            // set labels
            labelOne.setText(R.string.gram_label);
            labelTwo.setText(R.string.ounce_label);
            labelThree.setText(R.string.default_value);

            // set calculations
            Double fahrenheit = (inputValue * 1.8000) + 32;
            resultOne.setText(String.format("%.2f", fahrenheit));

            Double kelvin = inputValue + 273.15;
            resultTwo.setText(String.format("%.2f", kelvin));

            resultThree.setText(R.string.default_value);
        } else {
            Toast.makeText(getApplicationContext(), noValue, Toast.LENGTH_LONG).show();
        }
    }

    public void weightButton(View view) {
        if (selectedIndex != 2) {
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        }
        else if (!TextUtils.isEmpty(mainInput.getText().toString())) {
            Float inputValue = Float.parseFloat(mainInput.getText().toString());

            // set labels
            labelOne.setText(R.string.gram_label);
            labelTwo.setText(R.string.ounce_label);
            labelThree.setText(R.string.pound_label);

            // set calculations
            Float gram = inputValue * 1000;
            resultOne.setText(String.format("%.0f", gram));

            Double ounce = inputValue / 0.02834952;
            resultTwo.setText(String.format("%.2f", ounce));

            Double pound = inputValue / 0.45359237;
            resultThree.setText(String.format("%.2f", pound));
        } else {
            Toast.makeText(getApplicationContext(), noValue, Toast.LENGTH_LONG).show();
        }
    }
}