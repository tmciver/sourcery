package com.maxwellhealth.sourcery

trait Entity[I] extends Identifiable[I] {

  // @todo Consider returning Either[Error, Entity[I]] since there is the
  // possibility of error: namely that the entity ID in the event may not match
  // the ID of this entity.
  def applyEvent(event: Event[I]): Entity[I]
}
