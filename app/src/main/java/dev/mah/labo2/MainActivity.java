package dev.mah.labo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Categorie> categorieArrayList;
    private DBHelper dbHelper;
    private GridView gridView;
    FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("CATEGORIE");
        setContentView(R.layout.activity_main);
        init();
        loadGridView(categorieArrayList);
    }

    public void init() {

        gridView=findViewById(R.id.gridView);
        dbHelper = new DBHelper(MainActivity.this);
        categorieArrayList = dbHelper.listCategories();
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                displaySnackBar(view, "choisissez un email provider");
                sendEmail();

            }
        });

    }

    public void loadGridView(ArrayList<Categorie> listCategories){

        CustomAdapter adapter=new CustomAdapter(this,listCategories);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                startExerciceActivity(listCategories.get(position));

            }
        });

    }

    private  void startExerciceActivity(Categorie categorie)
    {
        Intent i = new Intent(MainActivity.this, ExerciceActivity.class);
        i.putExtra("idCateg", categorie.getId());
        i.putExtra("titreCateg", categorie.getTitle());
        startActivity(i);
    }
    private void sendEmail()
    {
        String to="ibrh4@hotmail.com";
        String subject="Plan d'entrainement";
        String message="bienvenue dans notre application de gyn";


        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
        email.putExtra(Intent.EXTRA_SUBJECT, subject);
        email.putExtra(Intent.EXTRA_TEXT, message);

        //need this to prompts email client only
        email.setType("message/rfc822");

        startActivity(Intent.createChooser(email, "Choose an Email client :"));
    }


    private void displaySnackBar(View view,String message)
    {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).setAction("Action", null).show();
    }
    private  void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,Toast.LENGTH_SHORT).show();
    }


}