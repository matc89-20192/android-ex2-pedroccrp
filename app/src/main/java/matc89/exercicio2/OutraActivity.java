package matc89.exercicio2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class OutraActivity extends AppCompatActivity {

    private EditText editText = null;
    private Button btnConfirm = null;
    private Button btnCancel = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_outra);

        editText = (EditText)findViewById(R.id.editText);
        btnConfirm = (Button)findViewById(R.id.btnConfirmar);
        btnCancel = (Button)findViewById(R.id.btnCancelar);

        String username = getIntent().getExtras().getString("USERNAME");

        if (username == null) {
            username = "";
        }

        editText.setText(username);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences((this));
    }

    public void onBtnConfirm(View v) {
        Intent intent = new Intent();
        intent.putExtra("USERNAME", editText.getText().toString());

        setResult(MainActivity.USERNAME_INTENT_CODE, intent);
        finish();
    }

    public void onBtnCancel(View v) {
        finish();
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("editText", editText.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        String text = savedInstanceState.getString("editText");
        editText.setText(text);
    }
}
