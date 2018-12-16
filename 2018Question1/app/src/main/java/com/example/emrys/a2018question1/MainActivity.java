package com.example.emrys.a2018question1;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    //DO NOT MODIFY THE INSTANCE VARIABLE NAMES INCLUDED BELOW
    //YOU MAY ADD YOUR OWN


    EditText editTextFaceValue;
    EditText editTextSellingPrice;
    EditText editTextAnnualInterest;
    EditText editTextDuration;
    Button buttonCalculateYield;
    TextView textViewResult;
    final String sharedPrefFile = "sharedPref";
    SharedPreferences sharedPreferences;
    final String KEY_FACEVALUE = "faceValue";
    final String KEY_SELLINGPRICE = "sellingPrice";
    final String KEY_ANNUALINTEREST = "annualInterest";
    final String KEY_DURATION = "duration";
    final String EMPTY_STRING = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sharedPreferences  = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        String facevalue = sharedPreferences.getString(KEY_FACEVALUE, "");
        String sellingprice = sharedPreferences.getString(KEY_SELLINGPRICE, "");
        String interest = sharedPreferences.getString(KEY_ANNUALINTEREST, "");
        String duration= sharedPreferences.getString(KEY_DURATION, "");


        buttonCalculateYield = findViewById(R.id.buttonCalculateYield);
        editTextAnnualInterest = findViewById(R.id.editTextAnnualInterest);
        editTextFaceValue =findViewById(R.id.editTextFaceValue);
        editTextSellingPrice = findViewById(R.id.editTextSellingPrice);
        editTextDuration = findViewById(R.id.editTextDuration);
        textViewResult = findViewById(R.id.textViewResult);

        editTextFaceValue.setText(facevalue);
        editTextDuration.setText(duration);
        editTextSellingPrice.setText(sellingprice);
        editTextAnnualInterest.setText(interest);


        buttonCalculateYield.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String faceValue = editTextFaceValue.getText().toString();
                String sellingPrice = editTextSellingPrice.getText().toString();
                String interest = editTextAnnualInterest.getText().toString();
                String duration = editTextDuration.getText().toString();
                if (faceValue.equals("") | sellingPrice.equals("") | interest.equals("") | duration.equals("")) {
                    Toast.makeText(MainActivity.this, "all the field must be filled to calculate", Toast.LENGTH_LONG).show();
                } else {
                    double facevalueNum = Double.valueOf(faceValue);
                    double sellingpriceNum = Double.valueOf(sellingPrice);
                    double interestvalueNum = Double.valueOf(interest);
                    double durationvalueNum = Double.valueOf(duration);

                    if (facevalueNum <=0 | sellingpriceNum <=0 | durationvalueNum <= 0)  {
                        Toast.makeText(MainActivity.this,
                                "FaceValue selling price and duration need to be bigger than 0", Toast.LENGTH_LONG).show();
                    } else if (interestvalueNum <0) {
                        Toast.makeText(MainActivity.this, "Interest need to be bigger than zero", Toast.LENGTH_LONG).show();
                    } else {
                        GetResult getResult = new GetResult();
                        getResult.execute(facevalueNum, sellingpriceNum, interestvalueNum, durationvalueNum);
                    }
                }
            }
        });
    }


    class GetResult extends AsyncTask<Double, Void, Double>{
        @Override
        protected Double doInBackground(Double... doubles) {
            double facevalueNum = doubles[0];
            double sellingpriceNum = doubles[1];
            double interestNum = doubles[2];
            double durationNum = doubles[3];
            Bond.BondBuilder bondBuilder = new Bond.BondBuilder();
            double result;
            if ( interestNum == 0) {
                Bond bond2 = bondBuilder
                        .setDuration(durationNum)
                        .setFaceValue(facevalueNum)
                        .setSellingPrice(sellingpriceNum)
                        .setInterestPayment(interestNum).createBond();
                bond2.setYieldCalculator(new ZeroCouponYield());
                result = bond2.calculateYTM();
            } else {
                Bond bond1 = bondBuilder
                        .setDuration(durationNum)
                        .setFaceValue(facevalueNum)
                        .setSellingPrice(sellingpriceNum)
                        .setInterestPayment(interestNum).createBond();
                bond1.setYieldCalculator(new WithCouponYield());
                result = bond1.calculateYTM();
            }
            return result;
        }

        @Override
        protected void onPostExecute(Double aDouble) {
            super.onPostExecute(aDouble);
            textViewResult.setText(Double.toString(aDouble));
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_DURATION, editTextDuration.getText().toString());
        editor.putString(KEY_ANNUALINTEREST, editTextAnnualInterest.getText().toString());
        editor.putString(KEY_SELLINGPRICE, editTextSellingPrice.getText().toString());
        editor.putString(KEY_FACEVALUE, editTextFaceValue.getText().toString());
        editor.apply();
    }
}
