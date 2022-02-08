package com.example.session1.retrofit.api

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.session1.MainActivity
import com.example.session1.R
import com.example.session1.retrofit.model.Registration
import com.example.session1.retrofit.repository.Repository
import kotlinx.android.synthetic.main.activity_sign_up_screen.*

class SignUpScreenActivity : AppCompatActivity() {
    private lateinit var viewModel : MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_screen)
    }

    fun clickToLogIn(view: View) {
        val intent = Intent(this, SignInScreenActivity::class.java)
        startActivity(intent)
    }

    fun clickToMainn(view: View) {

        val email = editTextTextEmailAddress2.text.toString()
        val password = editTextTextPassword.text.toString()
        val name = editTextTextPersonName.text.toString()
        val familia = editTextTextPersonName2.text.toString()
        val confermpass = editTextTextPassword2.text.toString()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)

        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
//        viewModel.getRegistrUser(Registration(email, password, name, familia))
        viewModel.myResponse2.observe(this, Observer { response ->
            Log.d("Response", response.message().toString())
            Log.d("Response", response.code().toString())
            Log.d("Response", response.body().toString())
        })

        if (email.isEmpty()||password.isEmpty()||name.isEmpty()||familia.isEmpty()||confermpass.isEmpty()){
            Toast.makeText(this, "Заполните все поля.", Toast.LENGTH_LONG).show()
        }
        else if (password!=confermpass){
            Toast.makeText(this, "Пароли не совпадают.", Toast.LENGTH_LONG).show()
        }
        else{
            val intent2 = Intent(this, MainActivity::class.java)
            startActivity(intent2)
        }

    }
}