package com.student.repo;

import com.student.model.Attendance;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AttendanceRepo extends JpaRepository<Attendance, Long> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Attendance u SET u.status = :status, u.facultyRefNumber = :facultyRef " +
            "WHERE u.id IN :ids")
    int updateStatusForIds(@Param("status") String status,
                           @Param("facultyRef") Long facultyRefNumber,
                           @Param("ids") List<Long> ids);



}
