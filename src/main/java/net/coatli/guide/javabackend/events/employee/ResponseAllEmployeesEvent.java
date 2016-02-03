package net.coatli.guide.javabackend.events.employee;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import net.coatli.guide.javabackend.core.domain.Employee;
import net.coatli.guide.javabackend.events.ResponseReadEvent;

public class ResponseAllEmployeesEvent extends ResponseReadEvent {

  private List<Employee> employees;

  public ResponseAllEmployeesEvent() {
    super();
  }

  public ResponseAllEmployeesEvent(final boolean domainFound) {
    super(domainFound);
  }

  public ResponseAllEmployeesEvent(final boolean domainFound, final List<Employee> employees) {
    this(domainFound);
    this.employees = employees;
  }

  public List<Employee> getEmployees() {
    return employees;
  }

  public void setEmployees(final List<Employee> employees) {
    this.employees = employees;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.JSON_STYLE).appendSuper(super.toString()).append("employees", employees).toString();
  }

  @Override
  public boolean equals(final Object other) {
    if (!(other instanceof ResponseAllEmployeesEvent)) {
      return false;
    }
    final ResponseAllEmployeesEvent castOther = (ResponseAllEmployeesEvent) other;
    return new EqualsBuilder().appendSuper(super.equals(other)).append(employees, castOther.employees).isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder().appendSuper(super.hashCode()).append(employees).toHashCode();
  }

}
