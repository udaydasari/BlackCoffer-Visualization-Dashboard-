package com.dataVisualizationbackend.repository;

import com.dataVisualizationbackend.model.DataDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailsRepository extends JpaRepository<DataDetails,Long> {
}
