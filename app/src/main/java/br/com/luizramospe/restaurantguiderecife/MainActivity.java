package br.com.luizramospe.restaurantguiderecife;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.luizramospe.restaurantguiderecife.utils.TextHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init the Categories GridView
        initCatGridView();
    }

    // MARK: - SHOW CATEGORIES
    void initCatGridView() {

        // ARRAY COM AS ESPECIALIDADE
        final String[] restaurantList = getResources().getStringArray(R.array.string_array_restaurant_specialities);

        final List<String> restaurantSpecialtiesArray = new ArrayList<>(Arrays.asList(restaurantList));
        final List<String> specialityImages = new ArrayList<>();

        specialityImages.add("regional_cuisine");
        specialityImages.add("fish_and_seafood");
        specialityImages.add("delicious_appetizers");
        specialityImages.add("hot_broth");
        specialityImages.add("pizzeria");
        specialityImages.add("brazilian_cachaca");
        specialityImages.add("special_beers");


        GridView aGrid = (GridView) findViewById(R.id.catGridView);
        aGrid.setAdapter(new SpecialityAdapter(MainActivity.this, restaurantSpecialtiesArray, specialityImages));

//        int columns = getResources().getInteger(R.integer.columns);
        int columns = getNumberOfColumns();
        aGrid.setNumColumns(columns);

        aGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Intent i = new Intent(MainActivity.this, RestaurantListByCategoryActivity.class);
                Bundle extras = new Bundle();
                extras.putString("specialityName", restaurantSpecialtiesArray.get(position));
                i.putExtras(extras);
                startActivity(i);
            }});

    }

    private int getNumberOfColumns(){
        float scalefactor = getResources().getDisplayMetrics().density * 120;
        int number = getWindowManager().getDefaultDisplay().getWidth();
        int columns = (int) ((float) number / (float) scalefactor);
        return columns;
    }
}
