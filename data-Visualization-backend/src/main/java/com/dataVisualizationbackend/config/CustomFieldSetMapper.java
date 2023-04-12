package com.dataVisualizationbackend.config;

import com.dataVisualizationbackend.model.DataDetails;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.util.StringUtils;

import java.net.BindException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CustomFieldSetMapper implements FieldSetMapper<DataDetails> {

    @Override
    public DataDetails mapFieldSet(FieldSet fieldSet) {
        DataDetails dataDetails = new DataDetails();

        // set id
        dataDetails.setId(fieldSet.readLong("Id"));

        // set end_year
        String endYearString = fieldSet.readString("end_year");
        if (!StringUtils.isEmpty(endYearString)) {
            dataDetails.setEnd_year(Long.parseLong(endYearString));
        }

        // set cityLongitude
        String cityLongitudeString = fieldSet.readString("cityLongitude");
        if (!StringUtils.isEmpty(cityLongitudeString)) {
            dataDetails.setCityLongitude(Double.parseDouble(cityLongitudeString));
        }
        else dataDetails.setCityLongitude(0.0);

        // set cityLatitude
        String cityLatitudeString = fieldSet.readString("cityLatitude");
        if (!StringUtils.isEmpty(cityLatitudeString)) {
            dataDetails.setCityLatitude(Double.parseDouble(cityLatitudeString));
        }
        else dataDetails.setCityLatitude(0.0);

        // set intensity
        dataDetails.setIntensity(fieldSet.readInt("intensity"));

        // set sector
        dataDetails.setSector(fieldSet.readString("sector"));

        // set topic
        dataDetails.setTopic(fieldSet.readString("topic"));

        // set insight
        dataDetails.setInsight(fieldSet.readString("insight"));

        // set swot
        dataDetails.setSwot(fieldSet.readString("swot"));

        // set url
        dataDetails.setUrl(fieldSet.readString("url"));

        // set region
        dataDetails.setRegion(fieldSet.readString("region"));

        // set start_year
        String startYearString = fieldSet.readString("start_year");
        if (!StringUtils.isEmpty(startYearString)) {
            dataDetails.setStart_year(Long.parseLong(startYearString));
        }
        else dataDetails.setStart_year(0L);

        // set impact
        String impactString = fieldSet.readString("impact");
        if (!StringUtils.isEmpty(impactString)) {
            dataDetails.setImpact(Integer.parseInt(impactString));
        }
        else dataDetails.setImpact(0);

        // set added
        String addedString = fieldSet.readString("added");
        if (!StringUtils.isEmpty(addedString)) {
            SimpleDateFormat sdf = new SimpleDateFormat("MMMM, dd yyyy HH:mm:ss", Locale.ENGLISH);
            Date addedDate = null;
            try {
                addedDate = sdf.parse(addedString);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            dataDetails.setAdded(addedDate);
        }

// set published
        String publishedString = fieldSet.readString("published");
        if (!StringUtils.isEmpty(publishedString)) {
            SimpleDateFormat sdf = new SimpleDateFormat("MMMM, dd yyyy HH:mm:ss", Locale.ENGLISH);
            Date publishedDate = null;
            try {
                publishedDate = sdf.parse(publishedString);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            dataDetails.setPublished(publishedDate);
        }


        // set city
        dataDetails.setCity(fieldSet.readString("city"));

        // set country
        dataDetails.setCountry(fieldSet.readString("country"));

        // set relevance
        dataDetails.setRelevance(fieldSet.readInt("relevance"));

        // set pestle
        dataDetails.setPestle(fieldSet.readString("pestle"));

        // set source
        dataDetails.setSource(fieldSet.readString("source"));

        // set title
        dataDetails.setTitle(fieldSet.readString("title"));

        // set likelihood
        dataDetails.setLikelihood(fieldSet.readInt("likelihood"));

        return dataDetails;
    }
}
