package com.spring.domain.glotto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;

import com.spring.domain.glotto.dao.GlottoRepository;
import com.spring.domain.glotto.domain.Glotto;

// @ExtendWith(SpringExtension.class)
// @DataJpaTest
// @Import(JpaConfig.class)
// @AutoConfigureTestDatabase(replace = Replace.NONE)
public class GlottoTest {
    
    // @Autowired
    // GlottoRepository glottoRepository;

    // @Test
    // void testSave() {
    //     Glotto glotto = new Glotto(103, 2, 3, 6, 19, 36, 39, 26, (long)1585019672, (long)52833990, (long)1524241, (long)50000, (long)5000);
        
    //     glottoRepository.save(glotto);
        
    //     int round = glotto.getRound();
    //     Glotto findGlotto = glottoRepository.findById(round).orElse(null);
        
    //     Assertions.assertNotNull(findGlotto);
    //     Assertions.assertEquals(findGlotto.getRound(), round);
        
        
    // }
}
