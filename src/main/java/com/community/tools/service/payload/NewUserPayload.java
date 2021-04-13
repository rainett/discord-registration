package com.community.tools.service.payload;

import com.github.seratch.jslack.api.model.event.MessageEvent;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewUserPayload extends Payload {

  private Integer taskNumber;
  private String mentor;

  /**
   * Constructor class
   *
   * @param id           - usersId
   * @param messageEvent - variable for persistent
   * @param taskNumber   - variable for working Action
   * @param mentor       - variable for Action
   */
  public NewUserPayload(Integer id, MessageEvent messageEvent, Integer taskNumber, String mentor) {
    super(id, messageEvent);
    this.taskNumber = taskNumber;
    this.mentor = mentor;
  }
}
