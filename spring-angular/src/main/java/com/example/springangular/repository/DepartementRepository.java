package com.example.springangular.repository;

import com.example.springangular.Model.Departement;
import com.example.springangular.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartementRepository extends JpaRepository<Departement,Long> {

    @Query(value="SELECT * FROM Departement  WHERE  id_departement= ?1",nativeQuery = true)
    Departement getEmployeesbydepartement(Long id_departement);
}
