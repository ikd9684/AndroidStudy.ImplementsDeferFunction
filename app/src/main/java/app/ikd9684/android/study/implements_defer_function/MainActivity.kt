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
            defer {
                exampleText += "1"
            }
            exampleText += "2"
            defer {
                exampleText += "3"
            }
            exampleText += "4"
            exampleText += "5"
        }
        // output: 2 4 5 3 1

        binding.textView.text = exampleText
    }
}
