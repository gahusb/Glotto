package com.spring.domain.glotto.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.glotto.dao.GlottoRepository;
import com.spring.domain.glotto.domain.Glotto;
import com.spring.domain.glotto.dto.GlottoSaveDTO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor    //final or NonNull 옵션 필드를 전부 포함한 생성자 만들어줌
@Service
public class GlottoService {
    
    @Autowired
    private GlottoRepository glottoRepository;

    // SELECT List
    public List<Glotto> findAll() throws Exception {
        return glottoRepository.findAll();
    }

    // SELECT By Id
    public Optional<Glotto> findById(int round) throws Exception {
        return glottoRepository.findById(round);
    }

    // INSERT
    public String insert(GlottoSaveDTO glotto) throws Exception {
        String result = null;
        int round = glotto.getRound();
        Optional<Glotto> dto = glottoRepository.findById(round);
        if(dto.isPresent()) {
            result = "already number";
        } else {
            glottoRepository.save(glotto);
            result = "success";
        }
        return result;
    }

    // UPDATE
    public String update(int round, GlottoSaveDTO glotto) throws Exception {
        Optional<Glotto> dto = glottoRepository.findById(round);

        if(dto.isPresent()) {
            glottoRepository.update(round, glotto);
            return "update success";
        } else {
            return "update fail";
        }
    }

    // DELETE
    public String deleteById(int round) throws Exception {
        String result = "null";
        Optional<Glotto> dto = glottoRepository.findById(round);

        if(dto.isPresent()) {
            glottoRepository.deleteById(round);
            result = "delete success";
        } else {
            result = "delete fail";
        }
        return result;
    }
}
