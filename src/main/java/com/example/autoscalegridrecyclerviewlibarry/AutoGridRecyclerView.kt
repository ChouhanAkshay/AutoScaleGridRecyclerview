package com.example.autoscalegridrecyclerviewlibarry

import android.R
import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AutoGridRecyclerView : RecyclerView {

    /*initialization*/
    lateinit var gridLayoutManager: GridLayoutManager
    var columnWidth = -1


    constructor(context: Context) : super(context) {
        initalization(context,null)
    }

    constructor(context: Context, attributeSet: AttributeSet?) : super(context, attributeSet) {
        initalization(context, attributeSet)
    }

    private fun initalization(context: Context, attributeSet: AttributeSet?) {
        if (attributeSet != null) { // list the attributes we want to fetch
            val attrsArray = intArrayOf(
                R.attr.columnWidth
            )
            val array: TypedArray = context.obtainStyledAttributes(attributeSet, attrsArray)

            columnWidth = array.getDimensionPixelSize(0, -1)
            array.recycle()
        }
        gridLayoutManager = GridLayoutManager(context, 1)
        layoutManager = gridLayoutManager
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        return super.dispatchTouchEvent(ev)
    }

    override fun onMeasure(widthSpec: Int, heightSpec: Int) {
        super.onMeasure(widthSpec, heightSpec)
        if (columnWidth > 0) {
            val spanCount = 1.coerceAtLeast(measuredWidth / columnWidth)
            gridLayoutManager.spanCount = spanCount
        }
    }
}