package com.spring.domain.glotto.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Builder;
import lombok.Data;

@Entity(name = "win_number2")
// @Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor 의 5가지 어노테이션을 포함하고 있는 데이터 (lombok)
@Data
@ConfigurationProperties(prefix = "glottoDomain")
public class Glotto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int round;
    @Column(columnDefinition = "INT", nullable = false)
    private int first;
    @Column(columnDefinition = "INT", nullable = false)
    private int second;
    @Column(columnDefinition = "INT", nullable = false)
    private int third;
    @Column(columnDefinition = "INT", nullable = false)
    private int fourth;
    @Column(columnDefinition = "INT", nullable = false)
    private int fifth;
    @Column(columnDefinition = "INT", nullable = false)
    private int sixth;
    @Column(columnDefinition = "INT", nullable = false)
    private int bonus;
    @Column(columnDefinition = "BIGINT", nullable = true)
    private Long first_place;
    @Column(columnDefinition = "BIGINT", nullable = true)
    private Long second_place;
    @Column(columnDefinition = "BIGINT", nullable = true)
    private Long third_place;
    @Column(columnDefinition = "BIGINT", nullable = true)
    private Long fourth_place;
    @Column(columnDefinition = "BIGINT", nullable = true)
    private Long fifth_place;

    public Glotto() {}

    @Builder
    public Glotto(int round, int first, int second, int third, int fourth, int fifth, int sixth, int bonus) {
        this.round = round;
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.fifth = fifth;
        this.sixth = sixth;
        this.bonus = bonus;
    }

    @Builder
    public Glotto(int round, int first, int second, int third, int fourth, int fifth, int sixth, int bonus,
            Long first_place, Long second_place, Long third_place, Long fourth_place, Long fifth_place) {
        this.round = round;
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.fifth = fifth;
        this.sixth = sixth;
        this.bonus = bonus;
        this.first_place = first_place;
        this.second_place = second_place;
        this.third_place = third_place;
        this.fourth_place = fourth_place;
        this.fifth_place = fifth_place;
    }
}
