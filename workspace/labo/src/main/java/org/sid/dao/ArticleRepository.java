package org.sid.dao;

import org.sid.entities.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ArticleRepository extends JpaRepository<Article, String> {

	@Query("select a from Article a where a.codeArt like :x ")
	public Page<Article> chercherArticle(@Param("x")String mc,Pageable pageable);
	
}
