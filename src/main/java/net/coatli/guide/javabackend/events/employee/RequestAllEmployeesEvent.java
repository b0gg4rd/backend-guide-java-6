package net.coatli.guide.javabackend.events.employee;

import java.util.Date;

public class RequestAllEmployeesEvent {

  private String firstName;
  private Date birthday;

  public String getName() {
    return firstName;
  }

  public void setName(final String name) {
    this.firstName = name;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(final Date birthday) {
    this.birthday = birthday;
  }

}
