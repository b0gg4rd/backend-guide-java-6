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
@Path("/employee")
public interface EmployeeRest {

  @POST
  @Path("/create")
  public EmployeeCreatedEvent createEmployee(CreateEmployeeEvent createEmployeeEvent);

  @POST
  @Path("/request")
  public ResponseEmployeeEvent requestEmployee(RequestEmployeeEvent requestEmployeeEvent);

  @POST
  @Path("/update")
  public EmployeeUpdatedEvent updateEmployee(UpdateEmployeeEvent updateEmployeeEvent);

  @POST
  @Path("/delete")
  public EmployeeDeletedEvent deleteEmployee(DeleteEmployeeEvent deleteEmployeeEvent);

  @POST
  @Path("/requestall")
  public ResponseAllEmployeesEvent requestAllEmployees(RequestAllEmployeesEvent requestAllEmployeesEvent);

}
