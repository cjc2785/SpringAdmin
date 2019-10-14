package com.ss.lms.service;

import com.ss.lms.dao.PublisherRepository;
import com.ss.lms.model.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    public Publisher save(Publisher publisher)
    {
        return publisherRepository.save(publisher);
    }
    public Publisher findById( Integer publisherId)
    {
        return publisherRepository.getByPublisherId(publisherId);
    }
    public Iterable<Publisher> findAll()
    {
        return publisherRepository.findAll();
    }
    public void delete(Integer publisherId)
    {
        Publisher publisher = findById(publisherId);
        publisherRepository.delete(publisher);
    }
}
