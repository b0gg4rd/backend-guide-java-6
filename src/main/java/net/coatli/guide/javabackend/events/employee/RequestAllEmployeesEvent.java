package net.coatli.guide.javabackend.events.employee;

import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class RequestAllEmployeesEvent {

  private Integer departmentKey;
  private Integer rolKey;
  private Date birthday;

  public Integer getDepartmentKey() {
    return departmentKey;
  }

  public void setDepartmentKey(final Integer departmentKey) {
    this.departmentKey = departmentKey;
  }

  public Integer getRolKey() {
    return rolKey;
  }

  public void setRolKey(final Integer rolKey) {
    this.rolKey = rolKey;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(final Date birthday) {
    this.birthday = birthday;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.JSON_STYLE).appendSuper(super.toString()).append("departmentKey", departmentKey).append("rolKey", rolKey).append("birthday", birthday).toString();
  }

  @Override
  public boolean equals(final Object other) {
    if (!(other instanceof RequestAllEmployeesEvent)) {
      return false;
    }
    final RequestAllEmployeesEvent castOther = (RequestAllEmployeesEvent) other;
    return new EqualsBuilder().append(departmentKey, castOther.departmentKey).append(rolKey, castOther.rolKey).append(birthday, castOther.birthday).isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder().append(departmentKey).append(rolKey).append(birthday).toHashCode();
  }

}
