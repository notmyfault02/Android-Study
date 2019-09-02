package com.example.android_koin.ui

import com.example.android_koin.Post
import com.example.android_koin.UserData
import io.reactivex.disposables.CompositeDisposable

abstract class MainPresenter<U: UserData> {
    protected var compositeDisposable: CompositeDisposable? = null

    var userData: U? = null
        set(value) {
            if(this.userData !== value) {
                field = value
                compositeDisposable = CompositeDisposable()
            }
        }

    abstract fun getJsonPosts(items: ArrayList<Post>)
}