package com.kotik.shppapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kotik.shppapplication.databinding.ActivityMyProfileBinding
import com.kotik.shppapplication.databinding.ActivitySignUpBinding

class MyProfile : AppCompatActivity() {

    lateinit var binding: ActivityMyProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        

        binding.logOutButton.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)

            val sharedPreferences = getSharedPreferences("AutoLogin", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.remove("Email")
            editor.remove("Password")
            editor.apply()

            startActivity(intent)
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        }

        val sharedPreferences = getSharedPreferences("AutoLogin", Context.MODE_PRIVATE)
        val email = sharedPreferences.getString("Email", null)
        val password = sharedPreferences.getString("Password", null)
        binding.name.text = email
        binding.career.text = password
//        binding.name.text = intent.getStringExtra("email")
//        binding.career.text = intent.getStringExtra("password")
    }
}