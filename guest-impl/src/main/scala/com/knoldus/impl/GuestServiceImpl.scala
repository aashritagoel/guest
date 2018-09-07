package com.knoldus.impl


import com.knoldus.api.{ExternalService, GuestService}
import com.knoldus.api.repo.JsonObject
import com.lightbend.lagom.scaladsl.api.ServiceCall

import scala.concurrent.{ExecutionContext, Future}

class GuestServiceImpl(externalService: ExternalService)(implicit ec: ExecutionContext) extends GuestService {

  override def consumeGuest() = ServiceCall { _ =>
    val result: Future[JsonObject] = externalService.getGuest.invoke()
    result.map(response => response)
  }
}