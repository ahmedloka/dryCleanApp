package my.apps.ahmed.emad.dry.clean.activites.activites.relatedToSettings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.app.NavUtils;

import my.apps.ahmed.emad.dry.clean.R;

import android.os.Bundle;
import android.view.View;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

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
