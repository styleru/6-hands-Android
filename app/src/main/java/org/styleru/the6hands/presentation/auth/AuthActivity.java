package org.styleru.the6hands.presentation.auth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.styleru.the6hands.R;

public class AuthActivity extends AppCompatActivity {
    private Button authButton;
    private Button missButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        authButton = findViewById(R.id.vk_auth_button);
        missButton = findViewById(R.id.miss_button);
        authButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        missButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });

    }
}
