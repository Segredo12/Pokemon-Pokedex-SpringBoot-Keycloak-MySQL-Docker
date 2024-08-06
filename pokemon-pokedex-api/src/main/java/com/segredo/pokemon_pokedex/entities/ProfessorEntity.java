package com.segredo.pokemon_pokedex.entities;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.jdbc.Expectation;

import com.segredo.pokemon_pokedex.entities.base.BaseEntity;

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
@SQLDelete(sql = "UPDATE " + ProfessorEntity.TABLE_NAME + " SET deleted_at=sysdate() where id = ?", verify = Expectation.RowCount.class)
@Entity
@Table(name = ProfessorEntity.TABLE_NAME)
public class ProfessorEntity extends BaseEntity {
  // ## Table Title.
  public static final String TABLE_NAME = "professor";

  @Column(name = "auth_id", nullable = true)
  private String authId;
  
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "professor")
  private List<TrainerEntity> trainers = new ArrayList<TrainerEntity>();
}