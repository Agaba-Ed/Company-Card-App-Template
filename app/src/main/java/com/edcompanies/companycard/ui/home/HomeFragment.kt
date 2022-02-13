package com.edcompanies.companycard.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.edcompanies.companycard.R
import com.edcompanies.companycard.adapter.TeamAdapter
import com.edcompanies.companycard.data.DataManager
import com.edcompanies.companycard.databinding.FragmentHomeBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class HomeFragment : Fragment(),OnMapReadyCallback {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var map:GoogleMap

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        //Obtain the Support map fragment and get notified when the map is ready to use
        val mapFragment= childFragmentManager.findFragmentById(R.id.map_frag) as SupportMapFragment
        mapFragment.getMapAsync(this)
        val dataset= DataManager().loadMembers()
        binding.teamRecyclerView.adapter=TeamAdapter(dataset)
        binding.teamRecyclerView.layoutManager=GridLayoutManager(context,3)
        binding.location.text="Global Health Collaborative-Boma B, Mbarara"



        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map=googleMap

        //These corordinates represent the co-ordinates of my address
        val latitude=-0.6138404046109238
        val longitude=30.657843694271993
        val zoomLevel=15f


        val homeLatLng=LatLng(latitude, longitude)
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(homeLatLng,zoomLevel))
        map.addMarker(MarkerOptions().position(homeLatLng))



    }


}