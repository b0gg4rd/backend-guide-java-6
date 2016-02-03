package net.coatli.guide.javabackend.events.employee;

import net.coatli.guide.javabackend.events.UpdatedEvent;

public class EmployeeUpdatedEvent extends UpdatedEvent {

  public EmployeeUpdatedEvent() {
    super();
  }

  public EmployeeUpdatedEvent(final boolean domainUpdated) {
    super(domainUpdated);
  }

}
