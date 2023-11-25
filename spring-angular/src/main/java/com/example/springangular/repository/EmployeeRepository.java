package com.example.springangular.repository;

import com.example.springangular.Model.Departement;
import com.example.springangular.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
/*    //@Query(value="SELECT * FROM employees  WHERE id_departement= ?1",nativeQuery = true)
    @Query(value="SELECT e FROM employees e JOIN e.Departement WHERE id_departement= ?1",nativeQuery = true)
  List <Employee> getDepartementbyEmployee (Long id_departement);
*/
    @Query (value="SELECT * FROM Employees  WHERE last_name= ?1",nativeQuery = true)
    List<Employee> getEmployeesbyLastname(String lastname);

    @Query(value = "SELECT * FROM employees e, Departement d WHERE e.id_departements=d.id_departement and e.id_departements = ?1", nativeQuery = true)
         List<Employee> Employeewithdepartementid(Long id);

}
