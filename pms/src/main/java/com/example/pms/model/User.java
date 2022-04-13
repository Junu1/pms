package com.example.pms.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name", length = 50, nullable = false)
    private String name;
    @Column(name = "password", length = 10, nullable = false)
    private String password;

    @OneToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;

    public User(Integer id) {
        this.id = id;
    }

}
