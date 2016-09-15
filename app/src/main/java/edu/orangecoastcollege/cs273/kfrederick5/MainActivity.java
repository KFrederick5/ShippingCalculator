package edu.orangecoastcollege.cs273.kfrederick5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    /**
     * Set a currency format for dollar amounts.
     */
    private static NumberFormat currency =NumberFormat.getCurrencyInstance(Locale.US);


    /**
     * Created variables for added cost, total cost, weight, and base cost
     * that can be manipulated to output different values and
     * display them to the user.
     */
    private TextView addCostText;
    private TextView package_ounce;
    private TextView totalCostText;
    private TextView baseCostText;

    /**
     * Created a new object of type shipping cost to hold values
     * for the current package being shipped
     */
    ShippingCost currentBill = new ShippingCost();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Hook ups between the XML objects and the variables
         * substantiated in this java file.
         */
        addCostText = (TextView) findViewById(R.id.addCost);
        package_ounce = (EditText) findViewById(R.id.package_ounce);
        totalCostText = (TextView) findViewById(R.id.totalCost);
        baseCostText = (TextView) findViewById(R.id.baseCost);

        /**
         * Created a text listener for the editText item in the XML
         * document
         */
        package_ounce.addTextChangedListener(package_ounceChangedListener);
    }

    /**
     * Created a text watcher to activate if the editText view was
     * changed by the user.
     */
    private TextWatcher package_ounceChangedListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        /**
         * Only used the on text change for instant feedback to the user when
         * making changes to the editText view
         * @param s takes in the character sequence enter by the user
         * @param start reads the string character by character
         * @param before ?
         * @param count holds the count for the string array
         */
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

            //package_ounce.setText(currentBill.getOunce());
            updateViews();
        }
        @Override
        public void afterTextChanged(Editable s) {
        }
    };


    /**
     * Sets the TextViews for added cost and total cost with the
     * values assigned to them in the ShippingCost.java file
     */
    private  void updateViews()
    {
        addCostText.setText(currency.format(currentBill.getAddCost()));

        totalCostText.setText(currency.format(currentBill.getTotalCost()));
    }

}
