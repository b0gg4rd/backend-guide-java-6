package net.coatli.guide.javabackend.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.coatli.guide.javabackend.core.domain.Employee;
import net.coatli.guide.javabackend.core.service.EmployeeService;
import net.coatli.guide.javabackend.events.employee.CreateEmployeeEvent;
import net.coatli.guide.javabackend.events.employee.DeleteEmployeeEvent;
import net.coatli.guide.javabackend.events.employee.EmployeeCreatedEvent;
import net.coatli.guide.javabackend.events.employee.EmployeeDeletedEvent;
import net.coatli.guide.javabackend.events.employee.EmployeeUpdatedEvent;
import net.coatli.guide.javabackend.events.employee.RequestAllEmployeesEvent;
import net.coatli.guide.javabackend.events.employee.RequestEmployeeEvent;
import net.coatli.guide.javabackend.events.employee.ResponseAllEmployeesEvent;
import net.coatli.guide.javabackend.events.employee.ResponseEmployeeEvent;
import net.coatli.guide.javabackend.events.employee.UpdateEmployeeEvent;
import net.coatli.guide.javabackend.persistence.EmployeePersistenceService;

/**
 * Implementation of {@link EmployeeService}.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

  private static final int ZERO_ROWS_AFFECTED = 0;

  @Autowired
  private EmployeePersistenceService employeePersistenceService;

  @Override
  public EmployeeCreatedEvent createEmployee(final CreateEmployeeEvent createEmployeeEvent) {

    return ZERO_ROWS_AFFECTED == employeePersistenceService.createEmployee(createEmployeeEvent) ?
            new EmployeeCreatedEvent(false) :
            new EmployeeCreatedEvent(true, createEmployeeEvent.getEmployee().getKey());

  }

  @Override
  public ResponseEmployeeEvent requestEmployee(final RequestEmployeeEvent requestEmployeeEvent) {

    final Employee employee = employeePersistenceService.requestEmployee(requestEmployeeEvent);

    return null == employee ?
             new ResponseEmployeeEvent(false) :
             new ResponseEmployeeEvent(true, employee);
  }

  @Override
  public EmployeeUpdatedEvent updateEmployee(final UpdateEmployeeEvent updateEmployeeEvent) {

    return ZERO_ROWS_AFFECTED == employeePersistenceService.updateEmployee(updateEmployeeEvent) ?
            new EmployeeUpdatedEvent(false) :
            new EmployeeUpdatedEvent(true);
  }

  @Override
  public EmployeeDeletedEvent deleteEmployee(final DeleteEmployeeEvent deleteEmployeeEvent) {

    return ZERO_ROWS_AFFECTED == employeePersistenceService.deleteEmployee(deleteEmployeeEvent) ?
            new EmployeeDeletedEvent(false) :
            new EmployeeDeletedEvent(true);
  }

  @Override
  public ResponseAllEmployeesEvent requestAllEmployees(final RequestAllEmployeesEvent requestAllInvoicesEvent) {

    final List<Employee> allEmployees = employeePersistenceService.requestAllEmployees(requestAllInvoicesEvent);

    return new ResponseAllEmployeesEvent(allEmployees.isEmpty(), allEmployees);
  }

}
