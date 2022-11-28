package com.example.profile_management

import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

class BaseActivity {
    abstract class BassActivity: AppCompatActivity(){
        abstract fun permissionGranted(request: Int)
        abstract fun permissionDenied(request: Int)

        fun requirePermissions(permissions: Array<String>, requestCode:Int){
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M){
                permissionGranted(requestCode)
            }else {
                val isAllPermissionGranted = permissions.all {
                    checkSelfPermission(it) == PackageManager.PERMISSION_GRANTED
                }

                if (isAllPermissionGranted) {
                    permissionGranted(requestCode)
                }else{
                    ActivityCompat.requestPermissions(this, permissions, requestCode)
                }
            }
        }

        override fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<out String>,
            grantResults: IntArray
        ) {
            if(grantResults.all {it==PackageManager.PERMISSION_GRANTED}) {
                permissionGranted(requestCode)
            }else{
                permissionDenied(requestCode)
            }
        }

    }
}
