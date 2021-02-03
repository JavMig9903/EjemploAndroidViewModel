package com.cbellmont.ejemploandroidviewmodel

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cbellmont.ejemploandroidviewmodel.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var model :MainActivityViewModel
    private lateinit var binding: ActivityMainBinding
    private var adapter : FilmsAdapter = FilmsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Log.d(MainActivity::class.java.simpleName, "Iniciando ViewModel")
        model = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        //Log.d(MainActivity::class.java.simpleName, "ViewModel iniciado")
        createRecyclerView()
        binding.pbLoading.visibility = View.GONE

        button4.setOnClickListener {
            dowloadAllFilms(1)
            binding.pbLoading.visibility = View.VISIBLE
        }


        button5.setOnClickListener {
            binding.pbLoading.visibility = View.VISIBLE
            dowloadAllFilms(2)
        }


        button6.setOnClickListener {
            binding.pbLoading.visibility = View.VISIBLE
            dowloadAllFilms(3)
        }

        button7.setOnClickListener {
            binding.pbLoading.visibility = View.VISIBLE
            dowloadAllFilms(0)
        }

    }

    private fun createRecyclerView() {
        binding.filmRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.filmRecyclerView.adapter = adapter
    }

    private fun dowloadAllFilms(numero: Int){
        CoroutineScope(IO).launch {
            var listilla :List<Film> = model.dowloadtodas()
            when(numero){
                0 -> listilla = model.dowloadtodas()
                1 -> listilla = model.dowloadprimera()
                2 -> listilla = model.dowloadsegunda()
                3 -> listilla = model.dowloadtercera()
                else ->"Nada"
            }
            setAdapterOnMainThread(listilla as MutableList<Film>)
        }
    }

    private suspend fun loadFilmInBackground() : MutableList<Film>{
        // El withContext(Dispatchers.IO) no es estrictamente necesario. Lo ponemos solo por seguridad.
        return withContext(Dispatchers.IO) {
            return@withContext model.getFilms()
        }
    }

    private suspend fun setAdapterOnMainThread(filmsList: MutableList<Film>) {
        withContext(Dispatchers.Main) {
            adapter.updateFilms(filmsList)
            pbLoading.visibility = View.GONE
        }
    }

}