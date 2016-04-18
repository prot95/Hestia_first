package com.example.protichi.hestia_first;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class ShoppingCartActivity extends Activity {

    private List<Product> mCartList;
    private ProductAdapter mProductAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_cart);


        mCartList = ShoppingCartHelper.getCartList();

        // Make sure to clear the selections
        for(int i=0; i<mCartList.size(); i++)
        {
            mCartList.get(i).selected = false;
        }

        //int priceInt;
        double subTotal = 0;
        for(Product p : mCartList) {
            int quantity = ShoppingCartHelper.getProductQuantity(p);
            //priceInt = Integer.parseInt(p);
            subTotal += p.price * quantity;
        }

        TextView productPriceTextView = (TextView) findViewById(R.id.TextViewSubtotal);
        productPriceTextView.setText("Total: Rs." + subTotal);

        // Create the list
        final ListView listViewCatalog = (ListView) findViewById(R.id.ListViewCatalog);
        mProductAdapter = new ProductAdapter(mCartList, getLayoutInflater(), true);
        listViewCatalog.setAdapter(mProductAdapter);

//        listViewCatalog.setOnItemClickListener(new OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position,
//                                    long id) {
//                Intent productDetailsIntent = new Intent(getBaseContext(), ProductDetailsActivity.class);
//                Product obj = (Product)listViewCatalog.getAdapter().getItem(position);
//                int pos = obj.dishPos-1;
////                Product tempProduct = (Product) view.getSelectedItem();
////                //System.out.println(tempProduct.dishPos);
////                int tempPos = tempProduct.dishPos;
//                productDetailsIntent.putExtra(ShoppingCartHelper.PRODUCT_INDEX, pos);
////                productDetailsIntent.putExtra(ShoppingCartHelper.PRODUCT_INDEX, position);
//                startActivity(productDetailsIntent);
//            }
//        });



    }

    @Override
    protected void onResume() {
        super.onResume();

        // Refresh the data
        if(mProductAdapter != null) {
            mProductAdapter.notifyDataSetChanged();
        }
    }

    public void onClickProceedToCheckout(View view)
    {
        Intent intent = new Intent(this, UserOrderDetails.class);
        startActivity(intent);
    }

}
