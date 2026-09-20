package com.crud.JsonExample;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonWriterExample {


    public static void main(String[] args) {

        Address address = new Address("123 Main Street", "New York", "NY", "10001");

        List<Integer> list = List.of(1,2,3,4);

        // 2. Create and populate Employee object
        Employee employee = new Employee(101, "John Doe", "Engineering", address,list);

        // 3. Initialize Jackson ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        // Enable pretty printing for formatted JSON output
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            // 4. Define output file path
            File outputFile = new File("employee.json");

            // 5. Convert object to JSON and save to local file
            mapper.writeValue(outputFile, employee);

            System.out.println("JSON successfully created and saved to: " + outputFile.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
