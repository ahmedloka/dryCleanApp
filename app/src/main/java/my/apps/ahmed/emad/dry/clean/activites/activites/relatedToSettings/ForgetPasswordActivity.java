package my.apps.ahmed.emad.dry.clean.activites.activites.relatedToSettings;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import my.apps.ahmed.emad.dry.clean.R;
import my.apps.ahmed.emad.dry.clean.activites.activites.beforeHome.VerficationActivity;
import my.apps.ahmed.emad.dry.clean.activites.utilites.CairoBoldButton;

public class ForgetPasswordActivity extends AppCompatActivity {

    private CairoBoldButton resetPassword;

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Animatoo.animateSwipeRight(this);
        NavUtils.navigateUpFromSameTask(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        initViews();
    }

    private void initViews() {
        resetPassword = findViewById(R.id.reset_password);
        resetPassword.setOnClickListener(v -> {
            startActivity(new Intent(ForgetPasswordActivity.this, VerficationActivity.class));
            Animatoo.animateSwipeRight(this);
        });

    }
}
