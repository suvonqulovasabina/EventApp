package com.example.eventapp.screen.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.eventapp.data.MyPref
import com.example.eventapp.databinding.ScreenMainBinding

class MainScreen : Fragment() {
    private var _binding: ScreenMainBinding? = null
    private val binding get() = _binding!!
    private val pref = MyPref

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ScreenMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        checkSwitch()
    }

    private fun checkSwitch() {
        binding.batterySwitch.isChecked = pref.getTag("battery")
        binding.bluetoothSwitch.isChecked = pref.getTag("bluetooth")
        binding.screenSwitch.isChecked = pref.getTag("screen")
        binding.pilotSwitch.isChecked = pref.getTag("pilot")
        binding.internetSwitch.isChecked = pref.getTag("internet")
        binding.batterySwitch.setOnCheckedChangeListener{ _ , checked ->
            pref.setTag("battery", checked)
        }
        binding.internetSwitch.setOnCheckedChangeListener{ _ , checked ->
            pref.setTag("internet", checked)
        }
        binding.pilotSwitch.setOnCheckedChangeListener{ _ , checked ->
            pref.setTag("pilot", checked)
        }

        binding.screenSwitch.setOnCheckedChangeListener{ _ , checked ->
            pref.setTag("screen", checked)
        }

        binding.bluetoothSwitch.setOnCheckedChangeListener{ _ , checked ->
            pref.setTag("bluetooth", checked)
        }

        binding.wifiSwitch.setOnCheckedChangeListener{ _ , checked ->
            pref.setTag("wifi", checked)
        }
        binding.hotspotSwitch.setOnCheckedChangeListener{ _ , checked ->
            pref.setTag("mobile_data", checked)
        }
        binding.info.setOnClickListener {
            findNavController().navigate(MainScreenDirections.actionMainScreenToInfoScreen())
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}