package com.yogadarma.stockbitapp.presentation.login

import android.os.Bundle
import android.view.*
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.yogadarma.stockbitapp.R
import com.yogadarma.stockbitapp.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCreateAccount.text = HtmlCompat.fromHtml(
            "<font>Belum punya akun?</font> <font color='#1AA86E'>Daftar sekarang</font>",
            HtmlCompat.FROM_HTML_MODE_LEGACY
        )

        binding.btnLogin.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_watchlistFragment)
        )
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.login_menu, menu)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}