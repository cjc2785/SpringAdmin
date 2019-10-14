package com.ss.lms.dao;

import com.ss.lms.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Integer> {
    Publisher getByPublisherId(Integer publisherId);
}
