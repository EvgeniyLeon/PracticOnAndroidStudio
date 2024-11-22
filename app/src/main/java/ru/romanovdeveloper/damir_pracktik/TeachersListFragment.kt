package ru.romanovdeveloper.damir_pracktik

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TeachersListFragment : Fragment() {

    lateinit var teachers :List<Teacher>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_teachers_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.requireViewById<RecyclerView>(R.id.RecyclerViewTeacher)
        initializeList()
        var adapter : TeacherAdapter = TeacherAdapter(teachers){ teacher, i ->
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, TeacherFragment(teacher))
                .addToBackStack("Main")
                .commit()
        }
        recyclerView.adapter = adapter
    }

    private fun initializeList(){
        teachers = listOf(
            Teacher("Алексей", "Саладай", "Владимирович", "Специальные дисциплины, УП и ПП по 09.02.07 Информационные системы и программирование", ""),
            Teacher("Ольга", "Москвина", "Константиновна", "Русский язык, литература", ""),
            Teacher("Наталья", "Леднева", "Геннадьевна", "Физическая культура", ""),
            Teacher("Ольга", "Вавилина", "Анатольевна", "Основы безопасности жизнедеятельности, \n" +
                    "Безопасность жизнедеятельности, \n" +
                    "Физика,\n" +
                    "ОП 01 Теоретические основы теплотехники и гидравлики", ""),
            Teacher("Марина", "Галкина", "Федоровна", "Химия\n" +
                    "Основы неорганической химии\n" +
                    "Органическая химия", ""),
            Teacher("Туленды", "Именжанов", "Салимович", "Физическая культура", ""),
            Teacher("Дина", "Камалова", "Амантаевна", "Иностранный язык\n" +
                    "Иностранный язык в профессиональной деятельности", ""),
            Teacher("Гульнара", "Карымова", "Буляковна", "Русский язык\n" +
                    "Литература\n" +
                    "Психология общения", ""),
            Teacher("Алексей", "Горнеев", "Михайлович", "УП  по 09.02.07", ""),
            Teacher("Ринат", "Жунусов", "Рашитович", "Специальные дисциплины по 18.02.09", ""),
            Teacher("Семен", "Пиличев", "Александрович", "Специальные дисциплины, УП  по 09.02.07", ""))
    }
}