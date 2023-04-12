package com.dataVisualizationbackend.config;

import com.dataVisualizationbackend.model.DataDetails;
import org.springframework.batch.item.ItemProcessor;

public class DataItemProcessor implements ItemProcessor<DataDetails,DataDetails> {
    @Override
    public DataDetails process(DataDetails dataDetails) throws Exception {
        return dataDetails;
    }
}
