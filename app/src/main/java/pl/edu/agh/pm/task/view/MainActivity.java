package pl.edu.agh.pm.task.view;

import static android.view.View.GONE;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.view.View;
import pl.edu.agh.pm.task.R;
import pl.edu.agh.pm.task.databinding.ActivityMainBinding;
import pl.edu.agh.pm.task.viewmodel.CuriosityViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private CuriosityViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        binding.button.setOnClickListener(v -> model.onButtonClick());
        setContentView(binding.getRoot());

        model = new ViewModelProvider(this).get(CuriosityViewModel.class);
        model.getIsLoading().observe(this, isLoading -> {
            if (isLoading) {
                showProgress();
            } else {
                hideProgress();
            }
        });
        model.getCuriosityBinding().observe(this, curiosity -> {
            if (curiosity != null) {
                binding.textViewWithCuriosity.setText(curiosity);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void showProgress() {
        binding.progressBar.setVisibility(View.VISIBLE);
        binding.textView.setVisibility(View.INVISIBLE);
    }

    private void hideProgress() {
        binding.progressBar.setVisibility(GONE);
        binding.textView.setVisibility(View.VISIBLE);
    }
}