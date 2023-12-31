package pl.edu.agh.pm.task;

public interface Contract {
    interface View {

        void showProgress();


        void hideProgress();

        void setString(String string);
    }

    interface Model {

        interface OnFinishedListener {

            void onFinished(String string);
        }

        void getNextCuriosity(Contract.Model.OnFinishedListener onFinishedListener);
    }

    interface Presenter {


        void onButtonClick();


        void onDestroy();
    }
}
