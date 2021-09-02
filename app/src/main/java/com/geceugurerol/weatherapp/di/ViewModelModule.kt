package com.geceugurerol.weatherapp.di

import com.geceugurerol.weatherapp.ui.MainViewModel
import org.koin.android.viewmodel.compat.ScopeCompat.viewModel
import org.koin.android.viewmodel.dsl.viewModel

import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}