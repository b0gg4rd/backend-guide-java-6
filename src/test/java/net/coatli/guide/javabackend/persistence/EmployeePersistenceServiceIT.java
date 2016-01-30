package net.coatli.guide.javabackend.persistence;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import net.coatli.guide.javabackend.core.domain.Employee;
import net.coatli.guide.javabackend.events.employee.RequestAllEmployeesEvent;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/META-INF/spring/test-context.xml")
@TransactionConfiguration(defaultRollback = true)
public class EmployeePersistenceServiceIT {

  @Autowired
  private EmployeePersistenceService service;

  @Test
  public void thatRequestAllEmployeesWithNullParamsReturnNotNull() {
    // given
    final RequestAllEmployeesEvent requestAllEmployeesEvent = null;

    // when
    final List<Employee> allEmployees = service.requestAllEmployees(requestAllEmployeesEvent);

    // then
    assertNotNull(allEmployees);
  }

}
