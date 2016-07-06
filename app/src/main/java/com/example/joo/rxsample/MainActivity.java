package com.example.joo.rxsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Observable<String> observable = Observable.just("Hello World");
        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Log.d("RxTest", s);
            }
        };
        observable.subscribe(subscriber);

        Action1<String> onNextAction = new Action1<String>() {
            @Override
            public void call(String s) {
                Log.d("RxTestAction1", s + "Action1");
            }
        };
        observable.subscribe(onNextAction);

        Observable.just("Hello Rx").subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.d("Rx Shorten Code", "Shorten" + s);
            }
        });
    }
}
