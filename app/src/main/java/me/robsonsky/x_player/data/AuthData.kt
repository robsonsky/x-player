package me.robsonsky.x_player.data

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR

class AuthData: BaseObservable() {

    var fullName: String? = null
    @Bindable get() = field
    set(fullName) {
        field = fullName
        notifyPropertyChanged(BR.fullName)
    }

    var email: String? = null
    @Bindable get() = field
    set(email) {
        field = email
        notifyPropertyChanged(BR.email)
    }

    var password: String? = null
    @Bindable get() = field
    set(password) {
        field = password
        notifyPropertyChanged(BR.password)
    }
}