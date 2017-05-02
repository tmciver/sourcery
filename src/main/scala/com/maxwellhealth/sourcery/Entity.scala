package com.maxwellhealth.sourcery

trait Entity[I] extends Identifiable[I] {
  def applyEvent(event: Event[I]): Entity[I]
}
