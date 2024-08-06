package com.segredo.pokemon_pokedex.entities;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.jdbc.Expectation;

import com.segredo.pokemon_pokedex.entities.base.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@SQLRestriction("deleted_at is null")
@SQLDelete(sql = "UPDATE " + RegionEntity.TABLE_NAME + " SET deleted_at=sysdate() where id = ?", verify = Expectation.RowCount.class)
@Entity
@Table(name = RegionEntity.TABLE_NAME)
public class RegionEntity extends BaseEntity {
  // ## Table  Title
  public static final String TABLE_NAME = "region";

  @Column(name = "name", nullable = false)
  private String name;
}
