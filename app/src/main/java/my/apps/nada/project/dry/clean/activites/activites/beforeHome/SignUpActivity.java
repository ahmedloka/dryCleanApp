package my.apps.nada.project.dry.clean.activites.activites.beforeHome;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import my.apps.nada.project.dry.clean.R;
import my.apps.nada.project.dry.clean.activites.utilites.CairoBoldButton;

public class SignUpActivity extends AppCompatActivity {
    private CairoBoldButton btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        initViews();
    }

    private void initViews() {

        btnRegister = findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(v -> {
            startActivity(new Intent(SignUpActivity.this, VerficationActivity.class));
            Animatoo.animateSwipeLeft(this);
        });

    }
}
