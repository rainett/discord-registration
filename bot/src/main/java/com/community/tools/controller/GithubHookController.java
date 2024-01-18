package com.community.tools.controller;

import com.community.tools.service.github.event.GithubEventsProcessingService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/gitHook")
@Slf4j
public class GithubHookController {

  private final GithubEventsProcessingService eventsProcessingService;

  /**
   * Method receive webhook data from GitHub.
   *
   * @param body event body
   */
  @PostMapping
  public void getHookData(@RequestBody String body) {
    JSONObject eventJson = new JSONObject(body);
    eventsProcessingService.processEvent(eventJson);
  }

}

