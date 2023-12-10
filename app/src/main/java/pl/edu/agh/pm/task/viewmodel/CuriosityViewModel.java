package pl.edu.agh.pm.task.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import android.os.Handler;
import android.os.Looper;


import pl.edu.agh.pm.task.model.Model;

public class CuriosityViewModel extends ViewModel {

    private final Model model = new Model();

    private final MutableLiveData<String> modelData = new MutableLiveData<>();
    private final MutableLiveData<Boolean> isLoading = new MutableLiveData<>();

    public void onButtonClick() {
        isLoading.setValue(true);
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            updateCuriosity();
            isLoading.setValue(false);
        }, 1200);
    }

    private void updateCuriosity() {
        String curiosity = model.getRandomCuriosity();
        modelData.postValue(curiosity);
    }

    public MutableLiveData<String> getCuriosityBinding() {
        return modelData;
    }

    public MutableLiveData<Boolean> getIsLoading() {
        return isLoading;
    }
}
