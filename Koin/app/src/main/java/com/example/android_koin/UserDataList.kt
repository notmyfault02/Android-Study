package com.example.android_koin

interface UserDataList: UserData {
    fun onDataLoaded(items: ArrayList<Post>)
    fun onDataFailed()

    fun showPosts()
}