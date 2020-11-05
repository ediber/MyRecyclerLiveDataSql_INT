package com.e.myrecyclerlivedatasql_int.fragment0

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.e.myrecyclerlivedatasql_int.database.DatabaseCountry
import com.e.myrecyclerlivedatasql_int.database.getDatabase
import kotlinx.coroutines.*

class Fragment0ViewModel(application: Application) : AndroidViewModel(application) {


    // first part of the class
/*    private var countries = MutableLiveData<MutableList<Country>>()
    val _countries: LiveData<MutableList<Country>>
        get() {
            return countries
        }

    init {
        countries.value = mutableListOf<Country>()
    }

    fun add(country: String, city: String, popNum: Int) {
        val countryObject = Country(country, city, popNum)
        var lst = countries.value
        lst?.add(countryObject)

        countries.value = lst

    */

    private val database = getDatabase(application)

    // getting the data
    val countries = database.countryDao.getCountries()

    // coroutines are created so the app will not get stuck when using database, because it's a heavy operation
    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    fun add(countryName: String, city: String, popNum: Int) {
        val countryObject = DatabaseCountry(countryName, city, popNum)

        coroutineScope.launch {
            withContext(Dispatchers.IO){
                database.countryDao.insertCountry(countryObject)
            }
        }
    }
}