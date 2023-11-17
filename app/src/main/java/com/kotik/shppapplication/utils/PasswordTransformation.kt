package com.kotik.shppapplication.utils

import android.text.method.PasswordTransformationMethod
import android.view.View

//class PasswordTransformation(private val context: Context) : PasswordTransformationMethod {
//    override fun getTransformation(source: CharSequence?, view: View?): CharSequence {
//        //return source?.let { replaceWithIcons(it) } ?: ""
//        return PasswordCharSequence(source)
//    }
//
//    private fun replaceWithIcons(text: CharSequence): CharSequence {
//        val spannableString = SpannableString(text)
//
//        for (i in text.indices) {
//            val drawable = ContextCompat.getDrawable(context, R.drawable.password_transformation_img)
//
//            if (drawable != null) {
//                val displayMetrics = context.resources.displayMetrics
//                val imageWidth = MyHelp.toPx(displayMetrics, context.resources.getDimension(R.dimen.password_transform_img_width))
//                val imageHeight = MyHelp.toPx(displayMetrics, context.resources.getDimension(R.dimen.password_transform_img_height))
//                drawable.setBounds(0, 0, imageWidth, imageHeight)
//
//                val imageSpan = ImageSpan(drawable, ImageSpan.ALIGN_BOTTOM)
//                spannableString.setSpan(imageSpan, i, i + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
//            }
//        }
//        Log.d("MYLOG", "qwerty11")
//        return spannableString
//    }
//
//    override fun onFocusChanged(
//        view: View?,
//        sourceText: CharSequence?,
//        focused: Boolean,
//        direction: Int,
//        previouslyFocusedRect: Rect?
//    ) {
//        // Опрацьовуйте подію фокусу, якщо потрібно
//        Log.d("MYLOG", "qwerty12")
//    }
//}
//
//class PasswordCharSequence(source: CharSequence?) : CharSequence {
//    private lateinit var mSource: CharSequence?
//    init {
//        mSource = source
//    }
//
//    public fun charAt(index: Int): Char {
//        return '*'; // This is the important part
//    }
//    public fun length(): Int {
//        return mSource?.length ?: 0; // Return default
//    }
//    public fun subSequence(start:Int, end:Int): CharSequence {
//        return mSource?.subSequence(start, end)?: "" // Return default
//    }
//}
//}
class AsteriskPasswordTransformationMethod : PasswordTransformationMethod() {
    override fun getTransformation(source: CharSequence?, view: View?): CharSequence {
        return PasswordCharSequence(source)
    }

    private inner class PasswordCharSequence    // Store char sequence
        (private val mSource: CharSequence?) :
        CharSequence {
        override fun charAt(index: Int): Char {
            return '*' // This is the important part
        }

        override fun length(): Int {
            return mSource.length // Return default
        }

        override fun subSequence(start: Int, end: Int): CharSequence {
            return mSource.subSequence(start, end) // Return default
        }
    }
};