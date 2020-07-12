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

//        Observable<String> extractDescriptionObservable = Observable
//                .fromIterable(DataSource.createTasksList())
//                .subscribeOn(Schedulers.io())
//                .map(extractDescriptionFunction)
//                .observeOn(AndroidSchedulers.mainThread());
//
//        extractDescriptionObservable.subscribe(new Observer<String>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//            }
//            @Override
//            public void onNext(String s) {
//                Log.d(TAG, "onNext: extracted description: " + s);
//            }
//            @Override
//            public void onError(Throwable e) {
//            }
//            @Override
//            public void onComplete() {
//            }
//        });

//        Observable<String> extractDescriptionObservable = Observable
//                .fromIterable(DataSource.createTasksList())
//                .subscribeOn(Schedulers.io())
//                .map(extractDescriptionFunction)
//                .observeOn(AndroidSchedulers.mainThread());
//
//        extractDescriptionObservable.subscribe(new Observer<String>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//            }
//            @Override
//            public void onNext(String s) {
//                Log.d(TAG, "onNext: extracted description: " + s);
//            }
//            @Override
//            public void onError(Throwable e) {
//            }
//            @Override
//            public void onComplete() {
//            }
//        });

        Observable<Task> mappedObservable = Observable
                .fromIterable(DataSource.createTasksList())
                .subscribeOn(Schedulers.io())
                .map(new Function<Task, Task>() {
                    @Override
                    public Task apply(Task task) throws Exception {
                        task.setComplete(true);
                        return task;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread());

        // subscribe to the Observable and view the emitted results
        mappedObservable.subscribe(new Observer<Task>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Task task) {
                Log.d(TAG, "onNext: mapped: " + task.getDescription());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

//    Function<Task, String> extractDescriptionFunction = new Function<Task, String>() {
//        @Override
//        public String apply(Task task) throws Exception {
//            Log.d(TAG, "apply: doing work on thread: " + Thread.currentThread().getName());
//            return task.getDescription();
//        }
//    };

//    Function<Task, String> extractDescriptionFunction = new Function<Task, String>() {
//        @Override
//        public String apply(Task task) throws Exception {
//            Log.d(TAG, "apply: doing work on thread: " + Thread.currentThread().getName());
//            return task.getDescription();
//        }
//    };



    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: called.");
        super.onDestroy();
//        disposable.clear();
    }
}