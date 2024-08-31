package Soon.Coming.springbootdeveloper.read.controller;

import Soon.Coming.springbootdeveloper.read.service.GetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class GetController {
    private final GetService getService;

}
