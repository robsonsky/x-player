package me.robsonsky.x_player.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_login.view.*
import kotlinx.android.synthetic.main.fragment_signup.*
import kotlinx.android.synthetic.main.fragment_signup.view.*
import kotlinx.android.synthetic.main.fragment_signup.view.submit_btn

import me.robsonsky.x_player.R
import me.robsonsky.x_player.databinding.FragmentLoginBinding
import me.robsonsky.x_player.signup.SignupActivity
import org.jetbrains.anko.support.v4.longToast

class LoginFragment : Fragment(), View.OnClickListener {

    lateinit var viewModel: LoginViewModel

    companion object {
        fun newInstance(viewModel: LoginViewModel): LoginFragment {
            val fragment = LoginFragment()
            fragment.viewModel = viewModel
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var binding: FragmentLoginBinding
                = DataBindingUtil.inflate(inflater, R.layout.fragment_login,container, false)

        binding.viewModel = viewModel

        binding.root.submit_btn.setOnClickListener(this)
        binding.root.signup_btn.setOnClickListener(this)

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        if (isAuthenticated()) {
            activity?.finish()
        }
    }

    override fun onClick(v: View?) {

        when(v?.id) {
            R.id.submit_btn -> submit()
            R.id.signup_btn -> signup()
        }
    }

    private fun submit() {

        val inputs = mutableListOf<EditText>()

        inputs.add(email_input)
        inputs.add(password_input)

        viewModel.submit(inputs, { msg -> loginSuccess(msg)}, { errorMsg -> loginFailure(errorMsg)})
    }

    private fun signup() {
        activity?.startActivity(Intent(activity, SignupActivity::class.java))
    }

    fun loginSuccess(msg: String) {
        longToast(msg)
        activity?.finish()
    }

    fun loginFailure(errorMsg: String) {
        longToast(errorMsg)
    }
    private fun isAuthenticated(): Boolean {
        return FirebaseAuth.getInstance().currentUser != null
    }
}
