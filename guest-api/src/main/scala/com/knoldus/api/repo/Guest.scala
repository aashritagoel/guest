package com.knoldus.api.repo

import play.api.libs.json.{Format, Json}

case class Guest(guestInformation: GuestInformation, invalidateCTCForMinor: String)

object Guest {

  implicit val format: Format[Guest] = Json.format[Guest]
}