package com.example.protichi.hestia_first;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


public class EmployeeList extends ListActivity {

    private static final String TAG = EmployeeList.class.getSimpleName();

    protected EditText searchText;
    protected SQLiteDatabase db;
    protected Cursor cursor;
    protected ListAdapter adapter;
    public String nameOfItemSelected;
    public String identityNumber;

    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "EMPLOYEE LIST ONCREATE");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main1);
        searchText = (EditText) findViewById(R.id.searchText);
        Log.d(TAG, "EMPLOYEE LIST ONCREATE 11111");
        db = (new DatabaseHelper(this)).getWritableDatabase();
        Log.d(TAG, "EMPLOYEE LIST ONCREATE 22");

        Log.d(TAG,"SEARCH TEXT: " + searchText.getText());

        Log.d(TAG, "EMPLOYEE LIST SEARCH BUTTON CLICKED");
        cursor = db.rawQuery("SELECT _id, firstName, lastName, title, indexNumber FROM employee WHERE firstName || ' ' || lastName LIKE ?",
                new String[]{"%" + searchText.getText().toString() + "%"});
        adapter = new SimpleCursorAdapter(
                this,
                R.layout.activity_employee_list,
                cursor,
                new String[] {"firstName", "lastName", "title"},
                new int[] {R.id.firstName, R.id.lastName, R.id.title});
        setListAdapter(adapter);
        nameOfItemSelected = searchText.getText().toString();
        Log.d(TAG, "firstName in function onSearch of employee list  " + nameOfItemSelected);
    }

    public void onListItemClick(ListView parent, View view, int position, long id) {
       /* Log.d(TAG, "EMPLOYEE LIST ONCLICKLISTENER");
        Intent intent = new Intent(this, EmployeeDetails.class);
        Cursor cursor = (Cursor) adapter.getItem(position);
        intent.putExtra("EMPLOYEE_ID", cursor.getInt(cursor.getColumnIndex("_id")));
        startActivity(intent);*/
        Intent intent =  new Intent(this, ProductDetailsActivity.class);
        intent.putExtra("methodName","getDetails");
        intent.putExtra("itemName", nameOfItemSelected);
        /*intent.putExtra("id",identityNumber);*/
        Cursor cursor = (Cursor) adapter.getItem(position);
        intent.putExtra("id", cursor.getString(cursor.getColumnIndex("indexNumber")));
        Log.e(TAG, "EMPLOYEE LIST ONCLICKLISTENER value of id" + cursor.getInt(cursor.getColumnIndex("indexNumber")));
        startActivity(intent);
    }

    public void onSearch(View view) {
        Log.d(TAG, "EMPLOYEE LIST SEARCH BUTTON CLICKED");
        // || is the concatenation operation in SQLite
        Log.d(TAG, "EMPLOYEE LIST SEARCH BUTTON CLICKED");
        cursor = db.rawQuery("SELECT _id, firstName, lastName, title, officePhone, indexNumber FROM employee WHERE firstName || ' ' || lastName LIKE ?",
                new String[]{"%" + searchText.getText().toString() + "%"});
        adapter = new SimpleCursorAdapter(
                this,
                R.layout.activity_employee_list,
                cursor,
                new String[] {"firstName", "lastName", "title", "officePhone"},
                new int[] {R.id.firstName, R.id.lastName, R.id.title, R.id.price});
        setListAdapter(adapter);
        nameOfItemSelected = searchText.getText().toString();

        //get all values
        /*if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                identityNumber = cursor.getString(cursor.getColumnIndex("indexNumber"));
               Log.e(TAG, "selected Index Number is" + identityNumber);
                cursor.moveToNext();
            }
        }*/
        }

    public void onActionButtonClick(View view)
    {
        Intent intent = new Intent(this, ShoppingCartActivity.class);
        startActivity(intent);
    }

}
