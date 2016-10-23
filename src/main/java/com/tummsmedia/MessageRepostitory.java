package com.tummsmedia;

import org.springframework.data.repository.CrudRepository;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by john.tumminelli on 10/23/16.
 */
public interface MessageRepostitory extends CrudRepository<Message, Integer> {
    Message findById(int id);
}
