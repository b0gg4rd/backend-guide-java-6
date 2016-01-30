package net.coatli.guide.javabackend.events.employee;

import java.util.UUID;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import net.coatli.guide.javabackend.events.DeleteEvent;

public class DeleteEmployeeEvent extends DeleteEvent {

  private UUID key;

  public UUID getKey() {
    return key;
  }

  public void setKey(final UUID key) {
    this.key = key;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.JSON_STYLE).append("key", key).toString();
  }

  @Override
  public boolean equals(final Object other) {
    if (!(other instanceof DeleteEmployeeEvent)) {
      return false;
    }
    final DeleteEmployeeEvent castOther = (DeleteEmployeeEvent) other;
    return new EqualsBuilder().append(key, castOther.key).isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder().append(key).toHashCode();
  }

}
