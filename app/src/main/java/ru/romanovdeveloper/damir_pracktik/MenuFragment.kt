package ru.romanovdeveloper.damir_pracktik

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Switch
import androidx.appcompat.app.AppCompatDelegate

class MenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonTeacher:Button = view.findViewById(R.id.buttonTeacher)
        val buttonAdministrator:Button = view.findViewById(R.id.buttonAdministrator)
        val buttonSpec:Button = view.findViewById(R.id.buttonSpec)
        val buttonCollege:Button = view.findViewById(R.id.buttonCollege)
        val faqButton = view.findViewById<Button>(R.id.ButtonFAQ)
        val buttonChangeThemeApp = view.findViewById<Switch>(R.id.DarkTheme)

        buttonChangeThemeApp.setOnClickListener{
            if(buttonChangeThemeApp.isChecked)
            {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
            else
            {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

        buttonTeacher.setOnClickListener{
            openFragment(TeachersListFragment())
        }
        buttonSpec.setOnClickListener{
            openFragment(SpecializationListFragment())
        }
        buttonAdministrator.setOnClickListener{
            openFragment(AdministratorsListFragment())
        }
        buttonCollege.setOnClickListener{
            openFragment(CollegeFragment())
        }
        faqButton.setOnClickListener{
            var alertDialog = AlertDialog.Builder(view.context)
            alertDialog.apply {
                setTitle("Информация о программе")
                    setMessage("FAQ:\n\n" +
                            "Приложение создано для ознакомления с Орским Нефтеным Техникумом ( ОНТ ).\n" +
                            "Тут, Вы можете посмотреть полный список доступных для Вас, специальностей, полный список преподавателей, а так же руководства техникума.\n\n" +
                            "Ошибки/Вылеты/Предложения по улучшению:\n\n" +
                            "Разработчик - EvG3nY\n" +
                            "При возникновении проблем/ошибок/вылетов - обращаться на почту: ( helper_tech@rambler.com )\n\n" +
                            "Текущее состояние/версия приложения - Beta/v1.1.0")
                    .setPositiveButton("Close") {
                        dialog, id -> dialog.cancel()
                    }
                }.create().show()
            }
        }
    private fun openFragment(Fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView,Fragment)
            .addToBackStack("mainStack")
            .commit()
    }
}
