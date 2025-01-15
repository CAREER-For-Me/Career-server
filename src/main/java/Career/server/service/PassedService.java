package Career.server.service;

import Career.server.domain.enums.Major;
import Career.server.repository.PassedRepository;
import Career.server.web.dto.response.PassedResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PassedService {

    private final PassedRepository passedRepository;

    @Transactional(readOnly = true)
    public PassedResponseDto findAvgPassedSpec(Major major) {
        return new PassedResponseDto(passedRepository.findByMajor(major));
    }
}
