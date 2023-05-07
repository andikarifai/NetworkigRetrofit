package com.and.networkigretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.and.networkigretrofit.databinding.ActivityAddNewsBinding
import com.and.networkigretrofit.viewModel.NewsViewModel

class AddNewsActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddNewsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveBtn.setOnClickListener {
            val title = binding.addTitle.text.toString()
            val img = binding.addImage.text.toString()
            val author = binding.addAuthor.text.toString()
            val description = binding.addDesc.text.toString()
            addNews(title,img,author, description)
        }
    }
        fun addNews(title: String, image: String, author: String, description: String){
            val viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
            viewModel.addDataNews(title, image, author, description)
            viewModel.postNews().observe(this, {
                if (it != null) {
                    Toast.makeText(this, "Data berhasil disimpan", Toast.LENGTH_SHORT).show()
                }
                finish()
            })
    }
}