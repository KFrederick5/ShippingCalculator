package edu.orangecoastcollege.cs273.kfrederick5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private static NumberFormat currency =NumberFormat.getCurrencyInstance();

    private TextView addCostText;
    private TextView package_ounce;
    private TextView totalCostText;
    private TextView baseCostText;

    ShippingCost currentBill = new ShippingCost();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addCostText = (TextView) findViewById(R.id.addCost);
        package_ounce = (TextView) findViewById(R.id.package_ounce);
        totalCostText = (TextView) findViewById(R.id.totalCost);
        baseCostText = (TextView) findViewById(R.id.baseCost);

        package_ounce.addTextChangedListener(package_ounceChangedListener);


        currentBill.setBaseCost(3.00);
    }

    private TextWatcher package_ounceChangedListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            try
            {
                int ounce = s.length() > 0
                        ?Integer.parseInt(s.toString()): 0;
                currentBill.setOunce(ounce);
            }
            catch(NumberFormatException e)
            {
                package_ounce.setText("");
            }

            package_ounce.setText(currentBill.getOunce());
            updateViews();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };


    private  void updateViews()
    {
        addCostText.setText(currency.format(currentBill.getAddCost()));

        totalCostText.setText(currency.format(currentBill.getTotalCost()));

        baseCostText.setText(currency.format(currentBill.getBaseCost()));
    }

}
