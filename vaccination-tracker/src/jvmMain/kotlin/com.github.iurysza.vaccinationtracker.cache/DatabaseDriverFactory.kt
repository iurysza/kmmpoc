package com.github.iurysza.vaccinationtracker.cache

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.sqlite.driver.JdbcSqliteDriver
import java.io.File

actual class DatabaseDriverFactory {

  actual fun createDriver(): SqlDriver {
    val connectionUrl = "jdbc:sqlite:${File(".").absolutePath}/vaccinationtracker.db"
    val jdbcSqliteDriver = JdbcSqliteDriver(connectionUrl)
    runCatching { CovidVaccinationDatabase.Schema.create(jdbcSqliteDriver) }
    return jdbcSqliteDriver
  }

}