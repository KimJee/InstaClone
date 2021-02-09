package com.example.instaclone;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("4NSZKHwO0RZwEzLQ1oN9B4T1fmfpYxDXKyTaMl1q")
                .clientKey("dGrNzBjP5C2UaSj2RZAljhjk4VBSDYmN5LliOarZ")
                .server("https://parseapi.back4app.com")
                .build()
        );

    }
}
