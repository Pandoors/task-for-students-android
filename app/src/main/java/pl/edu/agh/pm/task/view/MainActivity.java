package pl.edu.agh.pm.task.view;

import static android.view.View.GONE;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import pl.edu.agh.pm.task.Contract;
import pl.edu.agh.pm.task.R;
import pl.edu.agh.pm.task.model.Model;
import pl.edu.agh.pm.task.presenter.Presenter;

public class MainActivity extends AppCompatActivity implements Contract.View {

    private TextView textView;

    private Button button;

    private ProgressBar progressBar;

    Contract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textViewWithCuriosity);

        button = findViewById(R.id.button);

        progressBar = findViewById(R.id.progressBar);

        presenter = new Presenter(this, new Model());

        button.setOnClickListener(v -> presenter.onButtonClick());
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        textView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(GONE);
        textView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setString(String string) {
        textView.setText(string);
    }
}