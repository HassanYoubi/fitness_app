package dev.mah.labo2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class DetailActivity extends AppCompatActivity {

    private Exercice exercice;
    private ExerciceAdapter exerciceAdapter;
   // private RecyclerView exercicesRV;
    private DBHelper dbHelper;
    private TextView tvTitle, tvTime, tvRepeat, tvDesc;
    private Button btnUpdate, btnDelete;
    String idExercice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setTitle("DÉTAILS");
        init();
        listeners();
    }

    public void init() {
        tvTitle = findViewById(R.id.tvTitle);
        tvTime = findViewById(R.id.tvTime);
        tvRepeat = findViewById(R.id.tvRepeat);
        tvDesc = findViewById(R.id.tvDesc);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);

        dbHelper = new DBHelper(DetailActivity.this);

        // getting data which we passed in our adapter class.
        idExercice = getIntent().getStringExtra("idExercice");

        dbHelper = new DBHelper(DetailActivity.this);

        exercice = dbHelper.rechercherUnExercices(idExercice);

        tvTitle.setText(exercice.getTitle());
        tvTime.setText(exercice.getTime());
        tvRepeat.setText(exercice.getRepeat());
        tvDesc.setText(exercice.getDescription());

        YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);

        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = exercice.getVideo();
                youTubePlayer.cueVideo(videoId, 0);
                youTubePlayer.loadVideo(videoId, 0);
            }
        });
    }

    public void listeners() {
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), UpdateExerciceActivity.class);
                i.putExtra("idExercice", idExercice);
                startActivity(i);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.deleteExercice(idExercice);
                Toast.makeText(DetailActivity.this, "Exercice supprime", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(DetailActivity.this, MainActivity.class);
                i.putExtra("idExercice", idExercice);
                startActivity(i);
            }
        });
    }

}