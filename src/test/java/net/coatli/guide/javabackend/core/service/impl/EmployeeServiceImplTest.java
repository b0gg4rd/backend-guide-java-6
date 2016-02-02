package net.coatli.guide.javabackend.core.service.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import net.coatli.guide.javabackend.core.domain.Employee;
import net.coatli.guide.javabackend.events.employee.CreateEmployeeEvent;
import net.coatli.guide.javabackend.events.employee.EmployeeCreatedEvent;
import net.coatli.guide.javabackend.persistence.EmployeePersistenceService;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplTest {

  private static final int FAILURE = 0;

  private static final int SUCCESS = 1;

  @InjectMocks
  private EmployeeServiceImpl service;

  @Mock
  private EmployeePersistenceService employeePersistenceService;

  @Test
  public void thatCreateEmployeeWithNullParamsReturnNotNull() {
    // given
    final CreateEmployeeEvent createEmployeeEvent = null;

    // when
    final EmployeeCreatedEvent employeeCreatedEvent = service.createEmployee(createEmployeeEvent);

    //then
    assertNotNull(employeeCreatedEvent);
  }

  @Test
  public void thatCreateEmployeeWithEmptyParamsReturnNotNull() {
    // given
    final CreateEmployeeEvent createEmployeeEvent = new CreateEmployeeEvent();

    // when
    final EmployeeCreatedEvent employeeCreatedEvent = service.createEmployee(createEmployeeEvent);

    //then
    assertNotNull(employeeCreatedEvent);
  }

  @Test
  public void thatCreateEmployeeWithInvalidParamsWorks() {
    // given
    final CreateEmployeeEvent createEmployeeEvent = new CreateEmployeeEvent();
    createEmployeeEvent.setEmployee(standardEmployee());

    when(employeePersistenceService.createEmployee(createEmployeeEvent)).thenReturn(FAILURE);

    // when
    final EmployeeCreatedEvent employeeCreatedEvent = service.createEmployee(createEmployeeEvent);

    //then
    assertTrue(employeeCreatedEvent.getNewKey() == null);
  }

  @Test
  public void thatCreateEmployeeWithValidParamsWorks() {
    // given
    final CreateEmployeeEvent createEmployeeEvent = new CreateEmployeeEvent();
    createEmployeeEvent.setEmployee(standardEmployee());

    when(employeePersistenceService.createEmployee(createEmployeeEvent)).thenReturn(SUCCESS);

    // when
    final EmployeeCreatedEvent employeeCreatedEvent = service.createEmployee(createEmployeeEvent);

    //then
    assertNotNull(employeeCreatedEvent);
  }

  private Employee standardEmployee() {
    final Employee standardEmployee = new Employee();

    standardEmployee.setFirstName("Juan");
    standardEmployee.setPaternalSurname("Rulfo");

    return standardEmployee;
  }

}
