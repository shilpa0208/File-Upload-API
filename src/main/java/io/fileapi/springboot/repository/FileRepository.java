package io.fileapi.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.fileapi.springboot.entity.File;

@Repository
public interface FileRepository extends CrudRepository<File, Integer>{

}
