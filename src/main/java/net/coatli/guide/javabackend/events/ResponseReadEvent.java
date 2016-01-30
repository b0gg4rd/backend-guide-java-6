package net.coatli.guide.javabackend.events;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ResponseReadEvent {

  protected final boolean domainFound;

  public ResponseReadEvent(final boolean domainFound) {
    this.domainFound = domainFound;
  }

  public boolean isDomainFound() {
    return domainFound;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.JSON_STYLE).append("domainFound", domainFound).toString();
  }

  @Override
  public boolean equals(final Object other) {
    if (!(other instanceof ResponseReadEvent)) {
      return false;
    }
    final ResponseReadEvent castOther = (ResponseReadEvent) other;
    return new EqualsBuilder().append(domainFound, castOther.domainFound).isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder().append(domainFound).toHashCode();
  }

}
