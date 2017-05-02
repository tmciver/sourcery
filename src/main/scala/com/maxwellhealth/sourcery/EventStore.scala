package com.maxwellhealth.sourcery

trait EventStore[I] {
  def eventsFor(id: I): Option[List[Event[I]]]

  // @todo should return a type giving an error value
  def save(event: Event[I]): Unit

  // @todo ibid
  def save(events: List[Event[I]]): Unit = events.foreach(this.save(_))
}
