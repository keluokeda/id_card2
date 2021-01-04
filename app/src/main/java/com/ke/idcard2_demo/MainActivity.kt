package com.ke.idcard2_demo

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import androidx.appcompat.app.AlertDialog
import com.kernal.passportreader.sdk.RxIDCardRecognition
import com.kernal.passportreader.sdk.SourceType
import com.tbruyelle.rxpermissions2.RxPermissions

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        RxPermissions(this).request(Manifest.permission.READ_PHONE_STATE).subscribe()

        findViewById<Button>(R.id.camera).setOnClickListener {
            start(SourceType.Camera)
        }

        findViewById<Button>(R.id.gallery).setOnClickListener {
            start(SourceType.Gallery)
        }
    }

    private fun start(sourceType: SourceType) {
        val isIdCard = findViewById<RadioButton>(R.id.rb_id_card).isChecked

        RxIDCardRecognition(this).start(
            if (isIdCard) RxIDCardRecognition.TYPE_ID_CARD else RxIDCardRecognition.TYPE_VEHICLE_LICENSE,
            sourceType
        ).subscribe {
            AlertDialog.Builder(this)
                .setTitle("识别结果")
                .setMessage(it.toString())
                .show()
        }

    }
}