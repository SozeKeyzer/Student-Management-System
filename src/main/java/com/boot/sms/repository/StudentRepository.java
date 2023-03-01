package com.boot.sms.repository;

import com.boot.sms.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;

//we don't have to add @Repository annotation here because the default implementation class of
//JpaRepository i.e. SimpleJpaRepository is already annotated with @Repository
//similarly we don't have to add @Transactional as SimpleJpaRepository class and its method are already annotated

public interface StudentRepository extends JpaRepository<Student,Long> {
}
