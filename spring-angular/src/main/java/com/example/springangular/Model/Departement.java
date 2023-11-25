package com.example.springangular.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Departement")
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_departement;
    @Column(name = "nom_departement")
    private String nomdepartement;
    @JsonManagedReference
    @OneToMany(mappedBy = "departement", fetch = FetchType.EAGER)
    private List<Employee> employeeList;

}
