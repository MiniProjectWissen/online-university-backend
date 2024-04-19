package com.example.university.dao;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.university.entity.DatabaseFile;


@Repository
public interface DatabaseFileRepository extends JpaRepository<DatabaseFile, String> {

	Optional<DatabaseFile> findById(String fileId);

	Object findByFileName(String fileName);

}
