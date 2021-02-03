package com.cbellmont.ejemploandroidviewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext


class MainActivityViewModel  : ViewModel() {

    private val films = mutableListOf<Film>()

    fun downloadFilms() {
        films.addAll(mutableListOf(
            Film(1, "STAR WARS I: La Amenaza Fantasma", "aaaa"),
            Film(2, "STAR WARS II: El Ataque de los Clones", "aaaa"),
            Film(3, "STAR WARS III: La Venganza de los Sith", "aaaa"),
            Film(4, "STAR WARS IV: Una Nueva Esperanza", "aaaa"),
            Film(5, "STAR WARS V: El Imperio Contraataca", "aaaa"),
            Film(6, "STAR WARS VI: El Retorno del Jedi", "aaaa"),
            Film(7, "STAR WARS VII: El Despertar de la Fuerza", "aaaa"),
            Film(8, "STAR WARS VIII: Los Útimos Jedi", "aaaa"),
            Film(9, "STAR WARS VIV: El Ascenso de Skywalker", "aaaa")
        ))
    }
    suspend fun getFilms(): MutableList<Film> {
        if (films.isEmpty()){
            delay(5000)
            downloadFilms()
        }
        return films
    }

    suspend fun dowloadtodas() : MutableList<Film>{
        return withContext(Dispatchers.IO) {
            delay(1000)
            if (films.isEmpty()) {
                downloadFilms()
            }
            return@withContext films
        }
    }

    suspend fun dowloadprimera() : MutableList<Film>{
        return withContext(Dispatchers.IO) {
            delay(1000)
            if (films.isEmpty()) {
                downloadFilms()
            }
            return@withContext films.subList(0,3)
        }
    }

    suspend fun dowloadsegunda() : MutableList<Film>{
        return withContext(Dispatchers.IO) {
            delay(1000)
            if (films.isEmpty()) {
                downloadFilms()
            }
            return@withContext films.subList(3,6)
        }
    }

    suspend fun dowloadtercera() : MutableList<Film>{
        return withContext(Dispatchers.IO) {
            delay(1000)
            if (films.isEmpty()) {
                downloadFilms()
            }
            return@withContext films.subList(6,9)
        }
    }

}