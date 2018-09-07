package com.knoldus.api.repo

import play.api.libs.json.{Format, Json}

case class TravelPhoto(base64Image: String, photoId: Double)

object TravelPhoto{

  implicit val format: Format[TravelPhoto] = Json.format[TravelPhoto]
}
