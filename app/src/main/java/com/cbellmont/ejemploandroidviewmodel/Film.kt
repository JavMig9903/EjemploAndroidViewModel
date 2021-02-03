package com.cbellmont.ejemploandroidviewmodel

class Film(var id : Int, var name : String, var intro : String) {
    fun getUrlImage() : String {
        return when (id) {
            1 -> "https://upload.wikimedia.org/wikipedia/en/4/40/Star_Wars_Phantom_Menace_poster.jpg"
            2 -> "https://upload.wikimedia.org/wikipedia/en/3/32/Star_Wars_-_Episode_II_Attack_of_the_Clones_%28movie_poster%29.jpg"
            3 -> "https://upload.wikimedia.org/wikipedia/en/9/93/Star_Wars_Episode_III_Revenge_of_the_Sith_poster.jpg"
            4 -> "https://upload.wikimedia.org/wikipedia/en/8/87/StarWarsMoviePoster1977.jpg"
            5 -> "https://upload.wikimedia.org/wikipedia/en/3/3c/SW_-_Empire_Strikes_Back.jpg"
            6 -> "https://upload.wikimedia.org/wikipedia/en/b/b2/ReturnOfTheJediPoster1983.jpg"
            7 ->  "https://static.wikia.nocookie.net/esstarwars/images/2/2e/El_Despertar_de_la_Fuerza_Poster.jpg/revision/latest/scale-to-width-down/350?cb=20180412014438"
            8 -> "https://static.wikia.nocookie.net/esstarwars/images/9/9a/Los%C3%9AltimosJediPosterFinal.jpg/revision/latest/scale-to-width-down/338?cb=20200210102917"
            9 -> "https://pics.filmaffinity.com/star_wars_the_rise_of_skywalker-619389738-mmed.jpg"
            else -> "https://upload.wikimedia.org/wikipedia/commons/thumb/7/7f/George_Lucas.jpg/330px-George_Lucas.jpg"
        }
    }
}