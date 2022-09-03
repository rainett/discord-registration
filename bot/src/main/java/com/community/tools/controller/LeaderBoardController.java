package com.community.tools.controller;

import com.community.tools.dto.UserDto;
import com.community.tools.service.LeaderBoardService;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LeaderBoardController {

  private static final Integer DAYS_IN_A_WEEK = 7;
  private final LeaderBoardService leaderBoardService;

  public LeaderBoardController(LeaderBoardService leaderBoardService) {
    this.leaderBoardService = leaderBoardService;
  }

  //todo delete it later
  @GetMapping("/test/leaderboard")
  public ResponseEntity<String> test(
      @RequestParam(required = false) Optional<Integer> days) {
    return new ResponseEntity<>(
        Period.ofDays(days.orElse(DAYS_IN_A_WEEK)).toString(),
        HttpStatus.OK);
  }

  @GetMapping("/leaderboard")
  public ResponseEntity<List<UserDto>> getLeaderboard(
      @RequestParam(required = false) Optional<Integer> days) {
    return new ResponseEntity<>(
        leaderBoardService.getActiveUsersFromPeriod(Period.ofDays(days.orElse(DAYS_IN_A_WEEK))),
        HttpStatus.OK);
  }

}
