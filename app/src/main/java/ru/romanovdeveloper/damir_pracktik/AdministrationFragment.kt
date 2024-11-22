package ru.romanovdeveloper.damir_pracktik

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class AdministrationFragment(val admin : Administration) : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_administration, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val firstName : TextView = view.findViewById(R.id.textViewAdministrationFragmentFirstName)
        val secondName : TextView = view.findViewById(R.id.textViewAdministrationFragmentSecondName)
        val thirdName : TextView = view.findViewById(R.id.textViewAdministrationFragmentThirdName)
        val post : TextView = view.findViewById(R.id.textViewAdministrationFragmentPost)
        val description : TextView = view.findViewById(R.id.textViewAdministrationFragmentDescription)
        firstName.append(admin.firstName)
        secondName.append(admin.secondName)
        thirdName.append(admin.thirdName)
        post.append(admin.post)
        description.text = admin.description
    }
}