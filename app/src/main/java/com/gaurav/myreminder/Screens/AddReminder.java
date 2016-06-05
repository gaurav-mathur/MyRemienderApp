package com.gaurav.myreminder.Screens;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.gaurav.myreminder.R;

public class AddReminder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reminder);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Array of choices
        String colors[] = {"Automobile","Electronics","Home Appliances"};

// Selection of the spinner
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

// Application of the Array to the Spinner
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this,   android.R.layout.simple_spinner_item, colors);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        spinner.setAdapter(spinnerArrayAdapter);

        String colors1[] = {"3 Months","6 Months","1 Year","2 Year","3 Year","4 Year","5 Year" };

// Selection of the spinner
        Spinner spinner1 = (Spinner) findViewById(R.id.spinner_warranty);

// Application of the Array to the Spinner
        ArrayAdapter<String> spinnerArrayAdapter1 = new ArrayAdapter<String>(this,   android.R.layout.simple_spinner_item, colors1);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        spinner1.setAdapter(spinnerArrayAdapter1);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}
