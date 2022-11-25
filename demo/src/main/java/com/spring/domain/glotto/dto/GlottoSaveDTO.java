package com.spring.domain.glotto.dto;

import com.spring.domain.glotto.domain.Glotto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Schema(description = "로또번호 등록 응답 DTO")
@Getter
public class GlottoSaveDTO {

    @Schema(description = "회차")
    private int round;

    @Schema(description = "첫 번째 번호")
    private int first;

    @Schema(description = "두 번째 번호")
    private int second;

    @Schema(description = "세 번째 번호")
    private int third;

    @Schema(description = "네 번째 번호")
    private int fourth;

    @Schema(description = "다섯 번째 번호")
    private int fifth;

    @Schema(description = "여섯 번째 번호")
    private int sixth;

    @Schema(description = "보너스 번호")
    private int bonus;

    @Schema(description = "1등 당첨금")
    private Long first_place;

    @Schema(description = "2등 당첨금")
    private Long second_place;

    @Schema(description = "3등 당첨금")
    private Long third_place;

    @Schema(description = "4등 당첨금")
    private Long fourth_place;

    @Schema(description = "5등 당첨금")
    private Long fifth_place;

    public GlottoSaveDTO() {
    }

    public GlottoSaveDTO(int round, int first, int second, int third, int fourth, int fifth, int sixth, int bonus,
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

    //resquest dto 로 받은 Posts 객체를 entity 화하여 저장하는 용도
    public Glotto toEntity() {
        return Glotto.builder()
                    .round(round)
                    .first(first)
                    .second(second)
                    .third(third)
                    .fourth(fourth)
                    .fifth(fifth)
                    .sixth(sixth)
                    .bonus(bonus)
                    .first_place(first_place)
                    .second_place(second_place)
                    .third_place(third_place)
                    .fourth_place(fourth_place)
                    .fifth_place(fifth_place)
                    .build();
    }
}
