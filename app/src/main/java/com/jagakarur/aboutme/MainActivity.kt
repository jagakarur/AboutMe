package com.jagakarur.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.jagakarur.aboutme.data.MyName
import com.jagakarur.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Aswin")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName
//        findViewById<Button>(R.id.button_done).setOnClickListener {
//            addNickName(it)
//        }
        binding.buttonDone.setOnClickListener{
            addNickName(it)
        }
    }

    private fun addNickName(view: View) {
        binding.apply {
           // binding.textViewNickName.text = binding.nickNameEdit.text
            myName?.nickName = nickNameEdit.text.toString()
            invalidateAll()
            nickNameEdit.visibility = View.GONE
            buttonDone.visibility = View.GONE
            textViewNickName.visibility = View.VISIBLE
        }
//        val nickNameEditText = findViewById<EditText>(R.id.nickName_edit)
//        val nickNameTextView = findViewById<TextView>(R.id.textView_nickName)
//
//        nickNameTextView.text = nickNameEditText.text
//
//        nickNameEditText.visibility = View.GONE
//        view.visibility = View.GONE
//        nickNameTextView.visibility = View.VISIBLE

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)


    }


}