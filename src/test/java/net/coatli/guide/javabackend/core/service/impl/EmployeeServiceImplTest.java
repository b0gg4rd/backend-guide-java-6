package net.coatli.guide.javabackend.core.service.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import net.coatli.guide.javabackend.core.domain.Employee;
import net.coatli.guide.javabackend.core.persistence.EmployeePersistence;
import net.coatli.guide.javabackend.events.employee.CreateEmployeeEvent;
import net.coatli.guide.javabackend.events.employee.EmployeeCreatedEvent;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplTest {

  private static final int FAILURE = 0;

  private static final int SUCCESS = 1;

  @InjectMocks
  private EmployeeServiceImpl service;

  @Mock
  private EmployeePersistence employeePersistenceService;

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
  public void thatCreateEmployeeWithInvalidParamsReturnFalse() {
    // given
    final CreateEmployeeEvent createEmployeeEvent = new CreateEmployeeEvent();
    createEmployeeEvent.setEmployee(new Employee());

    when(employeePersistenceService.createEmployee(
        any(CreateEmployeeEvent.class)))
      .thenReturn(FAILURE);

    // when
    final EmployeeCreatedEvent employeeCreatedEvent = service.createEmployee(createEmployeeEvent);

    //then
    assertFalse(employeeCreatedEvent.isDomainCreated());
  }

  @Test
  public void thatCreateEmployeeWithValidParamsReturnTrue() {
    // given
    final CreateEmployeeEvent createEmployeeEvent = new CreateEmployeeEvent();
    createEmployeeEvent.setEmployee(new Employee());

    when(employeePersistenceService.createEmployee(
        any(CreateEmployeeEvent.class)))
      .thenReturn(SUCCESS);

    // when
    final EmployeeCreatedEvent employeeCreatedEvent = service.createEmployee(createEmployeeEvent);

    //then
    assertTrue(employeeCreatedEvent.isDomainCreated());
  }

  @Test
  public void thatCreateEmployeeWithValidParamsReturnValidKey() {
    // given
    final CreateEmployeeEvent createEmployeeEvent = new CreateEmployeeEvent();
    createEmployeeEvent.setEmployee(new Employee());

    when(employeePersistenceService.createEmployee(
        any(CreateEmployeeEvent.class)))
      .thenReturn(SUCCESS);

    // when
    final EmployeeCreatedEvent employeeCreatedEvent = service.createEmployee(createEmployeeEvent);

    //then
    assertTrue(createEmployeeEvent.getEmployee().getKey() == employeeCreatedEvent.getNewKey());
  }

}
