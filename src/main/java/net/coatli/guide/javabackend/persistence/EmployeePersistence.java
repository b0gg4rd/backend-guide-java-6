package net.coatli.guide.javabackend.persistence;

import java.util.List;

import net.coatli.guide.javabackend.core.domain.Employee;
import net.coatli.guide.javabackend.events.employee.CreateEmployeeEvent;
import net.coatli.guide.javabackend.events.employee.DeleteEmployeeEvent;
import net.coatli.guide.javabackend.events.employee.RequestAllEmployeesEvent;
import net.coatli.guide.javabackend.events.employee.RequestEmployeeEvent;
import net.coatli.guide.javabackend.events.employee.UpdateEmployeeEvent;
import net.coatli.guide.javabackend.stereotype.Mapper;

/**
 * Persistence for the element of the domain {@link Employee}.
 */
@Mapper
public interface EmployeePersistence {

  public int createEmployee(CreateEmployeeEvent createEmployeeEvent);

  public Employee requestEmployee(RequestEmployeeEvent requestEmployeeEvent);

  public int updateEmployee(UpdateEmployeeEvent updateEmployeeEvent);

  public int deleteEmployee(DeleteEmployeeEvent deleteEmployeeEvent);

  public List<Employee> requestAllEmployees(RequestAllEmployeesEvent requestAllInvoicesEvent);
}
