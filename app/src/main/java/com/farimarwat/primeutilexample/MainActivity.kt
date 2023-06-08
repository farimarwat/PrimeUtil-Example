package com.farimarwat.primeutilexample

import ImagePicker
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import com.farimarwat.primeutil.ImageSaver
import com.farimarwat.primeutilexample.databinding.ActivityMainBinding
import getForceFilePathFromUri

const val TAG = "PrimeUtilExample"

class MainActivity : AppCompatActivity() {
    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    lateinit var mContext: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        mContext = this
        var mImageSaver = ImageSaver(this)
        var mImagePicker = ImagePicker(this)
        binding.btnSaveimage.setOnClickListener {
            val bitmap = ContextCompat.getDrawable(mContext, R.drawable.cartoon14)
                ?.toBitmap()
            mImageSaver.saveImage(
                bitmap = bitmap,
                folder = "MyFolder",
                onSuccess = { uri, path ->
                    binding.image.setImageURI(uri)
                },
                onError = {
                    Log.e(TAG, "$it")
                }
            )
        }
        binding.btnListimages.setOnClickListener {
            mImagePicker.listImagesUris(
                self = false,
                onCompleted = {
                    if(it.isNotEmpty()){
                        mContext.getForceFilePathFromUri(
                            uri = it.first(),
                            onSuccess = {
                                Log.e(TAG,"Path: $it")
                            }
                        )
                    }
                }
            )
        }
    }
}