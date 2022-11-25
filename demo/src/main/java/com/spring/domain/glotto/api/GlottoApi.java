package com.spring.domain.glotto.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;  // 'null일 수도 있는 객체'를 감싸는 일종의 Wrapper 클래스입니다.

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.domain.glotto.application.GlottoService;
import com.spring.domain.glotto.domain.Glotto;
import com.spring.domain.glotto.dto.GlottoSaveDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController     // JSON으로 데이터를 주고 받음을 선언
@RequestMapping("/glotto")
@RequiredArgsConstructor
@Api(tags = {"당첨번호"})
public class GlottoApi {

    @Autowired
    private final GlottoService glottoService;

    @GetMapping("/home")
    @ApiOperation(value = "연동 테스트", notes = "스프링부트와 연동을 테스트한다.")  // Swagger에 사용하는 API에 대한 간단 설명
    public String getHome() {
        return "Hello home!";
    }

    @GetMapping("/selectAll")  // 전체 List 조회 API
    @ApiOperation(value = "번호 전체 조회", notes = "등록된 전체 로또 번호를 조회하는 API")
    public List<Glotto> selectNumberList() throws Exception {
        List<Glotto> list = new ArrayList<Glotto>();
        try {
            list = glottoService.findAll();

            if(list.isEmpty()) {
                System.out.println("list is empty");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @GetMapping("/glottoSelect/{round}")  // 특정 회차 조회 API
    @ApiOperation(value = "번호 검색", notes = "로또 당첨 번호를 기반으로 번호 정보를 검색합니다.")
    @ApiImplicitParam(name = "round", value = "회차") // request 정보
    @ApiResponses({ // response 정보
            @ApiResponse(code = 200, message = "success", response = Glotto.class),
            @ApiResponse(code = 204, message = "Number not exists"),
    })
    public Optional<Glotto> selectNumber(@PathVariable int round) throws Exception {
        Optional<Glotto> result = null;
        try {
            result = glottoService.findById(round);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @PostMapping("/glottoInsert") // 등록 API
    @ApiOperation(value = "당첨 번호 등록", notes = "로또 당첨 번호를 등록하는 API")
    public String insertNumber(@RequestBody GlottoSaveDTO glotto) throws Exception {
        String result = null;
        try {
            result = glottoService.insert(glotto);

            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @PutMapping("/glottoUpdate/{round}")
    @ApiOperation(value = "번호 업데이트", notes = "특정 회차 로또 당첨 번호를 수정합니다.")
    @ApiImplicitParam(name = "round", value = "회차")
    public String updateNumber(@PathVariable int round, @RequestBody GlottoSaveDTO glotto) throws Exception {
        String result = null;
        try {
            result = glottoService.update(round, glotto);

            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @DeleteMapping("/glottoDelete/{round}")
    @ApiOperation(value = "번호 삭제", notes = "특정 회차 로또 당첨 번호를 삭제합니다.")
    @ApiImplicitParam(name = "round", value = "회차")
    public String deleteNumber(int round) throws Exception {
        String result = null;
        try {
            result = glottoService.deleteById(round);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
