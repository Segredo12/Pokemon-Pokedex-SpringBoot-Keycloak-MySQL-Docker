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
@SQLDelete(sql = "UPDATE " + PokemonStatsEntity.TABLE_NAME + " SET deleted_at=sysdate() where id = ?", verify = Expectation.RowCount.class)
@Entity
@Table(name = PokemonStatsEntity.TABLE_NAME)
public class PokemonStatsEntity {
  // ## Table Title.
  public static final String TABLE_NAME = "pokemon_stats";

  @Column(name = "hitpoints", nullable = false)
  private int hitpoints;

  @Column(name = "attack", nullable = false)
  private int attack;

  @Column(name = "defense", nullable = false)
  private int defense;

  @Column(name = "special_attack", nullable = false)
  private int specialAttack;

  @Column(name = "special_defense", nullable = false)
  private int specialDefense;

  @Column(name = "speed", nullable = false)
  private int speed;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "stats")
  private List<PokemonEntity> pokemons = new ArrayList<PokemonEntity>();
}
