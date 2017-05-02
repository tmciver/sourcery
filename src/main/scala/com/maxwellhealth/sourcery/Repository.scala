package com.maxwellhealth.sourcery

trait Repository[I] {

  final def getById(id: I)(implicit store: EventStore[I]): Option[Entity[I]] = {
    val eventsOpt = store.eventsFor(id)
    eventsOpt.map(_.foldLeft(this.init) { (entity, event) => entity.applyEvent(event) })
  }

  // Implementions should return an "empty" entity
  def init: Entity[I]
}
