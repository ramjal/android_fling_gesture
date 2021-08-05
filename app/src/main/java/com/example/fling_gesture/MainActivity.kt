package com.example.fling_gesture

import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), GestureDetector.OnGestureListener {
    // Minimal x and y axis swipe distance.
    private val MIN_SWIPE_DISTANCE_X = 100
    private val MIN_SWIPE_DISTANCE_Y = 100

    // Maximal x and y axis swipe distance.
    private val MAX_SWIPE_DISTANCE_X = 1000
    private val MAX_SWIPE_DISTANCE_Y = 1000

    lateinit var gestureDetector: GestureDetector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gestureDetector = GestureDetector(applicationContext, this)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return if (gestureDetector.onTouchEvent(event)) {
            true
        }
        else {
            super.onTouchEvent(event)
        }
    }

    override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {
        var message = "Nothing"
        // Get swipe delta value in x axis.
        // Get swipe delta value in x axis.
        val deltaX = e1!!.x - e2!!.x
        // Get swipe delta value in y axis.
        // Get swipe delta value in y axis.
        val deltaY = e1.y - e2.y
        // Get absolute value.
        // Get absolute value.
        val deltaXAbs = Math.abs(deltaX)
        val deltaYAbs = Math.abs(deltaY)
        // Only when swipe distance between minimal and maximal distance value then we treat it as effective swipe
        // Only when swipe distance between minimal and maximal distance value then we treat it as effective swipe
        if (deltaXAbs >= MIN_SWIPE_DISTANCE_X && deltaXAbs <= MAX_SWIPE_DISTANCE_X) {
            if (deltaX > 0) {
                message = "Swipe to left"
            } else {
                message = "Swipe to right"
            }
        }
        if (deltaYAbs >= MIN_SWIPE_DISTANCE_Y && deltaYAbs <= MAX_SWIPE_DISTANCE_Y) {
            if (deltaY > 0) {
                message = "Swipe to up"
            } else {
                message = "Swipe to down"
            }
        }

        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
        return true
    }

    override fun onDown(p0: MotionEvent?): Boolean {
        return false
    }
    override fun onShowPress(p0: MotionEvent?) {
        return
    }
    override fun onSingleTapUp(p0: MotionEvent?): Boolean {
        return false
    }
    override fun onScroll(p0: MotionEvent?, p1: MotionEvent?, p2: Float, p3: Float): Boolean {
        return false
    }
    override fun onLongPress(p0: MotionEvent?) {
        return
    }

}