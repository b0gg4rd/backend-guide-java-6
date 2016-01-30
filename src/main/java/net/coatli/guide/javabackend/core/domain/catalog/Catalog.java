package net.coatli.guide.javabackend.core.domain.catalog;

public class Catalog {

  private final Integer key;
  private final String cve;
  private final String desc;

  public Catalog(final Integer key, final String cve, final String desc) {
    this.key = key;
    this.cve = cve;
    this.desc = desc;
  }

  public Integer getKey() {
    return key;
  }

  public String getCve() {
    return cve;
  }

  public String getDesc() {
    return desc;
  }

}
