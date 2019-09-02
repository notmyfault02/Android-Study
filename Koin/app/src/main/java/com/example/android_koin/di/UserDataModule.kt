package com.example.android_koin.di

import com.example.android_koin.ui.MainPresenter
import com.example.android_koin.ui.MainPresenterImpl
import org.koin.core.module.Module
import org.koin.dsl.module

val userDataModule: Module = module {
    factory {
        MainPresenterImpl(get()) as MainPresenter<*>
    }
}