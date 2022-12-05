package com.pabi.pabiitem.interfaces.item;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;

@Slf4j
@RequiredArgsConstructor
public class ItemKafkaProducer {
  private final KafkaTemplate<String, String> kafkaTemplate;

  public ItemDto.ItemKafkaRequest send(String topic, ItemDto.ItemKafkaRequest itemDto) {
    ObjectMapper mapper = new ObjectMapper();
    String jsonInString = "";
    try {
      jsonInString = mapper.writeValueAsString(itemDto);
    } catch(JsonProcessingException ex) {
      ex.printStackTrace();
    }

    kafkaTemplate.send(topic, jsonInString);
    log.info("!!!!!! Kafka Producer sent data from the Order microservice: " + itemDto);

    return itemDto;
  }
}
