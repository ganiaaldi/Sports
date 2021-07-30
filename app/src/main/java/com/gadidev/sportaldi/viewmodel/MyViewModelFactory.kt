package com.gadidev.sportaldi.viewmodel

//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import com.gadidev.sportaldi.services.ApiConfig
//
//class MyViewModelFactory constructor(private val repository: ApiConfig): ViewModelProvider.Factory {
//
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        return if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
//            MainViewModel(this.repository) as T
//        } else {
//            throw IllegalArgumentException("ViewModel Not Found")
//        }
//    }
//}