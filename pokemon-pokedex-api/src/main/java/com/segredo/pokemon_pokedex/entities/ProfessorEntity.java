package com.segredo.pokemon_pokedex.entities;

import com.segredo.pokemon_pokedex.entities.base.BaseEntity;

import jakarta.persistence.Column;

public class ProfessorEntity extends BaseEntity {
  // ## Table Title.
  public static final String TABLE_NAME = "professor";

  @Column(name = "auth_id", nullable = true)
  private String authId;
  
}