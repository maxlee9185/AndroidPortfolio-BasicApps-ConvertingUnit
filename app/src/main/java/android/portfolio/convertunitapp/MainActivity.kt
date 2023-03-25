package android.portfolio.convertunitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.portfolio.convertunitapp.databinding.ActivityMainBinding
import android.util.Log
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)

        var cmToM = true

        val outpuEditTextView = binding.outputTextView
        val inputEditTextView = binding.inputEditText
        val outputUnitTextView = binding.outputUnitText
        val inputUnitTextView = binding.inputUnitText
        val swapImageButton = binding.swapButton
        var inputNumber : Int = 0
        inputEditTextView.addTextChangedListener { text->
            inputNumber= if( text.isNullOrEmpty() ) { 0 }
            else {
                text.toString().toInt()
            }
            Log.d("inputNumber",inputNumber.toString())

            var outputNumber = inputNumber.times(0.01)
            if(cmToM){
                outpuEditTextView.text= inputNumber.times(0.01).toString()
            }
            else{
                outpuEditTextView.text= inputNumber.times(100).toString()
            }
            outpuEditTextView.text = outputNumber.toString()
        }

        swapImageButton.setOnClickListener{
            cmToM=cmToM.not()
            if(cmToM){
                inputUnitTextView.text = "cm"
                outputUnitTextView.text = "m"
                outpuEditTextView.text= inputNumber.times(0.01).toString()
            }
            else{
                inputUnitTextView.text = "m"
                outputUnitTextView.text = "cm"
                outpuEditTextView.text= inputNumber.times(100).toString()
            }
        }
    }
}