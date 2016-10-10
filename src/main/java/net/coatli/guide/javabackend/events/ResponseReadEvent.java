package net.coatli.guide.javabackend.events;

public class ResponseReadEvent {

  protected boolean domainFound;

  public ResponseReadEvent() {
  }

  public boolean isDomainFound() {
    return domainFound;
  }

  @SuppressWarnings("unchecked")
  public <T extends ResponseReadEvent> T setDomainFound(final boolean domainFound) {
    this.domainFound = domainFound;

    return (T )this;
  }

}
