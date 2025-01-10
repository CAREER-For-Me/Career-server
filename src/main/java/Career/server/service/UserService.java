package Career.server.service;

import Career.server.domain.mapping.Edu;
import Career.server.domain.mapping.Lang;
import Career.server.domain.mapping.User;
import Career.server.repository.*;
import Career.server.web.dto.MySpecDto;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final EduRepository eduRepository;
    private final LangRepository langRepository;
    private final ExpRepository expRepository;
    private final AwardRepository awardRepository;
    private final QualRepository qualRepository;

    @Transactional(readOnly = true)
    public MySpecDto getSpec(Long userId) {
        User findUser = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("cannot find user by id : " + userId));
        Edu findEdu = eduRepository.findByUser(findUser);
        Integer toeicScore = langRepository.findToeicScore(findUser);
        String tosLevel = langRepository.findTosLevel(findUser);
        Integer internCount = expRepository.findInternCount(findUser);
        Integer awardCount = awardRepository.findAwardCount(findUser);
        Integer qualCount = qualRepository.findQualCount(findUser);

        return new MySpecDto(findEdu.getTotalScore(), toeicScore, tosLevel, internCount, awardCount, qualCount);

    }
}
