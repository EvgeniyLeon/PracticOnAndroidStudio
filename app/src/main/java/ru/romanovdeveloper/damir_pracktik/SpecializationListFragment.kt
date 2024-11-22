package ru.romanovdeveloper.damir_pracktik

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import java.util.zip.Inflater

class SpecializationListFragment : Fragment() {
    lateinit var specializationList: List<Specialization>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_specialization_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recycler : RecyclerView = view.findViewById(R.id.recyclerViewSpecialization)
        initializeList()
        val adapter : SpecializationAdapter = SpecializationAdapter(specializationList){spec, i ->
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, SpecializationFragment(spec))
                .addToBackStack("Main")
                .commit()
        }
        recycler.adapter = adapter
    }
    private fun initializeList(){
        specializationList = listOf(
            Specialization("ПБ", "39", "МЧС"),
            Specialization("ПНГ", "230,232", "МЧС"),
            Specialization("ТТО", "61", "Нет информации"),
            Specialization("МТОР", "7,8", "Нет информации"),
            Specialization("ТАК", "11", "Нет информации"),
            Specialization("ЭКБ", "1", "Экологи"),
            Specialization("РИПК", "14,15", "Нет информации"),
            Specialization("ИСП", "12,13", "Программисты"),
            Specialization("БД", "36", "Банковское дело"),
            Specialization("Б", "65", "Нет информации"),
            Specialization("РЧС", "1", "Новые специальности"),
            Specialization("КИП", "1", "Новые специальности"))
    }
}