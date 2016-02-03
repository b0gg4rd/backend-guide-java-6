package net.coatli.guide.javabackend.core.domain;

import java.util.Date;
import java.util.UUID;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import net.coatli.guide.javabackend.core.domain.catalog.Catalog;

/**
 * Element of the domain that represent an Employee.
 */
public class Employee {

  private final UUID key;
  private String firstName;
  private String paternalSurname;
  private String maternalSurname;
  private Date birthday;
  private Catalog department;
  private Catalog rol;
  private Catalog status;

  public Employee() {
    this.key = UUID.randomUUID();
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(final String firstName) {
    this.firstName = firstName;
  }

  public String getPaternalSurname() {
    return paternalSurname;
  }

  public void setPaternalSurname(final String paternalSurname) {
    this.paternalSurname = paternalSurname;
  }

  public String getMaternalSurname() {
    return maternalSurname;
  }

  public void setMaternalSurname(final String maternalSurname) {
    this.maternalSurname = maternalSurname;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(final Date birthday) {
    this.birthday = birthday;
  }

  public Catalog getDepartment() {
    return department;
  }

  public void setDepartment(final Catalog department) {
    this.department = department;
  }

  public Catalog getRol() {
    return rol;
  }

  public void setRol(final Catalog rol) {
    this.rol = rol;
  }

  public Catalog getStatus() {
    return status;
  }

  public void setStatus(final Catalog status) {
    this.status = status;
  }

  public UUID getKey() {
    return key;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.JSON_STYLE).appendSuper(super.toString()).append("key", key).append("firstName", firstName).append("paternalSurname", paternalSurname).append("maternalSurname", maternalSurname).append("birthday", birthday).append("department", department).append("rol", rol).append("status", status).toString();
  }

  @Override
  public boolean equals(final Object other) {
    if (!(other instanceof Employee)) {
      return false;
    }
    final Employee castOther = (Employee) other;
    return new EqualsBuilder().append(key, castOther.key).append(firstName, castOther.firstName).append(paternalSurname, castOther.paternalSurname).append(maternalSurname, castOther.maternalSurname).append(birthday, castOther.birthday).append(department, castOther.department).append(rol, castOther.rol).append(status, castOther.status).isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder().append(key).append(firstName).append(paternalSurname).append(maternalSurname).append(birthday).append(department).append(rol).append(status).toHashCode();
  }

}
