package com.maxwellhealth.sourcery

import scala.collection.mutable.Map

final case class InMemoryEventStore[I]() extends EventStore[I] {

  val store: Map[I, List[Event[I]]] = Map()

  def eventsFor(id: I): Option[List[Event[I]]] = store.get(id)

  def save(event: Event[I]) = {
    // get the list of events associated with the ID for the entity whose event
    // this is.
    val events = store.getOrElseUpdate(event.entityId, List())

    // Add the given event to the head of the list.
    val updatedEvents = event :: events

    // Then put this updated event list back into the map.
    store(event.entityId) = updatedEvents
  }
}
