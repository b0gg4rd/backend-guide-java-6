package net.coatli.guide.javabackend.events.employee;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import net.coatli.guide.javabackend.core.domain.Employee;
import net.coatli.guide.javabackend.events.UpdateEvent;

public class UpdateEmployeeEvent extends UpdateEvent {

  private Employee employee;

  public Employee getEmployee() {
    return employee;
  }

  public void setEmployee(final Employee employee) {
    this.employee = employee;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.JSON_STYLE).append("employee", employee).toString();
  }

  @Override
  public boolean equals(final Object other) {
    if (!(other instanceof UpdateEmployeeEvent)) {
      return false;
    }
    final UpdateEmployeeEvent castOther = (UpdateEmployeeEvent) other;
    return new EqualsBuilder().append(employee, castOther.employee).isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder().append(employee).toHashCode();
  }
}
