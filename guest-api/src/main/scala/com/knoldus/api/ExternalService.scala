package com.knoldus.api

import akka.NotUsed
import com.knoldus.api.repo.JsonObject
import com.lightbend.lagom.scaladsl.api.{Descriptor, Service, ServiceCall}

trait ExternalService extends Service {

  def getGuest: ServiceCall[NotUsed,JsonObject]

  override final def descriptor: Descriptor = {
    import Service._
    // @formatter:off
    named("external-service")
      .withCalls(
        pathCall("/deepakmehra10/227713bfa0aded2196059d6a623ea4e2/raw", getGuest _)
      ).withAutoAcl(true)
    // @formatter:on
  }
}
