package com.onoh.mystarwarsapp.ui.catalogue

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.onoh.mystarwarsapp.R
import com.onoh.mystarwarsapp.ui.film.FilmActivity
import com.onoh.mystarwarsapp.ui.people.PeopleActivity
import com.onoh.mystarwarsapp.ui.planet.PlanetActivity
import com.onoh.mystarwarsapp.ui.species.SpeciesActivity
import com.onoh.mystarwarsapp.ui.starship.StarshipActivity
import com.onoh.mystarwarsapp.ui.vehicles.VehiclesActivity
import kotlinx.android.synthetic.main.item_catalogue.*

class CatalogueFragment : Fragment(), View.OnClickListener {

    private lateinit var catalogueViewModel: CatalogueViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_catalogue,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btn_catalogue_people.setOnClickListener(this)
        btn_catalogue_films.setOnClickListener(this)
        btn_catalogue_starships.setOnClickListener(this)
        btn_catalogue_vehicles.setOnClickListener(this)
        btn_catalogue_species.setOnClickListener(this)
        btn_catalogue_planet.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_catalogue_people -> {
                val intentPeople = Intent(context,PeopleActivity::class.java)
                startActivity(intentPeople)
            }
            R.id.btn_catalogue_films -> {
                val intentFilm = Intent(context,FilmActivity::class.java)
                startActivity(intentFilm)
            }
            R.id.btn_catalogue_starships -> {
                val intentStarship = Intent(context,StarshipActivity::class.java)
                startActivity(intentStarship)
            }
            R.id.btn_catalogue_vehicles -> {
                val intentVehicles = Intent(context,VehiclesActivity::class.java)
                startActivity(intentVehicles)
            }
            R.id.btn_catalogue_species -> {
                val intentSpecies = Intent(context,SpeciesActivity::class.java)
                startActivity(intentSpecies)
            }
            R.id.btn_catalogue_planet -> {
                val intentPlanet = Intent(context,PlanetActivity::class.java)
                startActivity(intentPlanet)
            }

        }
    }
}
