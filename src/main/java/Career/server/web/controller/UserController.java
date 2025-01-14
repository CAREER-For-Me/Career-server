package Career.server.web.controller;

import Career.server.apiPayload.ApiResponse;
import Career.server.repository.UserRepository;
import Career.server.service.UserService;
import Career.server.web.dto.MySpecDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;

    @GetMapping("/myspec/{userId}")
    public ApiResponse<MySpecDto> getMySpec(@PathVariable("userId") Long userId) {
        return ApiResponse.onSuccess(userService.getSpec(userId));
    }

}
