package com.knoldus.api.repo

import play.api.libs.json.{Format, Json}

case class InsuranceInfo(name: String, phoneNumber: String, policyNumber: String)

object InsuranceInfo{

  implicit val format: Format[InsuranceInfo] = Json.format[InsuranceInfo]
}
