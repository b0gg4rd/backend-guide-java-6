package net.coatli.guide.javabackend.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface EmployeeRest {

  public static final String CREATE_EMPLOYEE = "/employee/create";

  public static final String REQUEST_EMPLOYEE = "/employee/request";

  public static final String UPDATE_EMPLOYEE = "/employee/update";

  public static final String DELETE_EMPLOYEE = "/employee/delete";

  public static final String REQUEST_ALL_EMPLOYEES = "/employee/requestall";

  @POST
  @Path(CREATE_EMPLOYEE)
  public EmployeeCreatedEvent createEmployee(CreateEmployeeEvent createEmployeeEvent);

  @POST
  @Path(REQUEST_EMPLOYEE)
  public ResponseEmployeeEvent requestEmployee(RequestEmployeeEvent requestEmployeeEvent);

  @POST
  @Path(UPDATE_EMPLOYEE)
  public EmployeeUpdatedEvent updateEmployee(UpdateEmployeeEvent updateEmployeeEvent);

  @POST
  @Path(DELETE_EMPLOYEE)
  public EmployeeDeletedEvent deleteEmployee(DeleteEmployeeEvent deleteEmployeeEvent);

  @POST
  @Path(REQUEST_ALL_EMPLOYEES)
  public ResponseAllEmployeesEvent requestAllEmployees(RequestAllEmployeesEvent requestAllEmployeesEvent);
}
