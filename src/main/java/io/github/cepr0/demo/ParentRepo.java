package io.github.cepr0.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentRepo extends JpaRepository<Parent, Integer> {
}
