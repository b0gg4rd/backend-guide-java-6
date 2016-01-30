package net.coatli.guide.javabackend.events.employee;

import net.coatli.guide.javabackend.events.DeletedEvent;

public class EmployeeDeletedEvent extends DeletedEvent {

  public EmployeeDeletedEvent(final boolean domainDeleted) {
    super(domainDeleted);
  }

}
