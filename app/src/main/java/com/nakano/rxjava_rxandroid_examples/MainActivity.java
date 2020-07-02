package com.nakano.rxjava_rxandroid_examples;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

//    private CompositeDisposable disposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Observable<Task> taskObservable = Observable // create a new Observable object
//                .fromIterable(DataSource.createTasksList()) // apply 'fromIterable' operator
//                .subscribeOn(Schedulers.io()) // designate worker thread (background)
//                .filter(new Predicate<Task>() {
//                    @Override
//                    public boolean test(Task task) throws Exception {
//                        Log.d(TAG, "test: " + Thread.currentThread().getName());
//                        try {
//                            Thread.sleep(1000);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        return task.isComplete();
//                    }
//                })
//                .observeOn(AndroidSchedulers.mainThread()); // designate observer thread (main thread)
//
//        taskObservable.subscribe(new Observer<Task>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//                Log.d(TAG, "onSubscribe: called.");
//                disposable.add(d);
//            }
//
//            @Override
//            public void onNext(Task task) { // run on main thread
//                Log.d(TAG, "onNext: : " + Thread.currentThread().getName());
//                Log.d(TAG, "onNext: : " + task.getDescription());
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.e(TAG, "onError: called.", e);
//            }
//
//            @Override
//            public void onComplete() {
//                Log.d(TAG, "onComplete: called.");
//            }
//        });

//        // Instantiate the object to become an Observable
//        final Task task = new Task("Walk the dog", false, 4);
//
//        // Create the Observable
//        Observable<Task> singleTaskObservable = Observable
//                .create(new ObservableOnSubscribe<Task>() {
//                    @Override
//                    public void subscribe(ObservableEmitter<Task> emitter) throws Exception {
//                        if(!emitter.isDisposed()){
//                            emitter.onNext(task);
//                            emitter.onComplete();
//                        }
//                    }
//                })
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread());
//
//        // Subscribe to the Observable and get the emitted object
//        singleTaskObservable.subscribe(new Observer<Task>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//                Log.d(TAG, "onSubscribe: called.");
//            }
//
//            @Override
//            public void onNext(Task task) { // run on main thread
//                Log.d(TAG, "onNext: : " + Thread.currentThread().getName());
//                Log.d(TAG, "onNext: single task: " + task.getDescription());
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.e(TAG, "onError: called.", e);
//            }
//
//            @Override
//            public void onComplete() {
//                Log.d(TAG, "onComplete: called.");
//            }
//        });

//        // Create the Observable
//        Observable<Task> taskListObservable = Observable
//                .create(new ObservableOnSubscribe<Task>() {
//                    @Override
//                    public void subscribe(ObservableEmitter<Task> emitter) throws Exception {
//
//                        // Inside the subscribe method iterate through the list of tasks and call onNext(task)
//                        for(Task task: DataSource.createTasksList()){
//                            if(!emitter.isDisposed()){
//                                emitter.onNext(task);
//                            }
//                        }
//                        // Once the loop is complete, call the onComplete() method
//                        if(!emitter.isDisposed()){
//                            emitter.onComplete();
//                        }
//
//                    }
//                })
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread());
//
//        // Subscribe to the Observable and get the emitted objects
//        taskListObservable.subscribe(new Observer<Task>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//                Log.d(TAG, "onSubscribe: called.");
//            }
//
//            @Override
//            public void onNext(Task task) { // run on main thread
//                Log.d(TAG, "onNext: : " + Thread.currentThread().getName());
//                Log.d(TAG, "onNext: task list: " + task.getDescription());
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.e(TAG, "onError: called.", e);
//            }
//
//            @Override
//            public void onComplete() {
//                Log.d(TAG, "onComplete: called.");
//            }
//        });

//        Observable.just("first", "second", "third", "fourth", "fifth", "sixth",
//                "seventh", "eighth", "ninth", "tenth")
//                .subscribeOn(Schedulers.io()) // What thread to do the work on
//                .observeOn(AndroidSchedulers.mainThread()) // What thread to observe the results on
//                .subscribe(new Observer<String>() { // view the results by creating a new observer
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "onSubscribe: called");
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//                        Log.d(TAG, "onNext: " + s);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.e(TAG, "onError: ", e);
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "onComplete: done...");
//                    }
//                });

//        Observable.range(0,11)
//                .observeOn(Schedulers.io())
//                .subscribeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<Integer>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "onSubscribe: called");
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "onNext: " + integer);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.e(TAG, "onError: ", e);
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "onComplete: done...");
//                    }
//                });

//        Observable.range(0,3)
//                .repeat(2)
//                .observeOn(Schedulers.io())
//                .subscribeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<Integer>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "onSubscribe: called");
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "onNext: " + integer);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.e(TAG, "onError: ", e);
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "onComplete: done...");
//                    }
//                });
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: called.");
        super.onDestroy();
//        disposable.clear();
    }
}