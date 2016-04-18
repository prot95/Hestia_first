package com.example.protichi.hestia_first;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ProductDetailsActivity extends Activity
{

    private static final String TAG = ProductDetailsActivity.class.getSimpleName();

    protected SQLiteDatabase db;
    protected Cursor cursor;
    protected ListAdapter adapter;
    String productIndex;
    public Product selectedProduct;
    public EditText editTextQuantity;
    String selectedItemFromSearch;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);

        Log.e(TAG, "IN ProductDetailsAction");
        if(getIntent().getStringExtra("methodName")== null)
        {
            Log.e(TAG, "starting GETDETAILCUSTOMERMENU METHOD!!!!!!!!!!!!!!!!! ");
            getDetailsCustomMenu();

        }
        else if(getIntent().getStringExtra("methodName").equals("getDetails"))
        {
            Log.e(TAG, "entered else if of getDeatilsfromsearch");
            selectedItemFromSearch = getIntent().getStringExtra("itemName");
            id =getIntent().getStringExtra("id");
            getDetailsFromSearch(selectedItemFromSearch, id);
        }

        Log.e(TAG, "befor the add to cart button");
        //CART BUTTON
        Button addToCartButton = (Button) findViewById(R.id.ButtonAddToCart);
        addToCartButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                // Check to see that a valid quantity was entered
                int quantity = 0;
                try {
                    quantity = Integer.parseInt(editTextQuantity.getText()
                            .toString());

                    if (quantity < 0) {
                        Toast.makeText(getBaseContext(),
                                "Please enter a quantity of 0 or higher",
                                Toast.LENGTH_SHORT).show();
                        return;
                    }

                } catch (Exception e) {
                    Toast.makeText(getBaseContext(),
                            "Please enter a numeric quantity",
                            Toast.LENGTH_SHORT).show();

                    return;
                }

                // If we make it here, a valid quantity was entered
                ShoppingCartHelper.setQuantity(selectedProduct, quantity);
                // Close the activity
                finish();
            }
        });
    }


    public void getDetailsCustomMenu()
    {
        setContentView(R.layout.product_details);
        Log.e(TAG,"IN GETDETAILCUSTOMERMENU METHOD!!!!!!!!!!!!!!!!! "  );
        //invokes when items searched from custom menus of home page
        List<Product> catalog = ShoppingCartHelper.getCatalog(getResources());

        int productIndex = getIntent().getExtras().getInt(
                ShoppingCartHelper.PRODUCT_INDEX);

        //int simsIndex = getIntent().getExtras().getInt(ShoppingCartHelper.getProductPos(ShoppingCartHelper.PRODUCT_INDEX));

//
//        final Product selectedProduct = catalog.get(productIndex);
//
//        final Product toBeDisplayed = catalog.get(selectedProduct.dishPos);
//
        final Product toBeDisplayed = catalog.get(productIndex);
        selectedProduct = catalog.get(toBeDisplayed.dishPos-1);


        // Set the proper image and text
        ImageView productImageView = (ImageView) findViewById(R.id.ImageViewProduct);
        productImageView.setImageDrawable(selectedProduct.productImage);

        TextView productTitleTextView = (TextView) findViewById(R.id.TextViewProductTitle);
        productTitleTextView.setText(selectedProduct.title);

        TextView productDetailsTextView = (TextView) findViewById(R.id.TextViewProductDetails);
        productDetailsTextView.setText(selectedProduct.description);

   /*     TextView productPriceTextView = (TextView) findViewById(R.id.Price);
        productPriceTextView.setText((int)selectedProduct.price);*/

        TextView productPriceTextView = (TextView) findViewById(R.id.Price);
        productPriceTextView.setText("Rs." + selectedProduct.price);

        setCart();
    }


    public void getDetailsFromSearch(String itemName,String id)
    {
        Log.d(TAG, "itemName is" + itemName);
        setContentView(R.layout.product_details);
        //invoked when items searhced from sql database
        Log.e(TAG, "IN ProductDetailsAction in getDetailsFromSearchMethod");

        db = (new DatabaseHelper(this)).getWritableDatabase();
        Log.d(TAG, "EMPLOYEE LIST ONCREATE 22");


        Log.d(TAG, "EMPLOYEE LIST SEARCH BUTTON CLICKED");
      /*  cursor = db.rawQuery("SELECT _id, firstName, lastName, title FROM employee WHERE _id || ' ' || lastName LIKE ?",
                new String[]{"%" + identity + "%"});*/

        cursor = db.query(
                "employee" /* table */,
                new String[] { "email", "title" , "firstName" , "officePhone", "indexNumber"} /* columns */,
                "indexNumber = ?" /* where or selection */,
                new String[] { id } /* selectionArgs i.e. value to replace ? */,
                null /* groupBy */,
                null /* having */,
                null /* orderBy */
        );
        Context context = this;

      /*  adapter = new SimpleCursorAdapter(
                this,
                R.layout.activity_employee_list,
                cursor,
                new String[] {"firstName", "lastName", "title"},
                new int[] {R.id.firstName, R.id.lastName, R.id.title});
        setListAdapter(adapter);*/

        if (cursor.moveToFirst()){
            while(!cursor.isAfterLast()){
                String email = cursor.getString(cursor.getColumnIndex("email"));
                // do what ever you want here
                String firstName = cursor.getString(cursor.getColumnIndex("firstName"));
                String title = cursor.getString(cursor.getColumnIndex("title"));
                String price =  cursor.getString(cursor.getColumnIndex("officePhone"));
                String pos = cursor.getString(cursor.getColumnIndex("indexNumber"));
                int inputPos = Integer.parseInt(pos);
                int inputPrice = Integer.parseInt(price);
                selectedProduct = new Product(firstName,context.getResources().getDrawable(R.drawable.dish),title,inputPrice,inputPos);
                /////////////////
                TextView productTitleTextView = (TextView) findViewById(R.id.TextViewProductTitle);
                productTitleTextView.setText(firstName);
                TextView productPriceTextView = (TextView) findViewById(R.id.Price);
                productPriceTextView.setText("Rs." + price);
                TextView productDetailsTextView = (TextView) findViewById(R.id.TextViewProductDetails);
                productDetailsTextView.setText(title);

                /////////////////////

                Log.e(TAG,"data display :::   " +email );


                cursor.moveToNext();
            }
        }
        setCart();
    }


    public void setCart()
    {
        // Update the current quantity in the cart
        TextView textViewCurrentQuantity = (TextView) findViewById(R.id.textViewCurrentlyInCart);
        textViewCurrentQuantity.setText("Currently in Cart: "
                + ShoppingCartHelper.getProductQuantity(selectedProduct));

        // Save a reference to the quantity edit text
        editTextQuantity = (EditText) findViewById(R.id.editTextQuantity);
        editTextQuantity.setSelection(editTextQuantity.getText().length());


    }

}