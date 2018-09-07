package com.knoldus.api.repo

import com.knoldus.api._
import play.api.libs.json.{Format, Json}

case class GuestInformation(guestReservationId: GuestReservationId, personalInfo: PersonalInfo, contactInfo: ContactInfo,
                            travelPhoto: TravelPhoto, emergencyContactInfo: EmergencyContactInfo, insuranceInfo: InsuranceInfo,
                            immigrationInfo: ImmigrationInfo)

object GuestInformation {

  implicit val format: Format[GuestInformation] = Json.format[GuestInformation]
}