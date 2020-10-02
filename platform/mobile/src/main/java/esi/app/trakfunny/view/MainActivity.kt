package esi.app.trakfunny.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import esi.app.trakfunny.core.findCoreComponent
import esi.app.trakfunny.view.maincomponent.DaggerMainComponent
import javax.inject.Inject
import javax.inject.Provider

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelProvider: Provider<MainViewModel>

    private lateinit var mainViewModel: MainViewModel
    private var currentNavController: LiveData<NavController>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerMainComponent
            .builder()
            .netComponent(findCoreComponent().provideNetComponent())
            .build()
            .inject(this)

        mainViewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T =
                viewModelProvider.get() as T
        }).get(MainViewModel::class.java)
    }

    override fun onSupportNavigateUp(): Boolean {
        return currentNavController?.value?.navigateUp() ?: false
    }
}
