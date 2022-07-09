package com.link.repository;

import com.link.model.contract.FacilityAttach;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFacilityAttachRepository extends JpaRepository<FacilityAttach,Integer> {
}
