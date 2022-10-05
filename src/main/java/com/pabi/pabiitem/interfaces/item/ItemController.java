package com.pabi.pabiitem.interfaces.item;

import com.pabi.pabiitem.application.item.ItemFacade;
import com.pabi.pabiitem.common.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ItemController {

  private final ItemFacade itemFacade;
  private final ItemDtoMapper itemDtoMapper;

  @GetMapping("/list")
  public CommonResponse getItemList() {
    var info = itemFacade.getItemList();
    var response = itemDtoMapper.of(info);
    return CommonResponse.success(response);
  }
}
