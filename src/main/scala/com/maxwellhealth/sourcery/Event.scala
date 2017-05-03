package com.maxwellhealth.sourcery

import java.time.Instant

trait Event[T] extends Identifiable[T] {
  def commandId: T
  def entityId: T
  def occurredOn: Instant
}
