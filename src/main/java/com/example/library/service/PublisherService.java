package com.example.library.service;

import com.example.library.entity.Publisher;
import com.example.library.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {
    @Autowired
    PublisherRepository publisherRepository;
    public List<Publisher> findAllPublishers(){
        return publisherRepository.findAll();
    }

    public Publisher findPublisherById(Long Id){
        Publisher publisher;
        publisher=publisherRepository.findById(Id).orElseThrow(RuntimeException::new);
        return  publisher;
    }

    public  void createPublisher(Publisher publisher)
    {
        publisherRepository.save(publisher);
    }

    public void updatePublisher(Publisher publisher)
    {
        publisherRepository.save(publisher);
    }
    public void deletePublisher(Long Id)
    {
        publisherRepository.deleteById(Id);

    }
    
}
