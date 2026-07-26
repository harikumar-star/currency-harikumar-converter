package com.expenseTracker.repository;

import com.expenseTracker.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface ExpenseTrackerRepo extends JpaRepository<Transaction, Long> {

    //@Query(value = "SELECT * FROM `transaction` WHERE client_id = :clientId",
//       nativeQuery = true)
    @Query("SELECT e FROM Transaction e WHERE e.clientId = :clientId")
    List<Transaction> findByClientId(@Param("clientId") double clientId);
    //@Query("SELECT SUM(e.amount) FROM Expense e WHERE e.clientId = :clientId")
    //Double getTotalAmountByClientId(@Param("clientId") int clientId);

}
