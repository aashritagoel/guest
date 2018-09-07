package com.knoldus.api.repo

import play.api.libs.json.{Format, Json}

case class JsonObject(guests: List[Guest])

object JsonObject{

  implicit val format: Format[JsonObject] = Json.format[JsonObject]
}
