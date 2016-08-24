package net.coatli.guide.javabackend.events.employee;

import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import net.coatli.guide.javabackend.events.RequestReadEvent;

public class RequestAllEmployeesEvent extends RequestReadEvent {

  private String name;
  private Date birthday;

  public RequestAllEmployeesEvent() {
  }

  public String getName() {
    return name;
  }

  public RequestAllEmployeesEvent setName(final String name) {
    this.name = name;

    return this;
  }

  public Date getBirthday() {
    return birthday;
  }

  public RequestAllEmployeesEvent setBirthday(final Date birthday) {
    this.birthday = birthday;

    return this;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.JSON_STYLE).appendSuper(super.toString()).append("name", name)
        .append("birthday", birthday).toString();
  }

  @Override
  public boolean equals(final Object other) {
    if (this == other) {
      return true;
    }
    if (!(other instanceof RequestAllEmployeesEvent)) {
      return false;
    }
    final RequestAllEmployeesEvent castOther = (RequestAllEmployeesEvent) other;
    return new EqualsBuilder().append(name, castOther.name).append(birthday, castOther.birthday).isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder().append(name).append(birthday).toHashCode();
  }

}
