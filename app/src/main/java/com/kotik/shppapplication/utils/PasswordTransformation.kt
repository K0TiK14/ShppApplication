package com.kotik.shppapplication.utils

import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.text.Spannable
import android.text.SpannableString
import android.text.method.TransformationMethod
import android.text.style.ImageSpan
import android.util.DisplayMetrics
import android.util.Log
import android.view.View

class PasswordTransformation(
    private val drawableImg: Drawable?,
    displayMetrics: DisplayMetrics,
    passImgW: Float,
    passImgH: Float,
) : TransformationMethod {

    init {
        val imageWidth = MyHelp.toPx(
            displayMetrics,
            passImgW
        )
        val imageHeight = MyHelp.toPx(
            displayMetrics,
            passImgH
        )

        drawableImg?.setBounds(
            0,
            0,
            imageWidth,
            imageHeight
        )
    }

    override fun getTransformation(source: CharSequence?, view: View?): CharSequence {
        log("getTransformation")
        return replaceWithIcons(source ?: "")
    }

    private fun replaceWithIcons(text: CharSequence): CharSequence {
        log("replaceWithIcons")

        var spannableString: SpannableString? = null

        try {
            if (text.isNotEmpty()) {
                log("text is [$text] with length (${text.length})")
                spannableString = SpannableString(text)
            }
        }
        catch (e: StringIndexOutOfBoundsException) {
            log("HA-HA!!!", true)
            Log.e("myLog", "HA-HA!!!", e)
        }

        log("create spannableString")
        log("text = [${text}] with indexes ${text.indices}")
        if (drawableImg != null && spannableString != null) {

            for (i in text.indices) {
                log("replaceWithIconsEnd i = $i")

                val imageSpan = ImageSpan(
                    drawableImg,
                    ImageSpan.ALIGN_BOTTOM
                )

                spannableString.setSpan(
                    imageSpan,
                    i,
                    i + 1,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )


            }
            log("replaceWithIconsEnd -> ${spannableString.length}")
        }

        return spannableString ?: ""
    }

    override fun onFocusChanged(
        view: View?,
        sourceText: CharSequence?,
        focused: Boolean,
        direction: Int,
        previouslyFocusedRect: Rect?
    ) {
        log("onFocusChanged")
        // Опрацьовуйте подію фокусу, якщо потрібно
    }
}
