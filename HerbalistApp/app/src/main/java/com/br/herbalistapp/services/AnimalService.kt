package com.br.herbalistapp.services

import android.content.Context
import com.br.herbalistapp.domain.Animal

object AnimalService {
    fun getAnimals(context: Context): List<Animal> {
        return (1..10).map { Animal("kitty", "kitty kat", "http") }
    }
}