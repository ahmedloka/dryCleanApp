package my.apps.nada.project.dry.clean.activites.activites.relatedToSettings;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.app.NavUtils;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import my.apps.nada.project.dry.clean.R;

public class CompliantAndSuggestionsActivity extends AppCompatActivity {


    private AppCompatImageView arrowBackPageTwo;

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        NavUtils.navigateUpFromSameTask(this);
        Animatoo.animateSlideRight(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complian_and_suggestions);

        initViews();
    }

    private void initViews() {

        arrowBackPageTwo = findViewById(R.id.arrow_back_page_two);
        arrowBackPageTwo.setOnClickListener(v -> {
            onBackPressed();
        });
    }
}
