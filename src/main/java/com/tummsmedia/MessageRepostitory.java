package com.tummsmedia;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by john.tumminelli on 10/23/16.
 */
public interface MessageRepostitory extends CrudRepository<Message, Integer> {

}
