package com.netcracker.challenge.rest.api;

import com.netcracker.challenge.service.logic.ChallengeRecordService;
import com.netcracker.challenge.service.model.ChallengeRecordCreateDto;
import com.netcracker.challenge.service.model.ChallengeRecordDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/challenges")
public class ChallengeRecordController {

    private final ChallengeRecordService service;

    @Autowired
    public ChallengeRecordController(ChallengeRecordService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ChallengeRecordDto createChallenge(@RequestBody ChallengeRecordCreateDto dto) {
        return service.createChallenge(dto);
    }

    @PutMapping("/edit/{challengeId}")
    public void editChallenge(@RequestBody ChallengeRecordDto dto, @PathVariable int challengeId) {
        service.editChallenge(dto, challengeId);
    }

    @DeleteMapping("/{challengeId}")
    public void deleteChallenge(@PathVariable int challengeId) {
        service.deleteChallengeById(challengeId);
    }

    @GetMapping("/{challengeId}")
    public ChallengeRecordDto getChallenge(@PathVariable int challengeId) {
        return service.getChallengeById(challengeId);
    }

    @PutMapping("/{challengeId}/complete")
    public void completeChallenge(@PathVariable int challengeId) {
        service.completeChallengeById(challengeId);
    }

}
