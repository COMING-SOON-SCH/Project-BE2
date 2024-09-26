package soon.coming.springbootdeveloper.read.controller;

import soon.coming.springbootdeveloper.read.service.GetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class GetController {
    private final GetService getService;

}
