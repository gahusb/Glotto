package com.spring.domain.glotto.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.domain.glotto.domain.Glotto;
import com.spring.domain.glotto.dto.GlottoSaveDTO;

@Repository
public interface GlottoRepository extends JpaRepository<Glotto, Long>{

    String INSERT_GLOTTO = "INSERT INTO win_number2 " +
        "(round, first, second, third, fourth, fifth, sixth, bonus, " +
        "first_place, second_place, third_place, fourth_place, fifth_place) " +
        "VALUES (:#{#paramGlotto.round}, :#{#paramGlotto.first}, :#{#paramGlotto.second}, :#{#paramGlotto.third}, " +
        ":#{#paramGlotto.fourth}, :#{#paramGlotto.fifth}, :#{#paramGlotto.sixth}, :#{#paramGlotto.bonus}, " + 
        ":#{#paramGlotto.first_place}, :#{#paramGlotto.second_place}, :#{#paramGlotto.third_place}, " + 
        ":#{#paramGlotto.fourth_place}, :#{#paramGlotto.fifth_place})";

    String UPDATE_GLOTTO = "UPDATE win_number2 n " + 
        "SET n.round = :#{#paramGlotto.round}, " + 
        "n.first = :#{#paramGlotto.first}, " + 
        "n.second = :#{#paramGlotto.second}, " + 
        "n.third = :#{#paramGlotto.third}, " + 
        "n.fourth = :#{#paramGlotto.fourth}, " + 
        "n.fifth = :#{#paramGlotto.fifth}, " + 
        "n.sixth = :#{#paramGlotto.sixth}, " + 
        "n.bonus = :#{#paramGlotto.bonus}, " + 
        "n.first_place = :#{#paramGlotto.first_place}, " + 
        "n.second_place = :#{#paramGlotto.second_place}, " + 
        "n.third_place = :#{#paramGlotto.third_place}, " + 
        "n.fourth_place = :#{#paramGlotto.fourth_place}, " + 
        "n.fifth_place = :#{#paramGlotto.fifth_place}, " + 
        "WHERE nbSeq like :paramRound";

    String DELETE_GLOTTO = "DELETE FROM win_number2 n WHERE n.round like :paramRound";

    @Query(value = "SELECT new com.spring.domain.glotto.dto.GlottoSearchWinNumberResponseDTO(n.round as round, " + 
            "n.first as first, n.second as second, n.third as third, n.fourth as fourth, " + 
            "n.fifth as fifth, n.sixth as sixth, n.bonus as bonus) " +
            "FROM win_number2 n " +
            "WHERE n.round like :paramRound")
    Optional<Glotto> findById(@Param("paramRound") Integer round);

    @Query(value = "SELECT n " +
            "FROM win_number2 n ")
    List<Glotto> findAll();

    @Transactional
	@Modifying
    @Query(value = INSERT_GLOTTO, nativeQuery = true)
    void save(@Param("paramGlotto") GlottoSaveDTO glotto);

    @Transactional
	@Modifying
	@Query(value = UPDATE_GLOTTO, nativeQuery = true)
    void update(@Param("paramRound") Integer round, @Param("paramGlotto") GlottoSaveDTO glotto);

    @Transactional
	@Modifying
    @Query(value = DELETE_GLOTTO, nativeQuery = true)
    void deleteById(@Param("paramRound") Integer round);
}
