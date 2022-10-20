package dev.mah.labo2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ExerciceActivity extends AppCompatActivity implements AddExerciceDialog.CrudExerciceDialogListener {

    private ArrayList<Exercice> exerciceArrayList;
    private ExerciceAdapter exerciceAdapter;
    private RecyclerView exercicesRV;
    private DBHelper dbHelper;
    private TextView tvTitle;
    FloatingActionButton fab;
    String idCateg, titreCateg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice);
        setTitle("EXERCICE");
        init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.adExercice:
                addExercice();
                return true;
            case R.id.adQuitter:
                this.finishAffinity();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void init() {
        tvTitle = findViewById(R.id.tvTitle);

        // getting data which we passed in our adapter class.
        idCateg = getIntent().getStringExtra("idCateg");
        titreCateg = getIntent().getStringExtra("titreCateg");

        // edit text fields of our update activity.
        tvTitle.setText(titreCateg);
        exerciceArrayList = new ArrayList<>();
        dbHelper = new DBHelper(ExerciceActivity.this);

        exerciceArrayList = dbHelper.listExercicesParCategorie(idCateg);

        exerciceAdapter = new ExerciceAdapter(exerciceArrayList, ExerciceActivity.this);
        exercicesRV = findViewById(R.id.exerciceList);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ExerciceActivity.this, RecyclerView.VERTICAL, false);
        exercicesRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        exercicesRV.setAdapter(exerciceAdapter);
        fab = findViewById(R.id.fabAddExercice);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addExercice() ;

            }
        });
    }

    private void addExercice() {
        AddExerciceDialog dialog= new AddExerciceDialog();
        dialog.show(getSupportFragmentManager(),"add_voyage_dialog");
    }
    @Override
    public void addExercice(String title, String image, String time, String repeat, String categ, String description, String video) {

        Exercice exercice = new Exercice(title, image, time, repeat, categ, description, video);
        exerciceArrayList.add(exercice);
        dbHelper.addNewExercice(title, image, time, repeat, categ, description, video);

        exerciceAdapter = new ExerciceAdapter(exerciceArrayList, ExerciceActivity.this);
        exercicesRV = findViewById(R.id.exerciceList);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ExerciceActivity.this, RecyclerView.VERTICAL, false);
        exercicesRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        exercicesRV.setAdapter(exerciceAdapter);

        Toast.makeText(ExerciceActivity.this, "un nouveau exrcice est ajoute", Toast.LENGTH_SHORT).show();
    }

}