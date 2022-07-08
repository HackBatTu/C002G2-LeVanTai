package com.link.repository;

import com.link.model.contract.DetailsContract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDetailsContractRepository  extends JpaRepository<DetailsContract, Integer> {
}
