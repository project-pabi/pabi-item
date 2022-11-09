package com.pabi.pabiitem.interfaces.item;

import com.pabi.pabiitem.application.item.ItemFacade;
import com.pabi.pabiitem.common.response.CommonResponse;
import com.pabi.pabiitem.interfaces.item.ItemDto.ItemResponse;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Validated
public class ItemController {

  private final ItemFacade itemFacade;
  private final ItemDtoMapper itemDtoMapper;

  @GetMapping("/")
  @ApiOperation(value = "경매물품 리스트 조회")
  public CommonResponse<List<ItemResponse>> getItemList() {
    var info = itemFacade.getItemList();
    var response = itemDtoMapper.of(info);
    return CommonResponse.success(response);
  }

  @PostMapping("/")
  @ApiOperation(value = "경매물품 생성")
  public CommonResponse createItem(@RequestBody @Valid ItemDto.ItemCreateRequest request) {
    var command = itemDtoMapper.of(request);
    var response = itemFacade.createItem(command);
    return CommonResponse.success(response, "물품이 등록 되었습니다.");
  }

  @PatchMapping("/{id}")
  @ApiOperation(value = "경매물품 수정")
  public CommonResponse updateItem(@PathVariable Long id, @RequestBody @Valid ItemDto.ItemUpdateRequest request) {
    var command = itemDtoMapper.of(request);
    itemFacade.updateItem(id, command);
    return CommonResponse.success(null, "물품이 수정 되었습니다.");
  }

  @DeleteMapping("/{id}")
  @ApiOperation(value = "경매물품 삭제")
  public CommonResponse deleteItem(@PathVariable("id") Long id){
    itemFacade.deleteItem(id);
    return CommonResponse.success(null,  "물품이 삭제 되었습니다.");
  }




}
