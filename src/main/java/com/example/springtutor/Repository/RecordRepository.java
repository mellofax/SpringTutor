package com.example.springtutor.Repository;

import com.example.springtutor.Entity.Record;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends CrudRepository<Record, Long>{}
