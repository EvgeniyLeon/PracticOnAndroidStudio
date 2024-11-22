package ru.romanovdeveloper.damir_pracktik

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler

class AdministratorsListFragment : Fragment() {

    lateinit var administrationList : List<Administration>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_administrators_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recycler : RecyclerView = view.findViewById(R.id.recyclerViewAdministration)
        initializeList()
        val adapter : AdministrationAdapter = AdministrationAdapter(administrationList){admin, i ->
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, AdministrationFragment(admin))
                .addToBackStack("Main")
                .commit()
        }
        recycler.adapter = adapter
    }
    private fun initializeList(){
        administrationList = listOf(
            Administration("Татьяна", "Кочеткова", "Борисовна", "Директор", "Телефон 8(3537)21-66-29"),
            Administration("Оксана", "Кузниченко", "Анатольевна", "Заместитель директора по УР", ""),
            Administration("Андрей", "Фролков", "Александрович", "Заместитель директора по УПР", ""),
            Administration("Ольга", "Косынцева", "Владимировна", "Заместитель директора по УВР", ""),
            Administration("Игорь", "Финк", "Валерьевич", "Заместитель директора по УИТ", ""),
            Administration("Сергей", "Емельянов", "Алексеевич", "Заместитель директора по АХЧ", ""),
            Administration("Станислав", "Рузанов", "Юрьевич", "Заместитель директора по безопасности", ""),
            Administration("Марина", "Мазина", "Павловна", "Главный бухгалтер", ""))
    }
}