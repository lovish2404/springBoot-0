package com.example.tempor.dao;

import com.example.tempor.entity.Publisher;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

@Component
public interface PublisherRepo extends CrudRepository <Publisher,Integer>{

}
