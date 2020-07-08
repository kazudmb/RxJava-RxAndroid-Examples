package com.nakano.rxjava_rxandroid_examples;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.nakano.rxjava_rxandroid_examples.models.Task;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

//    private CompositeDisposable disposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Task[] list = new Task[5];
//        list[0] = (new Task("Take out the trash", true, 3));
//        list[1] = (new Task("Walk the dog", false, 2));
//        list[2] = (new Task("Make my bed", true, 1));
//        list[3] = (new Task("Unload the dishwasher", false, 0));
//        list[4] = (new Task("Make dinner", true, 5));
//
//        Observable<Task> taskObservable = Observable
//                .fromArray(list)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread());
//
//        taskObservable.subscribe(new Observer<Task>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//                Log.d(TAG, "onSubscribe: called");
//            }
//
//            @Override
//            public void onNext(Task task) {
//                Log.d(TAG, "onNext: : " + task.getDescription());
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.e(TAG, "onError: ", e);
//            }
//
//            @Override
//            public void onComplete() {
//                Log.d(TAG, "onComplete: done...");
//            }
//        });

        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task("Take out the trash", true, 3));
        taskList.add(new Task("Walk the dog", false, 2));
        taskList.add(new Task("Make my bed", true, 1));
        taskList.add(new Task("Unload the dishwasher", false, 0));
        taskList.add(new Task("Make dinner", true, 5));

        Observable<Task> taskObservable = Observable
                .fromIterable(taskList)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        taskObservable.subscribe(new Observer<Task>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Task task) {
                Log.d(TAG, "onNext: : " + task.getDescription());
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