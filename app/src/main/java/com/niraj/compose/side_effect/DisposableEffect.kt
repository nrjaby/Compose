package com.niraj.compose.side_effect

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun DisposableEffect(sensorManager: SensorManager) {

    var sensorReading by remember { mutableStateOf(0f) }


    val accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

    DisposableEffect(accelerometer) {

        val sensorEventListener = object : SensorEventListener {
            override fun onSensorChanged(event: SensorEvent?) {
                event?.let {
                    sensorReading = it.values[0]
                }
            }

            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}
        }


        sensorManager.registerListener(
            sensorEventListener,
            accelerometer,
            SensorManager.SENSOR_DELAY_NORMAL
        )


        onDispose {
            sensorManager.unregisterListener(sensorEventListener)
        }
    }


    Text(text = "Sensor Reading: $sensorReading", style = MaterialTheme.typography.bodyMedium)
}
