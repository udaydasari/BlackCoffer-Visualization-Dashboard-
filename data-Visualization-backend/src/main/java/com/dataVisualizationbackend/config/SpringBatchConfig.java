package com.dataVisualizationbackend.config;

import com.dataVisualizationbackend.model.DataDetails;
import com.dataVisualizationbackend.repository.DetailsRepository;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
@EnableBatchProcessing
@AllArgsConstructor
public class SpringBatchConfig {

    private JobBuilderFactory jobBuilderFactory;
    private StepBuilderFactory stepBuilderFactory;
    private DetailsRepository detailsRepository;
    @Bean
    public FlatFileItemReader<DataDetails> reader(){
        FlatFileItemReader<DataDetails> flatFileItemReader=
                new FlatFileItemReader<DataDetails>();
        flatFileItemReader.setResource(new FileSystemResource("src/main/resources/Data.csv"));
        flatFileItemReader.setName("csvReader");
        flatFileItemReader.setLinesToSkip(1);
        flatFileItemReader.setLineMapper(lineMapper());

        return flatFileItemReader;

    }
   /*private LineMapper<DataDetails> lineMapper(){
        DefaultLineMapper<DataDetails> lineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer
                =new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames("Id","end_year","cityLongitude","cityLatitude","intensity","sector","topic","insight",
                "swot","url","region","start_year","impact","added","published",
                "city","country","relevance","pestle","source","title","likelihood");

        BeanWrapperFieldSetMapper<DataDetails> fieldSetMapper =new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(DataDetails.class);

        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);

        return lineMapper;

    }*/

   private LineMapper<DataDetails> lineMapper() {
       DefaultLineMapper<DataDetails> lineMapper = new DefaultLineMapper<>();
       DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
       lineTokenizer.setDelimiter(",");
       lineTokenizer.setStrict(false);
       lineTokenizer.setNames("Id","end_year","cityLongitude","cityLatitude","intensity","sector","topic","insight",
               "swot","url","region","start_year","impact","added","published",
               "city","country","relevance","pestle","source","title","likelihood");
       lineMapper.setLineTokenizer(lineTokenizer);
       lineMapper.setFieldSetMapper(new CustomFieldSetMapper());
       return lineMapper;
   }

    @Bean
    public DataItemProcessor dataItemProcessor(){
        return new DataItemProcessor();
    }
    @Bean
    public RepositoryItemWriter<DataDetails> writer(){
        RepositoryItemWriter<DataDetails> writer = new RepositoryItemWriter<>();
        writer.setRepository(detailsRepository);
        writer.setMethodName("save");
        return writer;
    }
    @Bean
    public Step step1(){
        return stepBuilderFactory.get("csv-step")
                .<DataDetails,DataDetails>chunk(10)
                .reader(reader())
                .processor(dataItemProcessor())
                .writer(writer())
                .build();
    }
    @Bean
    public Job runJob(){
        return jobBuilderFactory.get("importDataDetails")
                .flow(step1())
                .end()
                .build();

    }
}
