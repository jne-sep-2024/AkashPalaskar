package com.think.restful_web_service.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson(){
        return new PersonV1("Bob Charli");
    }
    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionOfPerson(){
        return new PersonV2(new Name("Bob","Charli"));
    }
    @GetMapping(path = "/person",params = "version=1")
    public PersonV1 getFirstVersionOfPersonOfRequestparam(){
        return new PersonV1("Bob Charli");
    }

    @GetMapping(path = "/person",params = "version=2")
    public PersonV2 getSecondVersionOfPersonOfRequestParam(){
        return new PersonV2(new Name("Bob","Charli"));
    }

    @GetMapping(path = "/person/header",headers = "X-API-VERSION=1")
    public PersonV1 getFirstVersionOfPersonOfRequestHEader(){
        return new PersonV1("Bob Charli");
    }
    @GetMapping(path = "/person/header",headers = "X-API-VERSION=2")
    public PersonV2 getSecondVersionOfPersonOfRequestheader(){
        return new PersonV2(new Name("Bob","Charli"));
    }

    @GetMapping(path = "/person/accept",produces = "application/vnd.company.app-v1+json")
    public PersonV1 getFirstVersionOfPersonOfAcceptHeader(){
        return new PersonV1("Bob Charli");
    }
    @GetMapping(path = "/person/accept",produces = "application/vnd.company.app-v2+json")
    public PersonV2 getSecondVersionOfPersonOfAcceptHeader(){
        return new PersonV2(new Name("Bob","Charli"));
    }
}
