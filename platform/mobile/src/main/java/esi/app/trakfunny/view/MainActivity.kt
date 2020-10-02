package esi.app.trakfunny.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import esi.app.trakfunny.R
import esi.app.trakfunny.ext.findCoreComponent
import esi.app.trakfunny.view.maincomponent.DaggerMainComponent
import javax.inject.Inject
import javax.inject.Provider

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelProvider: Provider<MainViewModel>

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
}
