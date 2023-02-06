package com.example.demo.models;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.util.stream.Stream;

public class ProductIDGenerator implements IdentifierGenerator {
    private String prefix = "P";

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object obj) throws HibernateException {
        String query = "SELECT productID FROM Product";
        Stream<String> count = session.createQuery(query, String.class).stream();

        Long max = count.map(o -> o.replace(prefix, "")).mapToLong(Long::parseLong).max().orElse(0L);
        return prefix + (String.format("%03d", max + 1));
    }
}
