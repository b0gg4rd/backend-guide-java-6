package net.coatli.guide.javabackend.events.employee;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import net.coatli.guide.javabackend.core.domain.Employee;
import net.coatli.guide.javabackend.events.ResponseReadEvent;

public class ResponseEmployeeEvent extends ResponseReadEvent {

  private Employee employee;

  public ResponseEmployeeEvent(final boolean domainFound) {
    super(domainFound);
  }

  public ResponseEmployeeEvent(final boolean domainFound, final Employee employee) {
    this(domainFound);
    this.employee = employee;
  }

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
    if (!(other instanceof ResponseEmployeeEvent)) {
      return false;
    }
    final ResponseEmployeeEvent castOther = (ResponseEmployeeEvent) other;
    return new EqualsBuilder().append(employee, castOther.employee).isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder().append(employee).toHashCode();
  }

}
