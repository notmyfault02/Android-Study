package com.example.android_koin

import io.reactivex.Single
import retrofit2.http.GET

interface Service {
    @GET("/posts")
    fun getPosts(): Single<ArrayList<Post>>
}
