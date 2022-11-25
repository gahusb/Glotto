package com.spring.domain.glotto.dto;

import com.spring.domain.glotto.domain.Glotto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "로또 당첨번호 검색 응답 DTO")
public class GlottoSearchWinNumberResponseDTO {
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

    public GlottoSearchWinNumberResponseDTO() {
    }

    public GlottoSearchWinNumberResponseDTO(int round, int first, int second, int third, int fourth, int fifth,
            int sixth, int bonus) {
        this.round = round;
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.fifth = fifth;
        this.sixth = sixth;
        this.bonus = bonus;
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
                    .build();
    }
}
