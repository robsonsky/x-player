package me.robsonsky.x_player.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.fragment_signup.*
import kotlinx.android.synthetic.main.fragment_signup.view.*

import me.robsonsky.x_player.R
import me.robsonsky.x_player.databinding.FragmentLoginBinding
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

        return binding.root
    }

    override fun onClick(v: View?) {

        val inputs = mutableListOf<EditText>()

        inputs.add(email_input)
        inputs.add(password_input)

        viewModel.submit(inputs, { msg -> signupSuccess(msg)}, { errorMsg -> signupFailure(errorMsg)})
    }

    fun signupSuccess(msg: String) {
        longToast(msg)
//        activity?.onBackPressed()
    }

    fun signupFailure(errorMsg: String) {
        longToast(errorMsg)
    }
}
