package com.segredo.pokemon_pokedex.entities;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.jdbc.Expectation;

import com.segredo.pokemon_pokedex.entities.base.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@SQLRestriction("deleted_at is null")
@SQLDelete(sql = "UPDATE " + PokemonEntity.TABLE_NAME + " SET deleted_at=sysdate() where id = ?", verify = Expectation.RowCount.class)
@Entity
@Table(name = PokemonEntity.TABLE_NAME)
public class PokemonEntity extends BaseEntity {
  // ## Table Title.
  public static final String TABLE_NAME = "pokemon";

  @Column(name = "national_id", nullable = false)
  private String nationalId;

  @Column(name = "name", nullable = false)
  private String name;
  
  @ManyToOne(fetch = FetchType.LAZY)
  private RegionEntity region;

  @ManyToOne(fetch = FetchType.LAZY)
  @NotNull
  private PokemonStatsEntity stats;

  @ManyToOne(fetch = FetchType.LAZY)
  private PokemonTypeEntity mainType;

  @ManyToOne(fetch = FetchType.LAZY)
  private PokemonTypeEntity subType;
}
