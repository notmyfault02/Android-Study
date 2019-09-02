package com.example.android_koin.ui

import android.util.Log
import com.example.android_koin.Post
import com.example.android_koin.Service
import com.example.android_koin.UserDataList
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainPresenterImpl(val api: Service): MainPresenter<UserDataList>() {

    override fun getJsonPosts(items: ArrayList<Post>) {
        Log.d("Impl", "work")
        compositeDisposable?.add(api.getPosts()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    userData?.onDataLoaded(it)
                    Log.d("Impl", it[1].body)
                }, {
                    userData?.onDataFailed()
                }
            ))
    }
}