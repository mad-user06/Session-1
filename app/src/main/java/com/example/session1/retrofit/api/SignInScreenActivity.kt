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
import com.example.session1.retrofit.model.LogIn
import com.example.session1.retrofit.repository.Repository
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInScreenActivity : AppCompatActivity() {
    private lateinit var viewModel : MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)


    }

    fun clickToMain(view: View) {
        val email = editTextTextEmailAddress.text.toString()
        val password = editTextTextPassword.text.toString()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)

        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
        viewModel.getLogin(LogIn(email, password))
        viewModel.myResponse.observe(this, Observer { response ->
            Log.d("Response", response.message().toString())
            Log.d("Response", response.code().toString())
            Log.d("Response", response.body().toString())
        })
        if (email.isNotEmpty()||password.isNotEmpty()){
            if (email.contains("@")){
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent) }
            else {
                Toast.makeText(this, "Отсутсвует собака в E-mail.", Toast.LENGTH_LONG).show()
            }
        }
        else{
            Toast.makeText(this, "Заполните все поля.", Toast.LENGTH_LONG).show()
        }


    }

    fun clickToRegistr(view: View) {
        val intent2 = Intent(this, SignUpScreenActivity::class.java)
        startActivity(intent2)
    }
}

//if (email.isEmpty()||password.isEmpty()){
//    Toast.makeText(this, "Заполните все поля.", Toast.LENGTH_LONG).show()
//
//}
//else if (email.contains("@")){
//    Toast.makeText(this, "Отсутсвует собака в E-mail.", Toast.LENGTH_LONG).show()
//}
//
//else{
//    val intent = Intent(this, MainActivity::class.java)
//    startActivity(intent)
//}