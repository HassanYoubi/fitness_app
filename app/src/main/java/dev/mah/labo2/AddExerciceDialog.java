package dev.mah.labo2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;

public class AddExerciceDialog extends DialogFragment {
    private EditText edtTitle, edtTime, edtRepeat, edtDesc, edtVideo;
    private Spinner spCateg;
    private ImageView imgExercice;
    private DBHelper dbHelper;
    private ArrayList<Categorie> categorieArrayList;
    String categorie;

    private CrudExerciceDialogListener listener;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        dbHelper = new DBHelper(getContext());
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());


        // Get the layout inflater
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view =inflater.inflate(R.layout.add_exercice_dialog, null);


        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(view)
                .setTitle("Ajouter un exercice")
                // Add action buttons
                .setPositiveButton("Ajouter", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        //int code = Integer.parseInt(edtCode.getText().toString());
                        String title = edtTitle.getText().toString();
                        //String image = imgExercice.getDrawable().toString();
                        String image = "ic_launcher_background";
                        String time = edtTime.getText().toString();
                        String repeat = edtRepeat.getText().toString();
                        String categ = String.valueOf(spCateg.getSelectedItemId());
                        String description = edtDesc.getText().toString();
                        String video = edtVideo.getText().toString();

                        loadSpCategories();

                        listener.addExercice(title, image, time, repeat, categ, description, video);

                    }
                })
                .setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });

        edtTitle = view.findViewById(R.id.edtTitle);
        imgExercice = view.findViewById(R.id.imgExercice);
        edtTime = view.findViewById(R.id.edtTime);
        edtRepeat = view.findViewById(R.id.edtRepeat);
        spCateg = view.findViewById(R.id.spCateg);
        edtDesc = view.findViewById(R.id.edtDesc);
        edtVideo = view.findViewById(R.id.edtVideo);

        loadSpCategories();

        return builder.create();
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (CrudExerciceDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "must implement ExampleDialogListener");
        }
    }

    public interface CrudExerciceDialogListener {
        void addExercice(String title, String image, String time, String repeat, String categ, String description, String video);
    }

    public void loadSpCategories() {
        /*
        categorieArrayList = dbHelper.listCategories();
        ArrayAdapter<Categorie> arrayAdapter =
                new ArrayAdapter<Categorie>(getActivity(),  android.R.layout.simple_spinner_dropdown_item, categorieArrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCateg.setAdapter(arrayAdapter);
        */
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getActivity(),
                R.array.categorie_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spCateg.setAdapter(adapter2);

        spCateg.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i>0 )
                {
                    categorie = adapterView.getItemAtPosition(i).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

}
