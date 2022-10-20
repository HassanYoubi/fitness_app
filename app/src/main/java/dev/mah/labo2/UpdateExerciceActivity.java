package dev.mah.labo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateExerciceActivity extends AppCompatActivity {

    private Exercice exercice;
    private DBHelper dbHelper;
    private TextView edtTitle, edtTime, edtRepeat, edtDesc, edtLink;
    private Spinner spCateg;
    private Button btnUpdate;
    private ImageView imgExercice;
    String idExercice, categorie, image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_exercice);
        setTitle("MODIFIER EXERCICE");
        init();
        listeners();
    }

    public void init() {
        edtTitle = findViewById(R.id.edtTitle);
        imgExercice = findViewById(R.id.imgExercice);
        edtTime = findViewById(R.id.edtTime);
        edtRepeat = findViewById(R.id.edtRepeat);
        spCateg = findViewById(R.id.spCateg);
        loadSpCategories();
        edtDesc = findViewById(R.id.edtDesc);
        edtLink = findViewById(R.id.edtLink);
        btnUpdate = findViewById(R.id.btnUpdate);

        dbHelper = new DBHelper(UpdateExerciceActivity.this);

        // getting data which we passed in our adapter class.
        idExercice = getIntent().getStringExtra("idExercice");

        dbHelper = new DBHelper(UpdateExerciceActivity.this);

        exercice = dbHelper.rechercherUnExercices(idExercice);

        edtTitle.setText(exercice.getTitle());
        image = exercice.getImage();
        Context context = imgExercice.getContext();
        int imageResource = context.getResources().getIdentifier(exercice.getImage(), "drawable", context.getPackageName());
        imgExercice.setImageResource(imageResource);
        edtTime.setText(exercice.getTime());
        edtRepeat.setText(exercice.getRepeat());
        spCateg.setSelection(Integer.parseInt(exercice.getCateg()));
        edtDesc.setText(exercice.getDescription());
        edtLink.setText(exercice.getVideo());

    }

    public void listeners() {
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadSpCategories();
                String titre = edtTitle.getText().toString();
                String time = edtTime.getText().toString();
                String repeat = edtRepeat.getText().toString();
                loadSpCategories();
                String desc = edtDesc.getText().toString();
                String link = edtLink.getText().toString();
                dbHelper.updateExercice(idExercice, titre, image, time, repeat, categorie, desc, link);
                Toast.makeText(UpdateExerciceActivity.this, "Exercice modifie", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(UpdateExerciceActivity.this, DetailActivity.class);
                i.putExtra("idExercice", idExercice);
                startActivity(i);
            }
        });
    }

    public void loadSpCategories()
    {
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(UpdateExerciceActivity.this,
                R.array.categorie_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spCateg.setAdapter(adapter2);

        spCateg.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i>0 )
                {
                    categorie = String.valueOf(adapterView.getItemIdAtPosition(i));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

}