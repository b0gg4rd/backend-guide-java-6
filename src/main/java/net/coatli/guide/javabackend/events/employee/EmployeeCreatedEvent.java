package net.coatli.guide.javabackend.events.employee;

import java.util.UUID;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import net.coatli.guide.javabackend.events.CreatedEvent;

public class EmployeeCreatedEvent extends CreatedEvent {

  private UUID newKey;

  public EmployeeCreatedEvent() {
  }

  public EmployeeCreatedEvent(final boolean domainCreated) {
    this.domainCreated = domainCreated;
  }

  public EmployeeCreatedEvent(final boolean domainCreated, final UUID newKey) {
    this(domainCreated);
    this.newKey = newKey;
  }

  public UUID getNewKey() {
    return newKey;
  }

  public void setNewKey(final UUID newKey) {
    this.newKey = newKey;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.JSON_STYLE).appendSuper(super.toString()).append("newKey", newKey).toString();
  }

  @Override
  public boolean equals(final Object other) {
    if (!(other instanceof EmployeeCreatedEvent)) {
      return false;
    }
    final EmployeeCreatedEvent castOther = (EmployeeCreatedEvent) other;
    return new EqualsBuilder().appendSuper(super.equals(other)).append(newKey, castOther.newKey).isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder().appendSuper(super.hashCode()).append(newKey).toHashCode();
  }

}
