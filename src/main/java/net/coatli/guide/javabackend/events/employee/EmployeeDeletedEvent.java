package net.coatli.guide.javabackend.events.employee;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import net.coatli.guide.javabackend.events.DeletedEvent;

public class EmployeeDeletedEvent extends DeletedEvent {

  public EmployeeDeletedEvent() {
    super();
  }

  public EmployeeDeletedEvent(final boolean domainDeleted) {
    super(domainDeleted);
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.JSON_STYLE).appendSuper(super.toString()).toString();
  }

  @Override
  public boolean equals(final Object other) {
    if (!(other instanceof EmployeeDeletedEvent)) {
      return false;
    }
    final EmployeeDeletedEvent castOther = (EmployeeDeletedEvent) other;
    return new EqualsBuilder().appendSuper(super.equals(other)).isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder().appendSuper(super.hashCode()).toHashCode();
  }

}
