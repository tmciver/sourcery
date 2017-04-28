package com.maxwellhealth.sourcery

import scala.concurrent.Future

// Self-handling command
trait Command[I, E] extends Identifiable[I] {
  def handle: Handled[I, E]

  // final def dispatch(listeners: EventListeners[I]): Unit = {
  //   val eitherOfOptionOfListOfFutureOfList = handle.map(events => {
  //     val listOfOptionOfFutureOfList = events.map(event => {
  //       val optionOfFutureOfList = listeners.get(event.getClass).map(listeners => {
  //         Future.sequence(listeners.map(listener => listener(event)))
  //       })
  //       optionOfFutureOfList
  //     })

  //     // convert List of Option to Option of List
  //     val optionOfListOfFutureOfList = listOfOptionOfFutureOfList.sequence
  //     optionOfListOfFutureOfList
  //   })
    
  // }

  // final def dispatch(listeners: EventListeners[I]): Unit = {
  //   val eitherEvents = this.handle
  //   val eitherOfFutureOfList = eitherEvents.map(events => {
  //     val futures = for {
  //     event <- events
  //     listener <- listeners.getOrElse(event.getClass, List())
  //     _ = listener(event)
  //     } yield ()
  //     Future.sequence(futures)
  //   })

  //   val listenersFuture = eitherOfFutureOfList.getOrElse(Future.failed)

  //   listenersFuture.map(_ => eitherEvents.getOrElse(List()).foldLeft(this)(event => {

  //   }))
  // }

  final def dispatch(listeners: EventListeners[I]): Unit = {
    val events = this.handle
    events.map(_.foreach(event => {
      val theListeners = listeners.getOrElse(event.getClass, List())
      theListeners.foreach(listener => listener(event))
    }))
  }
}
