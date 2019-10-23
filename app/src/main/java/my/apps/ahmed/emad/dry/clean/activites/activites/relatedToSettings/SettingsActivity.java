package my.apps.ahmed.emad.dry.clean.activites.activites.relatedToSettings;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.app.NavUtils;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import my.apps.ahmed.emad.dry.clean.R;
import my.apps.ahmed.emad.dry.clean.activites.activites.beforeHome.ChangePasswordActivity;
import my.apps.ahmed.emad.dry.clean.activites.utilites.CairoBoldTextView;

public class SettingsActivity extends AppCompatActivity {

    private AppCompatImageView arrowBackPageTwo;
    private CairoBoldTextView changePass;
    private CairoBoldTextView changeLang;
    private CairoBoldTextView termsAnd;

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        NavUtils.navigateUpFromSameTask(this);
        Animatoo.animateSwipeRight(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        initViews();
    }

    private void initViews() {
        arrowBackPageTwo = findViewById(R.id.arrow_back_page_two);
        changePass = findViewById(R.id.change_pass);
        changeLang = findViewById(R.id.change_lang);
        termsAnd = findViewById(R.id.terms_and);

        arrowBackPageTwo.setOnClickListener(v -> {
            onBackPressed();
        });

        changePass.setOnClickListener(v -> {
            startActivity(new Intent(SettingsActivity.this , ChangePasswordActivity.class));
            Animatoo.animateSlideLeft(this);
        });

        termsAnd.setOnClickListener(v -> {
            startActivity(new Intent(SettingsActivity.this , CompliantAndSuggestionsActivity.class));
            Animatoo.animateSlideLeft(this);
        });

    }
}
