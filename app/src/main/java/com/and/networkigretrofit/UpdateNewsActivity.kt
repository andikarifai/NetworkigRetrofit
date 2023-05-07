package com.and.networkigretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import com.and.networkigretrofit.databinding.ActivityUpdateNewsBinding

class UpdateNewsActivity : AppCompatActivity() {
    lateinit var binding: ActivityUpdateNewsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveBtn.setOnClickListener {
            val title = binding.updateTitle.text.toString()
            val img = binding.updateImage.text.toString()
            val author = binding.updateAuthor.text.toString()
            val description = binding.updateDesc.text.toString()
            updateData(title,img,author, description)
        }
    }

    private fun updateData(title: String, img: String, author: String, description: String) {
        val viewModel : ViewModel
    }
}