package com.iglo.githubsearcher

import android.app.Application
import android.content.Intent
import androidx.lifecycle.AndroidViewModel

open class BaseViewModel(application: Application) : AndroidViewModel(application){
    val navigationEvent = SingleLiveEvent<Intent>()
    open fun handleNavigationParams(it: Intent) {

    }
}