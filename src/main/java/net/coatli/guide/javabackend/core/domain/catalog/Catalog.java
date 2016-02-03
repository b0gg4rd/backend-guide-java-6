package net.coatli.guide.javabackend.core.domain.catalog;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Catalog {

  private final Integer key;
  private final String shortCode;
  private final String longCode;

  public Catalog(final Integer key, final String cve, final String desc) {
    this.key = key;
    this.shortCode = cve;
    this.longCode = desc;
  }

  public Integer getKey() {
    return key;
  }

  public String getCve() {
    return shortCode;
  }

  public String getDesc() {
    return longCode;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.JSON_STYLE).appendSuper(super.toString()).append("key", key).append("shortCode", shortCode).append("longCode", longCode).toString();
  }

  @Override
  public boolean equals(final Object other) {
    if (!(other instanceof Catalog)) {
      return false;
    }
    final Catalog castOther = (Catalog) other;
    return new EqualsBuilder().append(key, castOther.key).append(shortCode, castOther.shortCode).append(longCode, castOther.longCode).isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder().append(key).append(shortCode).append(longCode).toHashCode();
  }

}
