package net.coatli.guide.javabackend.persistence;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import net.coatli.guide.javabackend.core.domain.Employee;
import net.coatli.guide.javabackend.events.employee.CreateEmployeeEvent;
import net.coatli.guide.javabackend.events.employee.RequestAllEmployeesEvent;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/META-INF/spring/test-context.xml")
@TransactionConfiguration(defaultRollback = true)
public class EmployeePersistenceServiceIT {

  private static final int FAILURE = 0;

  @Autowired
  private EmployeePersistenceService service;

  public void thatCreateEmployeeWithNullParamsFail() {
    // given
    final CreateEmployeeEvent createEmployeeEvent = null;

    // when
    final int result = service.createEmployee(createEmployeeEvent);

    // then
    assertTrue(FAILURE == result);
  }

  public void thatCreateEmployeeWithInvalidParamsFail() {
    // given
    final CreateEmployeeEvent createEmployeeEvent = new CreateEmployeeEvent();
    createEmployeeEvent.setEmployee(standardEmployee());

    // when
    final int result = service.createEmployee(createEmployeeEvent);

    // then
    assertTrue(FAILURE == result);
  }

  @Test
  public void thatRequestAllEmployeesWithNullParamsReturnNotNull() {
    // given
    final RequestAllEmployeesEvent requestAllEmployeesEvent = null;

    // when
    final List<Employee> allEmployees = service.requestAllEmployees(requestAllEmployeesEvent);

    // then
    assertNotNull(allEmployees);
  }

  private Employee standardEmployee() {
    final Employee standardEmployee = new Employee();

    standardEmployee.setFirstName("Juan");
    standardEmployee.setPaternalSurname("Rulfo");

    return standardEmployee;
  }
}
