package net.coatli.guide.javabackend.core.service.impl;

import java.util.Collections;
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
import net.coatli.guide.javabackend.persistence.EmployeePersistence;

/**
 * Implementation of {@link EmployeeService}.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

  private static final int SUCCESS = 1;

  @Autowired
  private EmployeePersistence employeePersistenceService;

  @Override
  public EmployeeCreatedEvent createEmployee(final CreateEmployeeEvent createEmployeeEvent) {

    if (createEmployeeEvent == null || createEmployeeEvent.getEmployee() == null) {
      return new EmployeeCreatedEvent(false);
    }

    return SUCCESS == employeePersistenceService.createEmployee(createEmployeeEvent) ?
        new EmployeeCreatedEvent(true, createEmployeeEvent.getEmployee().getKey()) :
        new EmployeeCreatedEvent(false);

  }

  @Override
  public ResponseEmployeeEvent requestEmployee(final RequestEmployeeEvent requestEmployeeEvent) {

    final Employee employee = employeePersistenceService.requestEmployee(requestEmployeeEvent);

    return new ResponseEmployeeEvent(null == employee, employee);
  }

  @Override
  public EmployeeUpdatedEvent updateEmployee(final UpdateEmployeeEvent updateEmployeeEvent) {

    return new EmployeeUpdatedEvent(SUCCESS == employeePersistenceService.updateEmployee(updateEmployeeEvent));
  }

  @Override
  public EmployeeDeletedEvent deleteEmployee(final DeleteEmployeeEvent deleteEmployeeEvent) {

    return new EmployeeDeletedEvent(SUCCESS == employeePersistenceService.deleteEmployee(deleteEmployeeEvent));
  }

  @Override
  public ResponseAllEmployeesEvent requestAllEmployees(final RequestAllEmployeesEvent requestAllInvoicesEvent) {

    final List<Employee> allEmployees = employeePersistenceService.requestAllEmployees(requestAllInvoicesEvent);

    return allEmployees.isEmpty() ?
        new ResponseAllEmployeesEvent(false, Collections.emptyList()) :
        new ResponseAllEmployeesEvent(true, allEmployees);
  }

}
