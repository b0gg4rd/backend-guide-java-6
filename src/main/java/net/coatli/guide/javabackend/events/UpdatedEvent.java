package net.coatli.guide.javabackend.events;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class UpdatedEvent {

  protected boolean domainUpdated;

  public UpdatedEvent() {
  }

  public UpdatedEvent(final boolean domainUpdated) {
    this.domainUpdated = domainUpdated;
  }

  public boolean isDomainUpdated() {
    return domainUpdated;
  }

  public void setDomainUpdated(final boolean domainUpdated) {
    this.domainUpdated = domainUpdated;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.JSON_STYLE).appendSuper(super.toString()).append("domainUpdated", domainUpdated).toString();
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
