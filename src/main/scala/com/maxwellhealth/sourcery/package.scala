package com.maxwellhealth
package object sourcery {

  // I: Identifier type
  // E: Error type
  type Handled[I, E] = Either[E, List[Event[I]]]

  // I: Identifier type
  // V: type of Event
  //type EventListeners[I] = Map[Class[T] forSome {type T <: Event[I]}, List[EventListener[I]]]
  type EventListeners[I] = Map[Class[_ <: Event[I]], List[EventListener[I]]]

  // I: Identifier type
  type EventListener[I] = Event[I] => Unit
}

