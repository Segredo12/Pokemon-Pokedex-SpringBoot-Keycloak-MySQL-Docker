package com.segredo.pokemon_pokedex.entities;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.jdbc.Expectation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@SQLRestriction("deleted_at is null")
@SQLDelete(sql = "UPDATE " + PokemonTypeEntity.TABLE_NAME + " SET deleted_at=sysdate() where id = ?", verify = Expectation.RowCount.class)
@Entity
@Table(name = PokemonTypeEntity.TABLE_NAME)
public class PokemonTypeEntity {
  // ## Table Title.
  public static final String TABLE_NAME = "pokemon_type";

  @Column(name = "name", nullable = false)
  private String name;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "baseType")
  private List<TypeEffectAttackEntity> attackEffects = new ArrayList<>();

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "baseType")
  private List<TypeEffectDefenseEntity> defenseEffects = new ArrayList<>();

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "mainType")
  private List<PokemonEntity> mainType = new ArrayList<>();

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "subType")
  private List<PokemonEntity> subType = new ArrayList<>();
}
