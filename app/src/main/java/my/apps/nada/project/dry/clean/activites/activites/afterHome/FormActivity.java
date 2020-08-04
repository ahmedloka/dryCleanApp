package my.apps.nada.project.dry.clean.activites.activites.afterHome;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import my.apps.nada.project.dry.clean.R;

public class FormActivity extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        NavUtils.navigateUpFromSameTask(this);
        Animatoo.animateSlideDown(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
    }
}
