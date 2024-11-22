package ru.romanovdeveloper.damir_pracktik

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class SpecializationFragment(val spec: Specialization) : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.specialization_fragment, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val name : TextView = view.findViewById(R.id.textViewSpecializationFragmentName)
        val code : TextView = view.findViewById(R.id.textViewSpecializationFragmentCode)
        val description : TextView = view.findViewById(R.id.textViewSpecializationFragmentDescription)
        name.append(spec.name)
        code.append(spec.code)
        description.append(spec.description)
    }
}