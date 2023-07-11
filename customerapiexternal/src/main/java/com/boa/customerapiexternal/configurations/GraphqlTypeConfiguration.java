package com.boa.customerapiexternal.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import graphql.scalars.ExtendedScalars;
import graphql.schema.GraphQLScalarType;

@Configuration
public class GraphqlTypeConfiguration {



    @Bean
    public GraphQLScalarType dateType(){
        return ExtendedScalars.Date;
    }
    @Bean
    public GraphQLScalarType jsonType(){
        return ExtendedScalars.Json;
    }

}
