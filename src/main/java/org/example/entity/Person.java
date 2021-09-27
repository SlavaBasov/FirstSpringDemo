package org.example.entity;

import org.graalvm.compiler.phases.common.inlining.info.elem.InlineableGraph;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer age;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<Job> jobs;

    public Person() {
    }

    public Person(String name, Integer age, List<Job> jobs) {
        this.name = name;
        this.age = age;
        this.jobs = jobs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", jobs=" + jobs +
                '}';
    }
}
