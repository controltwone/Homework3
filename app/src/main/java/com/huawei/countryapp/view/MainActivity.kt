package com.huawei.countryapp.view

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.huawei.countryapp.R
import com.huawei.countryapp.adapter.ProductAdapter
import com.huawei.countryapp.databinding.ActivityMainBinding
import com.huawei.countryapp.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel : MainViewModel
    private lateinit var binding : ActivityMainBinding
    private var productAdapter = ProductAdapter(arrayListOf())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding.productRV.adapter = productAdapter
        binding.productRV.layoutManager = LinearLayoutManager(this)
        viewModel.getDataFromAPI()

        setObservers()
    }


    private fun setObservers() {
        viewModel.productData.observe(this, Observer { list ->
            productAdapter.updateList(list)
        })
        viewModel.productLoad.observe(this, Observer { load ->

            if (load) {
                binding.progressBar.visibility = View.VISIBLE
            } else {
                binding.progressBar.visibility = View.GONE
            }

        })
        viewModel.productError.observe(this, Observer {error ->
            if (error){
                binding.errorTV.visibility = View.VISIBLE
            } else{
                binding.errorTV.visibility = View.GONE
            }


        })
    }
}