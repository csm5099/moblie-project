package com.example.profile_management

import android.Manifest
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import coil.load
import coil.size.Precision
import coil.size.Scale
import com.example.profile_management.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val permissionList = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
    private val checkPermission = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { result ->
        result.forEach {
            if(!it.value) {
                Toast.makeText(applicationContext, "권한 동의 필요!", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
    private val readImage = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.profileImgUser.load(uri){
            size(450)
            scale(Scale.FIT)
            precision(Precision.EXACT)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        checkPermission.launch(permissionList)

        binding.profileImgUser.setOnClickListener {
            readImage.launch("image/*")
        }
    }
}
