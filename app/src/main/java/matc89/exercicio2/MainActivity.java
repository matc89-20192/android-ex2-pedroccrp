package matc89.exercicio2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final int USERNAME_INTENT_CODE = 2;

    private TextView textView = null;
    private Button btnTrocar = null;

    private String displayString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);
        btnTrocar = (Button)findViewById(R.id.btnTrocar);
    }

    public void changeToOutraActivity(View v) {
        Intent intent = new Intent(this, OutraActivity.class);

        startActivityForResult(intent, USERNAME_INTENT_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data == null) {
            return;
        }

        if (requestCode == USERNAME_INTENT_CODE) {
            String username = data.getStringExtra("USERNAME");

            if (username.isEmpty()) {
                displayString = "Oi!";
            }
            else {
                displayString = "Oi, " + username + "!";
            }

            textView.setText(displayString);
        }
    }
}
