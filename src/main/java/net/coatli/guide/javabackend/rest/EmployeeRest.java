package net.coatli.guide.javabackend.rest;

import net.coatli.guide.javabackend.core.domain.Employee;
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

/**
 * REST for the element of the domain {@link Employee}.
 */
public interface EmployeeRest {

  public EmployeeCreatedEvent createEmployee(CreateEmployeeEvent createEmployeeEvent);

  public ResponseEmployeeEvent requestEmployee(RequestEmployeeEvent requestEmployeeEvent);

  public EmployeeUpdatedEvent updateEmployee(UpdateEmployeeEvent updateEmployeeEvent);

  public EmployeeDeletedEvent deleteEmployee(DeleteEmployeeEvent deleteEmployeeEvent);

  public ResponseAllEmployeesEvent requestAllEmployees(RequestAllEmployeesEvent requestAllEmployeesEvent);
}
