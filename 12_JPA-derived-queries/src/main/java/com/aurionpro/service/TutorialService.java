package com.aurionpro.service;

import java.util.List;
import java.util.Optional;

import com.aurionpro.entity.Tutorial;

public interface TutorialService {

	List<Tutorial> findAll();

	List<Tutorial> findByLevel(int level);

	List<Tutorial> findByPublished(boolean b);

	List<Tutorial> findByLevelIs(int level);

	List<Tutorial> findByLevelEquals(int level);

	Optional<Tutorial> findById(long id);

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

	List<Tutorial> findByPublishedTrue();

	List<Tutorial> findByPublishedFalse();
}