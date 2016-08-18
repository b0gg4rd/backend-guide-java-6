package net.coatli.guide.javabackend.events.employee;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import net.coatli.guide.javabackend.events.DeletedEvent;

/**
 * @author boggard
 *
 */
public class EmployeeDeletedEvent extends DeletedEvent {
  
  private String employeeKey;

  public EmployeeDeletedEvent() {
    super();
  }

  public EmployeeDeletedEvent(final boolean domainDeleted) {
    super(domainDeleted);
  }

  public String getEmployeeKey() {
    return employeeKey;
  }

  public EmployeeDeletedEvent setEmployeeKey(String employeeKey) {
    this.employeeKey = employeeKey;
  
    return this;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.JSON_STYLE).appendSuper(super.toString())
        .append("employeeKey", employeeKey).toString();
  }

  @Override
  public boolean equals(final Object other) {
    if (this == other) {
      return true;
    }
    if (!(other instanceof EmployeeDeletedEvent)) {
      return false;
    }
    EmployeeDeletedEvent castOther = (EmployeeDeletedEvent) other;
    return new EqualsBuilder().appendSuper(super.equals(other)).append(employeeKey, castOther.employeeKey).isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder().appendSuper(super.hashCode()).append(employeeKey).toHashCode();
  }

}
