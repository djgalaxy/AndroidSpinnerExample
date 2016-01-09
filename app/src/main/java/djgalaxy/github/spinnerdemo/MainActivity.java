package djgalaxy.github.spinnerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String[] PIZZA = {"Cheese", "Veggie", "Pepperoni", "Sausage"};
    private static final String[] CRUST = {"Regular", "Thin", "DeepDish"};
    private static final Integer[] QUANTITY = {1, 2, 3, 4, 5};
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button orderBtn = (Button) findViewById(R.id.orderBtn);

        final Spinner pizzaSpinner = (Spinner) findViewById(R.id.pizzaSpinner);
        final Spinner crustSpinner = (Spinner) findViewById(R.id.crustSpinner);
        final Spinner quantitySpinner = (Spinner) findViewById(R.id.quantitySpinner);

        // Creating and setting an adapter for pizzaSpinner.
        ArrayAdapter<String> pizzaAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, PIZZA);
        pizzaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pizzaSpinner.setAdapter(pizzaAdapter);

        // Creating and setting an adapter for crustSpinner.
        ArrayAdapter<String> crustAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, CRUST);
        crustAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        crustSpinner.setAdapter(crustAdapter);

        // Creating and setting an adapter for quantitySpinner.
        ArrayAdapter<Integer> quantityAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, QUANTITY);
        quantityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        quantitySpinner.setAdapter(quantityAdapter);

        pizzaSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            // Callback method to be invoked when an item in this view has been selected. This callback is invoked only when the newly selected position is different from the previously selected position or if there was no selected item.
            // Implementers can call getItemAtPosition(position) if they need to access the data associated with the selected item.
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "Pizza: " + PIZZA[position] + " ID: " + id);
            }
            
            // Callback method to be invoked when the selection disappears from this view. The selection can disappear for instance when touch is activated or when the adapter becomes empty.
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.d(TAG, "Pizza Not Selected!");
            }
        });

        crustSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            // Callback method to be invoked when an item in this view has been selected. This callback is invoked only when the newly selected position is different from the previously selected position or if there was no selected item.
            // Implementers can call getItemAtPosition(position) if they need to access the data associated with the selected item.
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "Crust: " + CRUST[position] + " ID: " + id);
            }

            // Callback method to be invoked when the selection disappears from this view. The selection can disappear for instance when touch is activated or when the adapter becomes empty.
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.d(TAG, "Crust Not Selected!");
            }

        });

        quantitySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            // Callback method to be invoked when an item in this view has been selected. This callback is invoked only when the newly selected position is different from the previously selected position or if there was no selected item.
            // Implementers can call getItemAtPosition(position) if they need to access the data associated with the selected item.
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "Quantity " + QUANTITY[position] + " ID: " + id);
            }

            // Callback method to be invoked when the selection disappears from this view. The selection can disappear for instance when touch is activated or when the adapter becomes empty.
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.d(TAG, "Quantity Not Selected!");
            }
        });

        orderBtn.setOnClickListener(new View.OnClickListener() {

            // Called when this view has been clicked.
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, quantitySpinner.getSelectedItem() + " " + pizzaSpinner.getSelectedItem() + " " + crustSpinner.getSelectedItem() + " Pizza Ordered!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
