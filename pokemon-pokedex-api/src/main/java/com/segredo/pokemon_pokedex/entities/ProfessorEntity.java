package com.segredo.pokemon_pokedex.entities;

import java.util.ArrayList;
import java.util.List;

import com.segredo.pokemon_pokedex.entities.base.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

public class ProfessorEntity extends BaseEntity {
  // ## Table Title.
  public static final String TABLE_NAME = "professor";

  @Column(name = "auth_id", nullable = true)
  private String authId;
  
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "professor")
  private List<TrainerEntity> trainers = new ArrayList<TrainerEntity>();
}