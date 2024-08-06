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
@SQLDelete(sql = "UPDATE " + TrainerEntity.TABLE_NAME + " SET deleted_at=sysdate() where id = ?", verify = Expectation.RowCount.class)
@Entity
@Table(name = TrainerEntity.TABLE_NAME)
public class TrainerEntity extends BaseEntity {
  // ## Table Title.
  public static final String TABLE_NAME = "trainer";

  @Column(name = "auth_id", nullable = true)
  private String authId;

  @ManyToOne(fetch = FetchType.LAZY)
  @NotNull
  private ProfessorEntity  professor;

}
