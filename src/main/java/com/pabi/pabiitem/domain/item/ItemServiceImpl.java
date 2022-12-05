package com.pabi.pabiitem.domain.item;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pabi.pabiitem.domain.item.ItemCommand.ItemCreateRequest;
import com.pabi.pabiitem.interfaces.item.ItemDto.ItemKafkaRequest;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
class ItemServiceImpl implements ItemService {

  private final ItemReader itemReader;
  private final ItemStore itemStore;
  private final ItemMapper itemMapper;
  private final KafkaTemplate<String, String> kafkaTemplate;

  @Override
  @Transactional(readOnly = true)
  public List<ItemInfo.Main> getItemList() {
    return itemMapper.of(itemReader.getItemList());
  }

  @Override
  @Transactional
  public long createItem(ItemCreateRequest command, String uuid) {
    long itemId = itemStore.createItem(command);
    send("item-topic",itemReader.getItem(itemId));
    return itemId;
  }

  @Override
  @Transactional
  public void updateItem(Long id, ItemCommand.ItemUpdateRequest command) {
    Item item = itemReader.getItem(id);
    itemStore.updateItem(item, command);
  }

  @Override
  @Transactional
  public void deleteItem(Long id) {
    itemStore.deleteItem(id);
  }

  @Override
  public ItemKafkaRequest send(String topic, ItemKafkaRequest itemDto) {
    return null;
  }

  public Item send(String topic, Item itemDto) {
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
