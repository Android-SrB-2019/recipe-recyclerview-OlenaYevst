package com.example.olena.recipe;


//This assignment was done by Olena
//Date: 2019-03-21


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class recipeIntent extends AppCompatActivity {

    TextView name;
    TextView directions;
    TextView ingridients;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_intent);

        name = (TextView)findViewById(R.id.name);
        directions = (TextView)findViewById(R.id.directions);
        ingridients = (TextView)findViewById(R.id.ingridients);
        image = (ImageView)findViewById(R.id.img);
        Recipe r;
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            r = (Recipe) extras.getSerializable("RECIEPE");
            name.setText(r.name);
            directions.setText("Directions: \n" + r.directions);
            ingridients.setText("Ingridients: \n" + r.ingredients);
            Picasso.get()
                    .load(r.image)
                    .fit()
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .into(image);
        }
    }
}
