package net.mymicroservices.storeservice.repository;

import net.mymicroservices.storeservice.entity.WebinfoData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebinfoDataRepository extends JpaRepository<WebinfoData, Long> {

}
