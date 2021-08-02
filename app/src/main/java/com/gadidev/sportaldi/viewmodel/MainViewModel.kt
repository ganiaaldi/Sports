package com.gadidev.sportaldi.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gadidev.sportaldi.model.Events
import com.gadidev.sportaldi.model.League
import com.gadidev.sportaldi.model.LeagueDetail
import com.gadidev.sportaldi.services.ApiConfig
import kotlinx.coroutines.*
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response

class MainViewModel : ViewModel() {

    private val _leagueList = MutableLiveData<League>()
    val leagueList: LiveData<League> = _leagueList

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _leagueDetail = MutableLiveData<LeagueDetail>()
    val leagueDetail: LiveData<LeagueDetail> = _leagueDetail

    private val _prevEvent = MutableLiveData<Events>()
    val prevEvent: LiveData<Events> = _prevEvent

    private val _nextEvent = MutableLiveData<Events>()
    val nextEvent: LiveData<Events> = _nextEvent

    val leagueIdShare = MutableLiveData<String>()



    companion object {
        private const val TAG = "MainViewModel"
    }

    fun getLeague() {
        _isLoading.value = true
        val client = ApiConfig.getApiService().getAllLeagues()
        client.enqueue(object : Callback<League> {
            override fun onResponse(call: Call<League>, response: Response<League>) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    _leagueList.postValue(response.body())
                     Log.e(TAG, "onSucesss: ${call.request().url}")
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<League>, t: Throwable) {
                _isLoading.value = false
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
    }

    fun getDetail(idLeague : String) {
        leagueIdShare.value = idLeague
        _isLoading.value = true
        val client = ApiConfig.getApiService().getDetailLeague(idLeague)
        client.enqueue(object : Callback<LeagueDetail> {
            override fun onResponse(call: Call<LeagueDetail>, response: Response<LeagueDetail>) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    _leagueDetail.postValue(response.body())
                    Log.e(TAG, "onSucesss: ${call.request().url}")
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<LeagueDetail>, t: Throwable) {
                _isLoading.value = false
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
    }

    fun getPrevEvents(idLeague : String) {
//        _isLoading.value = true
        val client = ApiConfig.getApiService().getEventPast(idLeague)
        client.enqueue(object : Callback<Events> {
            override fun onResponse(call: Call<Events>, response: Response<Events>) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    _prevEvent.postValue(response.body())
                    Log.e(TAG, "onSucesss: ${call.request().url}")
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<Events>, t: Throwable) {
//                _isLoading.value = false
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
    }

    fun getNextEvents(idLeague : String) {
//        _isLoading.value = true
        val client = ApiConfig.getApiService().getNextEvents(idLeague,"2021-2022")
        client.enqueue(object : Callback<Events> {
            override fun onResponse(call: Call<Events>, response: Response<Events>) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    _nextEvent.postValue(response.body())
                    Log.e(TAG, "onSucesss: ${call.request().url}")
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<Events>, t: Throwable) {
//                _isLoading.value = false
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
    }

}