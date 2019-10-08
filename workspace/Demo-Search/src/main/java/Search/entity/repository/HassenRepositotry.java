/*package Search.entity.repository;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;

import com.querydsl.core.types.Predicate;

import Search.entity.Hassen;
import Search.entity.MyUser;

public interface HassenRepositotry
		extends JpaRepository<Hassen, Long>, QueryDslPredicateExecutor<Hassen> {
	 EmailAddress email 
	List<Hassen> findByEmailAndLastName(String email, String lastname);

	// Enables the distinct flag for the query
	List<Hassen> findDistinctPeopleByLastnameOrFirstname(String lastname, String firstname);

	List<Hassen> findPeopleDistinctByLastnameOrFirstname(String lastname, String firstname);

	// Enabling ignoring case for an individual property
	List<Hassen> findByLastNameIgnoreCase(String lastname);

	// Enabling ignoring case for all suitable properties
	List<Hassen> findByLastNameAndFirstNameAllIgnoreCase(String lastname, String firstname);

	// Enabling static ORDER BY for a query
	List<Hassen> findByLastNameOrderByFirstNameAsc(String lastname);

	List<Hassen> findByLastNameOrderByFirstNameDesc(String lastname);

	Other
	//Page<MyUser> findByLastName(String lastname, Pageable pageable);

	Slice<Hassen> findByLastName(String lastname, Pageable pageable);

	List<Hassen> findByLastName(String lastname, Sort sort);

	//List<MyUser> findByLastName(String lastname, Pageable pageable);
	
	Hassen findFirstByOrderByLastnameAsc();

	Hassen findTopByOrderByAgeDesc();

	//Page<MyUser> queryFirst10ByLastname(String lastname, Pageable pageable);

	Slice<Hassen> findTop3ByLastname(String lastname, Pageable pageable);

	List<Hassen> findFirst10ByLastname(String lastname, Sort sort);

	List<Hassen> findTop10ByLastname(String lastname, Pageable pageable);

	@Query("select u from Hassen u")
	Stream<Hassen> findAllByCustomQueryAndStream();

	Stream<Hassen> readAllByFirstNameNotNull();

	@Query("select u from Hassen u")
	Stream<Hassen> streamAllPaged(Pageable pageable);
	
	Hassen findOne(Predicate predicate);             

    Iterable<Hassen> findAll(Predicate predicate);   

    long count(Predicate predicate);            

    boolean exists(Predicate predicate);


}
*/