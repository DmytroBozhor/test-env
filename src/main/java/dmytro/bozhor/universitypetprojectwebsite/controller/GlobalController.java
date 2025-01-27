package dmytro.bozhor.universitypetprojectwebsite.controller;

import dmytro.bozhor.universitypetprojectwebsite.mapper.PersonMapper;
import dmytro.bozhor.universitypetprojectwebsite.service.PersonService;
import dmytro.bozhor.universitypetprojectwebsite.util.ControllerDispatcherUtil;
import dmytro.bozhor.universitypetprojectwebsite.util.EndpointValuesContainer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static dmytro.bozhor.universitypetprojectwebsite.util.EndpointValuesContainer.*;

@Controller
@RequiredArgsConstructor
@Slf4j
public class GlobalController {

    private final PersonService personService;

    private final PersonMapper personMapper;

    @GetMapping(HOME)
    @ResponseStatus(HttpStatus.OK)
    public String getHomePage() {
        return EndpointValuesContainer.getHtmlPageByName(HOME);
    }

    @GetMapping(C_PLUS_PLUS)
    @ResponseStatus(HttpStatus.OK)
    public String getCPlusPlusPage() {
        return EndpointValuesContainer.getHtmlPageByName(C_PLUS_PLUS);
    }

    @GetMapping(C_SHARP)
    @ResponseStatus(HttpStatus.OK)
    public String getCSharpPage() {
        return EndpointValuesContainer.getHtmlPageByName(C_SHARP);
    }

    @GetMapping(JAVA)
    @ResponseStatus(HttpStatus.OK)
    public String getJavaPage() {
        return EndpointValuesContainer.getHtmlPageByName(JAVA);
    }

    @GetMapping(PYTHON)
    @ResponseStatus(HttpStatus.OK)
    public String getPythonPage() {
        return EndpointValuesContainer.getHtmlPageByName(PYTHON);
    }

    @GetMapping(REGISTER)
    @ResponseStatus(HttpStatus.OK)
    public String getRegisterPage() {
        return EndpointValuesContainer.getHtmlPageByName(REGISTER);
    }

    @GetMapping(LOGIN)
    @ResponseStatus(HttpStatus.OK)
    public String getLoginPage() {
        return EndpointValuesContainer.getHtmlPageByName(LOGIN);
    }

    @PostMapping(REGISTER)
    @ResponseStatus(HttpStatus.FOUND)
    public String register(@RequestParam String username, @RequestParam String email, @RequestParam String password) {

        var person = personService.create(personMapper.map(username, email, password));
        log.debug("Person saved to the database: {}", person);

        return ControllerDispatcherUtil.sendRedirect(LOGIN);
    }

    /*@PostMapping(LOGIN)
    @ResponseStatus(HttpStatus.FOUND)
    public String login(@RequestParam String email, @RequestParam String password) {

        personService.login(email, password);

        return ControllerDispatcherUtil.sendRedirect(HOME);
    }*/
}
