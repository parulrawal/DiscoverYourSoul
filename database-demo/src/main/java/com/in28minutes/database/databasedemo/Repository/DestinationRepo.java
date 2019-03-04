package com.in28minutes.database.databasedemo.Repository;

import com.in28minutes.database.databasedemo.Model.Destination;
import com.in28minutes.database.databasedemo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DestinationRepo extends JpaRepository<Destination,Long>{
@Query("select d from Destination d where d.id=?1")
Destination findById(Long id);

}

