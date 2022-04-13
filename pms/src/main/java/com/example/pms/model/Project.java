package com.example.pms.model;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name", length = 50, nullable = false)
    private String name;
    @Column(columnDefinition = "TEXT", name = "description")
    private String description;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "added_date", nullable = false)
    private Date addedDate;

    @OneToMany(mappedBy = "project")
    @Fetch(FetchMode.SUBSELECT)
    private List<Task> tasks;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Project(Integer id) {
        this.id = id;

    }
}
