package com.ramjava.spring.batch.config;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.ramjava.spring.batch.entity.Customer;
import com.ramjava.spring.batch.repository.CustomerRepo;

import lombok.AllArgsConstructor;

@Configuration	
@EnableBatchProcessing
@AllArgsConstructor // Alternative for adding @Autowired for 3 fields
public class SpringBatchConfig {

	private JobBuilderFactory jbf;
	private StepBuilderFactory sbf;
	private CustomerRepo cusRepo;
	
	public FlatFileItemReader<Customer> reader() {
		FlatFileItemReader<Customer> itemReader = new FlatFileItemReader<>();
		itemReader.setResource(new FileSystemResource("src/main/resources/customers.csv"));
		itemReader.setName("cvReader");	
		itemReader.setLinesToSkip(1);	
		itemReader.setLineMapper(lineMapper());
		return itemReader;
	}
	
	private LineMapper<Customer> lineMapper() {
		DefaultLineMapper<Customer> lineMapper = new DefaultLineMapper();
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(",");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames("id", "firstName", "lastName", "email", "gender", "contactNo", "country", "dob");
		
		BeanWrapperFieldSetMapper<Customer> fieldSetWrapper = new BeanWrapperFieldSetMapper<>();
		fieldSetWrapper.setTargetType(Customer.class);
		
		lineMapper.setLineTokenizer(lineTokenizer);
		lineMapper.setFieldSetMapper(fieldSetWrapper);
		return lineMapper;		
		
	}
	
	@Bean
	public CustomerProcessor processor() {
		return new CustomerProcessor();
	}
}
