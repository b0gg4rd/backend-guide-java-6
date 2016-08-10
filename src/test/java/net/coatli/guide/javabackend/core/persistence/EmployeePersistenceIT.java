package net.coatli.guide.javabackend.core.persistence;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import net.coatli.guide.javabackend.core.domain.Employee;
import net.coatli.guide.javabackend.core.persistence.EmployeePersistence;
import net.coatli.guide.javabackend.events.employee.CreateEmployeeEvent;
import net.coatli.guide.javabackend.events.employee.RequestAllEmployeesEvent;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/META-INF/spring/test-core-context.xml")
@TransactionConfiguration(defaultRollback = true)
public class EmployeePersistenceIT {

  private static final Logger LOGGER = LoggerFactory.getLogger(EmployeePersistenceIT.class);

  private static final int SUCCESS = 1;

  @Autowired
  private EmployeePersistence service;

  @Test
  public void thatCreateEmployeeWithEmptyParamsFails() {
    // given
    final CreateEmployeeEvent createEmployeeEvent = new CreateEmployeeEvent();

    try {
      // when
      service.createEmployee(createEmployeeEvent);

    } catch (final Exception exc) {
      // then
      assertTrue(exc instanceof DataIntegrityViolationException);
    }
  }

  @Test
  public void thatCreateEmployeeWithValidParamsReturnSuccess() {
    // given
    final CreateEmployeeEvent createEmployeeEvent = new CreateEmployeeEvent();
    createEmployeeEvent.setEmployee(standardEmployee());

    // when
    final int result = service.createEmployee(createEmployeeEvent);

    // then
    assertTrue(SUCCESS == result);
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

  @Test
  public void thatRequestAllEmployeesWithEmptyParamsReturnNotNull() {
    // given
    final RequestAllEmployeesEvent requestAllEmployeesEvent = new RequestAllEmployeesEvent();

    // when
    final List<Employee> allEmployees = service.requestAllEmployees(requestAllEmployeesEvent);

    // then
    assertNotNull(allEmployees);
  }

  private Employee standardEmployee() {
    final Employee standardEmployee = new Employee();

    standardEmployee.setName("Juan Rulfo");
    standardEmployee.setBirthday(Calendar.getInstance().getTime());

    if (LOGGER.isDebugEnabled()) {
      LOGGER.debug("standardEmployee: {}", standardEmployee);
    }

    return standardEmployee;
  }

}
