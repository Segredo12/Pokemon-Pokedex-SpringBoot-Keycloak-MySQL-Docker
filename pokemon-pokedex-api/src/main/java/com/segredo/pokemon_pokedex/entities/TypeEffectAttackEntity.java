package com.segredo.pokemon_pokedex.entities;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.jdbc.Expectation;

import com.segredo.pokemon_pokedex.entities.enums.TypeEffectStatusEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@SQLRestriction("deleted_at is null")
@SQLDelete(sql = "UPDATE " + TypeEffectAttackEntity.TABLE_NAME + " SET deleted_at=sysdate() where id = ?", verify = Expectation.RowCount.class)
@Entity
@Table(name = TypeEffectAttackEntity.TABLE_NAME)
public class TypeEffectAttackEntity {
  // ## Table Title.
  public static final String TABLE_NAME = "type_effect_attack";

  @ManyToOne(fetch = FetchType.LAZY)
  private PokemonTypeEntity baseType;

  @ManyToOne(fetch = FetchType.LAZY)
  private PokemonTypeEntity effectType;

  private TypeEffectStatusEnum status;
}
