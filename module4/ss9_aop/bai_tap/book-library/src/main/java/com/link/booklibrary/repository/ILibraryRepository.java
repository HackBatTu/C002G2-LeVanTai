package com.link.booklibrary.repository;

import com.link.booklibrary.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILibraryRepository extends JpaRepository<Library, Integer> {
}
