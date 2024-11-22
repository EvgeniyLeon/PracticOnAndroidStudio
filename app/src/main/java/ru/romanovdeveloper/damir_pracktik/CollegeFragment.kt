package ru.romanovdeveloper.damir_pracktik

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.TextView
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView
import com.yandex.runtime.image.ImageProvider

class CollegeFragment : Fragment() {

    private lateinit var  mapView: MapView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        MapKitFactory.setApiKey("02128b43-7f6a-4452-9f49-edb04a796fc9")
        MapKitFactory.initialize(requireContext())
        return inflater.inflate(R.layout.fragment_college, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val title: TextView = view.findViewById(R.id.textViewCollegeInfo)
        val info: TextView = view.findViewById(R.id.textViewCollegeMainInfo)
        val rate: TextView = view.findViewById(R.id.textViewCollegeRate)
        val lastinfo: TextView = view.findViewById(R.id.textViewCollegeLastInfo)
        mapView = view.findViewById(R.id.mapview)
        MapKitFactory.getInstance().onStart()
        mapView.onStart()
        mapView.map.move(
            CameraPosition(
                Point(51.245134, 58.462665),
                /* zoom = */ 19.25f,
                /* azimuth = */ 175.0f,
                /* tilt = */ 27.0f
            )
        )
        title.text = resources.getText(R.string.collegeinfo)
        info.text = resources.getText(R.string.collegemaininfo)
        rate.text = resources.getText(R.string.collegerate)
        lastinfo.text = resources.getText(R.string.collegelastinfo)
    }
    override fun onStop() {
        mapView.onStop()
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }
}