package com.kotik.shppapplication.utils

import android.text.Editable
import android.text.TextWatcher
import com.google.android.material.textfield.TextInputEditText

class CustomWatcher(private val textInput: TextInputEditText) : TextWatcher {

    private var oldText = ""

    override fun beforeTextChanged(
        s: CharSequence?, start: Int, count: Int, after: Int
    ) { // Нічого не робимо

        val oldText = textInput.text.toString()
        log("beforeChange status: new sequence = [${s}] with length (${s?.length}), and old = [$oldText] with length (${oldText.length})")
        log("before text change") //procTransformation(s)
    }

    override fun onTextChanged(
        s: CharSequence?, start: Int, before: Int, count: Int
    ) { // Опрацьовуємо текст при зміні
        log("before dots replace")
        log("onChange status: new sequence = [${s}] with length (${s?.length}), and old = [$oldText] with length (${oldText.length})")
        procTransformation(s)
        log("after dots replace")
    }

    override fun afterTextChanged(s: Editable?) { // Нічого не робимо

        log("afterChange status: new sequence = [${s}] with length (${s?.length}), and old = [$oldText] with length (${oldText.length})")
        log("after text change")

        textInput.setSelection(textInput.text.toString().length)
    }

    private fun procTransformation(s: CharSequence?) {

        log("new sequence = [${s}] with length (${s?.length}), and old = [$oldText] with length (${oldText.length})")

        if (s.toString() != oldText) {
            log("new text! -> DO REPLACE!")
            oldText = s.toString()
            textInput.setText(oldText)
            val transformedText = textInput.transformationMethod.getTransformation(
                s,
                null
            )

            log("is new text !")

            textInput.text = Editable.Factory.getInstance().newEditable(transformedText)

            log("transformed text length = ${transformedText.length}")

        }
    }
}

fun TextInputEditText.changeTextToDots() {
    this.addTextChangedListener(CustomWatcher(this))
}