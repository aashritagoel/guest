package com.knoldus.api

import akka.NotUsed
import com.knoldus.api.repo.JsonObject
import com.lightbend.lagom.scaladsl.api.{Descriptor, Service, ServiceCall}

trait GuestService extends Service {

  def consumeGuest(): ServiceCall[NotUsed, JsonObject]

  override final def descriptor: Descriptor = {
    import Service._
    // @formatter:off
    named("welcome")
      .withCalls(
        pathCall("/consume/guest", consumeGuest _)
      )
      .withAutoAcl(true)
    // @formatter:on
  }
}
