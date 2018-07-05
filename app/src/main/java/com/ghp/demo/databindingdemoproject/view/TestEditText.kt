package com.ghp.demo.databindingdemoproject.view

import android.content.Context
import android.databinding.BindingAdapter
import android.databinding.InverseBindingAdapter
import android.databinding.InverseBindingListener
import android.databinding.ObservableField
import android.databinding.adapters.ListenerUtil
import android.databinding.adapters.TextViewBindingAdapter
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.widget.EditText
import android.widget.TextView
import com.ghp.demo.databindingdemoproject.R
import java.util.jar.Attributes

class TestEditText : EditText {
    companion object {
        var value: ObservableField<CharSequence> = ObservableField("")

        @InverseBindingAdapter(attribute = "android:text", event = "android:textAttrChanged")
        @JvmStatic
        fun captureTextValue(view: TextView): String {
            var newValue: CharSequence = view.text
            var oldValue: CharSequence = value.get()
            if (oldValue == null) {
                value.set(newValue)
            } else if (newValue != oldValue) {
                value.set(newValue)
            }
            return value.get().toString()
        }

        @BindingAdapter(value = arrayOf("android:beforeTextChanged", "android:onTextChanged", "android:afterTextChanged", "android:textAttrChanged"),
                requireAll = false)
        @JvmStatic
        fun setTextWatcher(view: TextView,
                           before: TextViewBindingAdapter.BeforeTextChanged?,
                           on: TextViewBindingAdapter.OnTextChanged?,
                           after: TextViewBindingAdapter.AfterTextChanged?,
                           textAttrChanged: InverseBindingListener?) {
            var newValue: TextWatcher = object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {}
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    on?.apply {
                        on.onTextChanged(s, start, before, count)
                    }
                    textAttrChanged?.apply {
                        textAttrChanged.onChange()
                    }
                }
            }
            var oldValue: TextWatcher? = ListenerUtil.trackListener(view, newValue, R.id.textWatcher)
            oldValue?.apply {
                view.removeTextChangedListener(oldValue)
            }
            view.addTextChangedListener(newValue)
        }

    }

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet): super(context, attributeSet)

}