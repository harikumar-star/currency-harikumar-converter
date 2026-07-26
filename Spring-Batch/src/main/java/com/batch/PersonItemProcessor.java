package com.batch;

import org.springframework.batch.infrastructure.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class PersonItemProcessor implements ItemProcessor<Person, Person> {
    @Override
    public Person process(Person person) {
        person.setName(person.getName().toUpperCase());
        person.setAge(person.getAge() + 5);
        return person;
    }
}