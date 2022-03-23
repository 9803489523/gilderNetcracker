package com.netcracker.challenge.rest.api;

import com.netcracker.challenge.service.logic.VotingService;
import com.netcracker.challenge.service.model.VoteDto;
import com.netcracker.challenge.service.model.VotingCreateDto;
import com.netcracker.challenge.service.model.VotingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/voting")
public class VotingController {

    private final VotingService service;

    @Autowired
    public VotingController(VotingService service) {
        this.service = service;
    }

    @PostMapping("/start")
    public VotingDto startVoting(@RequestBody VotingCreateDto dto) {
        return service.startVoting(dto);
    }

    @PutMapping("/edit/{votingId}")
    public void editVoting(@RequestBody VotingDto dto, @PathVariable int votingId) {
        service.editVoting(dto, votingId);
    }

    @DeleteMapping("/{votingId}")
    public void deleteVoting(@PathVariable int votingId) {
        service.deleteVotingById(votingId);
    }

    @GetMapping("/{votingId}")
    public VotingDto getVoting(@PathVariable int votingId) {
        return service.getVotingById(votingId);
    }

    @PostMapping("/vote")
    public void vote(@RequestBody VoteDto dto){
        service.vote(dto);
    }

}
