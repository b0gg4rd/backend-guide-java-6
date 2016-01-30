package net.coatli.guide.javabackend.events.employee;

import java.util.Date;

public class RequestAllEmployeesEvent {

  private String name;
  private Date birthday;

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(final Date birthday) {
    this.birthday = birthday;
  }

}
