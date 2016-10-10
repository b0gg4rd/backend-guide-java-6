package net.coatli.guide.javabackend.core.domain;

import java.util.Date;
import java.util.UUID;

import javax.xml.bind.annotation.XmlElement;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Element of the domain that represent an Employee.
 */
public class Employee {

  @XmlElement(name = "key")
  private final UUID key;
  private String name;
  private Date birthday;

  public Employee() {
    this.key = UUID.randomUUID();
  }

  public String getName() {
    return name;
  }

  public Employee setName(final String name) {
    this.name = name;

    return this;
  }

  public Date getBirthday() {
    return birthday;
  }

  public Employee setBirthday(final Date birthday) {
    this.birthday = birthday;

    return this;
  }

  public UUID getKey() {
    return key;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.JSON_STYLE).appendSuper(super.toString()).append("key", key)
        .append("name", name).append("birthday", birthday).toString();
  }

  @Override
  public boolean equals(final Object other) {
    if (this == other) {
      return true;
    }
    if (!(other instanceof Employee)) {
      return false;
    }
    final Employee castOther = (Employee) other;
    return new EqualsBuilder().append(key, castOther.key).append(name, castOther.name)
        .append(birthday, castOther.birthday).isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder().append(key).append(name).append(birthday).toHashCode();
  }

}
