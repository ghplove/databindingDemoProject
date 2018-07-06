package com.ghp.demo.databindingdemoproject.view

import android.content.Context
import android.databinding.*
import android.databinding.adapters.ListenerUtil
import android.databinding.adapters.TextViewBindingAdapter
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.ghp.demo.databindingdemoproject.R

/**
 * BindingMethods与BindingMethod定义了一个自己声明的属性：testToast
 *
 * 该属性与TestEditText里的showTestToast绑定
 */
@BindingMethods(BindingMethod(type = EditText::class, attribute = "bindingMethodToast", method = "showBindingMethodToast"))

/**
 * 双向绑定
 * 在xml属性上使用语法"@={}"
 * 自定义view通过InverseBindingAdapter注解类实现
 * event的命名方式是+ AttrChanged，例如：textAttrChanged
 * 需要BindingAdapter告诉框架如何处理event事件
 * BindingAdapter需要设置requireAll = false，否则系统将识别不了textAttrChanged属性
 * InverseBindingListener调用onChange告知发生变化，所有双向绑定，最后都是通过这个接口来observable改变的，各种监听
 *
 * 双向绑定发现的问题：
 * 死循环绑定：因为数据源改变会通知view刷新，而view改变又会通知数据源刷新，这样一直循环往复，就形成了死循环绑定。
 * 数据源中的数据有时需要经过转换才能在view中展示，而view中展示的内容也需要经过转换才能绑定到对应的数据源上。
 *
 * 死循环绑定的解决方式：只处理新旧数据不一样的数据，参考源码中的例子：android.databinding.adapters.TextViewBindingAdapter
 */
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
                override fun afterTextChanged(s: Editable?) {
                    after?.afterTextChanged(s)
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                    before?.beforeTextChanged(s, start, count, after)
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    on?.onTextChanged(s, start, before, count)
                    Log.i("TestEditText", "textAttrChanged")
                    textAttrChanged?.onChange()
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
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    fun showBindingMethodToast(s: String) {
        if(s.isNullOrEmpty()){
            return
        }
        Toast.makeText(context, s, Toast.LENGTH_SHORT).show()
    }
}

