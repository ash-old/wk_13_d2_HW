package com.codeclan.example.OneToManyHW.repositories;

import com.codeclan.example.OneToManyHW.models.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FolderRepository extends JpaRepository<Folder, Long> {
}
