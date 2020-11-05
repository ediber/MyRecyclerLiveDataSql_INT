package com.e.myrecyclerlivedatasql_int

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Fragment0ViewModel : ViewModel() {

    // TODO: Implement the ViewModel

    private var countries = MutableLiveData<MutableList<Country>>()
    val _countries: LiveData<MutableList<Country>>
        get() {
            return countries
        }

    init {
        countries.value = mutableListOf<Country>()
    }

    fun add(country: String, city: String) {
        val countryObject = Country(country, city)
        var lst = countries.value
        lst?.add(countryObject)

        countries.value = lst
    }
}