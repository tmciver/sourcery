package com.maxwellhealth.sourcery

// Self-handling command
trait Command[T,E] extends Identifiable[T] {
  def handle: Handled[T,E]
  final def dispatch(listeners: EventListeners[T, E]) = Left("Not yet implemented.")
}
