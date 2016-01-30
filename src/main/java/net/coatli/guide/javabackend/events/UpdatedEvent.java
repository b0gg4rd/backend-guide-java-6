package net.coatli.guide.javabackend.events;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class UpdatedEvent {

  protected final boolean domainUpdated;

  public UpdatedEvent(final boolean domainUpdated) {
    this.domainUpdated = domainUpdated;
  }

  public boolean isDomainUpdated() {
    return domainUpdated;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.JSON_STYLE).append("domainUpdated", domainUpdated).toString();
  }

  @Override
  public boolean equals(final Object other) {
    if (!(other instanceof UpdatedEvent)) {
      return false;
    }
    final UpdatedEvent castOther = (UpdatedEvent) other;
    return new EqualsBuilder().append(domainUpdated, castOther.domainUpdated).isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder().append(domainUpdated).toHashCode();
  }

}
