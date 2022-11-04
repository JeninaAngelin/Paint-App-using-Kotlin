package com.example.paintapp
import android.view.View
import android.util.AttributeSet
import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.view.MotionEvent
import android.view.ViewGroup
import com.example.paintapp.MainActivity.Companion.paintBrush
import com.example.paintapp.MainActivity.Companion.path
import com.example.paintapp.PaintView.Companion.colorList

class PaintView {

    var params:ViewGroup.LayoutParams?=null
  companion object {
      var pathList = ArrayList<Path>()
      var colorList = ArrayList<Int>()
      var currentBrush = Color.BLUE
  }
        constructor(context: Context) : this(context, null) {
Init()

        }
        constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0){
            Init()
        }
        constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
            Init()
        }

    private fun Init(){
        paintBrush.isAntiAlias=true
        paintBrush.color=currentBrush
        paintBrush.style=Paint.Style.STROKE
        paintBrush.strokeJoin=Paint.Join.ROUND
        paintBrush.strokeWidth=8f

        params=ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT)
    }

         override fun onTouchEvent(event: MotionEvent):Boolean{
             var x=event.x
             var y=event.y

             when(event.action)
             {
                 MotionEvent.ACTION_MOVE->{
                     path.LineTo(x,y)
                     pathList.add(path)
                     colorList.add(currentBrush)
                 }
                 else -> return false
             }
             postInvalidate()
             return false


    }
    override  fun  onDraw(canvas:Canvas?){
        for(i in pathList.indices){
            paintBrush.setColor(colorList(1))
            canvas.drawPath(pathList(1),paintBrush)
            Invalidate()
        }

}



}
