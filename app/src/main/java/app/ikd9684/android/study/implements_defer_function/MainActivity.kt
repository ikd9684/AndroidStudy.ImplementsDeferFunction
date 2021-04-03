package app.ikd9684.android.study.implements_defer_function

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import app.ikd9684.android.study.implements_defer_function.databinding.ActivityMainBinding
import app.ikd9684.android.study.implements_defer_function.utils.core.withDefers

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        var exampleText = ""

        withDefers {
            exampleText = exampleText.append("1")
            defer {
                exampleText = exampleText.append("2")
            }
            exampleText = exampleText.append("3")
            defer {
                exampleText = exampleText.append("4")
            }
            exampleText = exampleText.append("5")
        }
        // output: 1 3 5 4 2

        binding.textView.text = exampleText
    }
}

fun String.append(value: String): String {
    return if (isNotEmpty()) {
        "$this $value"
    } else {
        value
    }
}