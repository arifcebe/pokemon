package com.arifcebe.pokemon.core.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.arifcebe.pokemon.data.room_model.PokemonRoomDao
import com.arifcebe.pokemon.data.room_model.PokemonRoomModel
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

@Database(entities = arrayOf(PokemonRoomModel::class), version = 1, exportSchema = false)
abstract class PokemonDatabase : RoomDatabase() {

    abstract fun pokemonRoomDao() : PokemonRoomDao

    companion object {

        @Volatile
        private var INSTANCE: PokemonDatabase? = null
        private const val NUMBER_OF_THREADS = 1
        val databaseWriteExecutor: ExecutorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS)
        fun getDataseClient(context: Context) : PokemonDatabase {

            if (INSTANCE != null) return INSTANCE!!

            synchronized(this) {

                INSTANCE = Room
                    .databaseBuilder(context, PokemonDatabase::class.java, "pokemon_database")
                    .fallbackToDestructiveMigration()
                    .build()

                return INSTANCE!!

            }
        }

    }

}