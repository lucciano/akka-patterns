package org.eigengo.akkapatterns.core

import akka.actor.{Props, ActorSystem}
import akka.pattern.ask
import akka.util.Timeout
import concurrent.Await
import org.eigengo.akkapatterns.core.ApplicationActor.Start


trait ServerCore {
  implicit def actorSystem: ActorSystem
  implicit val timeout: Timeout

  val application = actorSystem.actorOf(
    props = Props[ApplicationActor],
    name = "application"
  )

  application ! Start()

}
