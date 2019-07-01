package me.robsonsky.x_player.signup

import android.content.Context
import android.util.Log
import android.widget.EditText
import androidx.databinding.ObservableBoolean
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import me.robsonsky.x_player.R
import me.robsonsky.x_player.data.AuthData

class SignupViewModel(var authData: AuthData, val context: Context){

    val loadingVisibility = ObservableBoolean(false)

    fun submit(inputs: List<EditText>, success:(msg: String) -> Unit, failure:(errorMsg: String) -> Unit) {

        if(validateInputs(inputs)) {
            signup(success, failure)
        }
    }

    fun validateInputs(inputs: List<EditText>): Boolean {

        var res = true

        for (editText in inputs) {

            val context = editText.context

            val input = editText.text.toString().trim()

            if(input.isEmpty()) {
                editText.setError(context.getString(R.string.empty_edit_text_error_msg))
                res = false
            }
        }

        return res
    }

    fun signup(success:(msg: String) -> Unit, failure:(errorMsg: String) -> Unit) {

        loadingVisibility.set(true)

        FirebaseAuth
            .getInstance()
            .createUserWithEmailAndPassword(authData.email.toString(), authData.password.toString())
            .addOnCompleteListener{ task ->

                loadingVisibility.set(false)

                if(task.isSuccessful) {
                    success(context.getString(R.string.success))
                } else {
                    failure(task.exception?.localizedMessage.toString())
                }
            }
    }

}