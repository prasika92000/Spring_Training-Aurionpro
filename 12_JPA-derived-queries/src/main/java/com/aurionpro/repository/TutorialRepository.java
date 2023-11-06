package com.aurionpro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.entity.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

	List<Tutorial> findByLevel(int level);

	List<Tutorial> findByPublished(boolean isPublished);

	List<Tutorial> findByLevelIs(int level);

	List<Tutorial> findByLevelEquals(int level);

	List<Tutorial> findByLevelNot(int level);

	List<Tutorial> findByLevelIsNot(int level);

	List<Tutorial> findByLevelAndPublished(int level, boolean isPublished);

	List<Tutorial> findByTitleOrDescription(String title, String description);

	List<Tutorial> findByTitleLike(String title);

	List<Tutorial> findByTitleStartingWith(String title);

	List<Tutorial> findByTitleEndingWith(String title);

	List<Tutorial> findByTitleContaining(String title);

	List<Tutorial> findByTitleContainingOrDescriptionContaining(String title, String description);

	List<Tutorial> findByTitleContainingAndPublished(String title, boolean isPublished);

}