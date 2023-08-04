package com.example.tu5.ui.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tu5.R
import com.example.tu5.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        //_binding = FragmentHomeBinding.inflate(inflater, container, false)
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        val root: View = binding.root

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.imageView2.setOnClickListener{
            //Implicit intent - a general action
            //Explicit intent - specific component
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("tel:03114514"))

            startActivity(intent)

            //Call a number
            //binding.editTextNumberDownPayment.text = niuma

        }

        binding.buttonCalculate.setOnClickListener{
            val sellingPrice = binding.editTextNumberSellingPrice.text.toString().toFloat()
            val downPayment = binding.editTextNumberDownPayment.text.toString().toFloat()
            val loan = sellingPrice - downPayment
            val firstTime = binding.checkBoxFirstTimeBuyer.isChecked

            if(firstTime){

            }else{
                //process no fi time buyer
            }
        }

        binding.buttonReset.setOnClickListener{

        }




    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}