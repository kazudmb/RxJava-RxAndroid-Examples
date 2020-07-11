package com.nakano.rxjava_rxandroid_examples;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.nakano.rxjava_rxandroid_examples.models.Task;
import com.nakano.rxjava_rxandroid_examples.util.DataSource;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

//    private CompositeDisposable disposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        // Incorrect Usage of distinct()
//        Observable<Task> taskObservable = Observable
//                .fromIterable(DataSource.createTasksList())
//                .distinct(new Function<Task, Task>() { // <--- WRONG
//                    @Override
//                    public Task apply(Task task) throws Exception {
//                        return task;
//                    }
//                })
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread());
//
//        taskObservable.subscribe(new Observer<Task>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//
//            }
//            @Override
//            public void onNext(Task task) {
//                Log.d(TAG, "onNext: " + task.getDescription());
//            }
//            @Override
//            public void onError(Throwable e) {
//
//            }
//            @Override
//            public void onComplete() {
//
//            }
//        });

        // Correct Usage of distinct()
        Observable<Task> taskObservable = Observable
                .fromIterable(DataSource.createTasksList())
                .distinct(new Function<Task, String>() { // <--- CORRECT
                    @Override
                    public String apply(Task task) throws Exception {
                        return task.getDescription();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        taskObservable.subscribe(new Observer<Task>() {
            @Override
            public void onSubscribe(Disposable d) {

            }
            @Override
            public void onNext(Task task) {
                Log.d(TAG, "onNext: " + task.getDescription());
            }
            @Override
            public void onError(Throwable e) {

            }
            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: called.");
        super.onDestroy();
//        disposable.clear();
    }
}