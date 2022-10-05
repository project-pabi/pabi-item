package com.pabi.pabiitem.domain.item;

import com.sun.istack.NotNull;
import com.vladmihalcea.hibernate.type.array.ListArrayType;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

@Entity
@NoArgsConstructor
@Getter
@TypeDef(name = "string-list", typeClass = ListArrayType.class)
public class Item {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotNull
  private String name;

  @Type(type = "string-list")
  @Column(columnDefinition = "text[]")
  private List<String> state;

  @Type(type = "string-list")
  @Column(columnDefinition = "text[]")
  private List<String> keyword;

  private String explanation;


}
