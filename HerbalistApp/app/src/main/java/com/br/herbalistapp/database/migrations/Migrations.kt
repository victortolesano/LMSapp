package com.br.herbalistapp.database.migrations

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase

import android.arch.persistence.room.migration.Migration
import android.content.Context
import android.util.Log
import com.br.herbalistapp.LMSApplication
import com.br.herbalistapp.database.DatabaseLMS


object Migrations {
    val MIGRATION_1_2: Migration = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("ALTER TABLE user ADD COLUMN syncd INTEGER NOT NULL DEFAULT 0")
        }
    }
}
