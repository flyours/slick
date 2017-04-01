package com.jeff

import com.jeff.Tables._
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration

// The main application
object TestSlick extends App {
  val db = Database.forConfig("h2mem1")
  try {

    // The query interface for the Suppliers table
    Await.result(db.run(McAccount.result).map(allUsers=>allUsers.foreach(println)), Duration.Inf)

  } finally db.close
}
