package com.example.android.justjava;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int quantity=0;
    /**
     * This method is called when the + button is clicked.
     */
    public void increment(View view) {
        quantity=quantity+1;
        display(quantity);
    }

    /**
     * This method is called when the - button is clicked.
     */
    public void decrement(View view) {
        quantity=quantity-1;
        display(quantity);
    }

    public int calculateprice(boolean haswhippedCream, boolean hasChocolateBox)
    {
        int price= 5;

        if(haswhippedCream)
        {
            price = price+ 1;
        }

        if(hasChocolateBox)
        {
            price = price+2;
        }

        return quantity*price;
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        EditText text = (EditText) findViewById(R.id.name_view);
        String value = text.getText().toString();

        CheckBox whippedCream = (CheckBox) findViewById(R.id.wipped_cream);
        boolean haswhippedCream = whippedCream.isChecked();


        CheckBox ChocolateBox = (CheckBox) findViewById(R.id.Chocolate_Box);
        boolean hasChocolateBox = ChocolateBox.isChecked();

        int price=calculateprice(haswhippedCream, hasChocolateBox);
        String message1= createordersummary(price, haswhippedCream, hasChocolateBox,value);
        //displayMessage(message1);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just java order for "+ value);
        intent.putExtra(Intent.EXTRA_TEXT, message1);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private String createordersummary(int price, boolean haswhippedCream, boolean hasChocolateBox,String value){
        String message1="Name: "+value;
        message1 = message1 + "\nAdd Whipped Cream ?" + haswhippedCream;
        message1 = message1 + "\nAdd Chocolate Box ?" + hasChocolateBox;
        message1 = message1 + "\nQuantity: "+quantity;
        message1 = message1 + "\nYour Total bill is="+ calculateprice(haswhippedCream, hasChocolateBox);
        message1 = message1 + "\nThank You,Come again";
        return message1;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given text on the screen.

    private void displayMessage(String message) {
        TextView OrderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        OrderSummaryTextView.setText(message);
    }
     */
}
