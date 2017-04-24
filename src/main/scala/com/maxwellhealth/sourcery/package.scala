package com.maxwellhealth
package object sourcery {

  type Handled[T, E] = Either[E, List[Event[T]]]

  type EventListeners[T, E] = Map[Event[T], List[EventListener[T, E]]]

  type EventListener[T, E] = Event[T] => Either[E, String]
}

