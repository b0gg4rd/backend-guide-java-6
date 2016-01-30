package net.coatli.guide.javabackend.events;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class CreatedEvent {

  protected final boolean domainCreated;

  public CreatedEvent(final boolean domainCreated) {
    this.domainCreated = domainCreated;
  }

  public boolean isDomainCreated() {
    return domainCreated;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.JSON_STYLE).append("domainCreated", domainCreated).toString();
  }

  @Override
  public boolean equals(final Object other) {
    if (!(other instanceof CreatedEvent)) {
      return false;
    }
    final CreatedEvent castOther = (CreatedEvent) other;
    return new EqualsBuilder().append(domainCreated, castOther.domainCreated).isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder().append(domainCreated).toHashCode();
  }

}
