package net.coatli.guide.javabackend.events;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class DeletedEvent {

  protected boolean domainDeleted;

  public DeletedEvent() {
  }

  public DeletedEvent(final boolean domainDeleted) {
    this.domainDeleted = domainDeleted;
  }

  public boolean isDomainDeleted() {
    return domainDeleted;
  }

  public void setDomainDeleted(final boolean domainDeleted) {
    this.domainDeleted = domainDeleted;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.JSON_STYLE).appendSuper(super.toString()).append("domainDeleted", domainDeleted).toString();
  }

  @Override
  public boolean equals(final Object other) {
    if (!(other instanceof DeletedEvent)) {
      return false;
    }
    final DeletedEvent castOther = (DeletedEvent) other;
    return new EqualsBuilder().append(domainDeleted, castOther.domainDeleted).isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder().append(domainDeleted).toHashCode();
  }


}
