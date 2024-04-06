package ru.itis.spring_11200.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.spring_11200.models.FileInfo;

public interface FilesRepository extends JpaRepository<FileInfo, Long> {
    FileInfo findByStorageFileName (String fileName);
}
