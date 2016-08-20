package net.coatli.guide.javabackend.rest;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import net.coatli.guide.javabackend.core.domain.Employee;
import net.coatli.guide.javabackend.events.employee.CreateEmployeeEvent;
import net.coatli.guide.javabackend.events.employee.EmployeeCreatedEvent;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/META-INF/spring/test-back-context.xml")
public class EmployeeRestIT {

  @Value("${employee.create.url}")
  private String employeeCreateUrl;

  @Test
  public void thatCreateEmployeeReturnNotNullWorks() {
    // given
    final CreateEmployeeEvent createEmployeeEvent = new CreateEmployeeEvent();
    createEmployeeEvent.setEmployee(new Employee());

    // when
    final EmployeeCreatedEvent employeeCreatedEvent = new RestTemplate().postForObject(
        employeeCreateUrl, createEmployeeEvent, EmployeeCreatedEvent.class);

    // then
    assertNotNull(employeeCreatedEvent);
  }

}
