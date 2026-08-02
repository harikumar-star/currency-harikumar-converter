package com.student.repo;

import com.student.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepo  extends JpaRepository<Faculty,Long> {
}
