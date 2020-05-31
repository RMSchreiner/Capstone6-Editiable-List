package co.grandcircus.Capstone6.dao;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.Capstone6.entity.Task;

public interface TaskRepository extends JpaRepository <Task, Long> {
	
	Optional<Task> findById(Long id);
	List<Task> findByUserId(Long userId);
    void deleteById(Long id);
}
