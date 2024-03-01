package com.example.d6ex1ps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.d6ex1ps.model.Children;


@Repository
public interface ChildrenRepo extends JpaRepository<Children,Integer>{
}