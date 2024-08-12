package com.segredo.pokemon_pokedex.entities.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

public enum TypeEffectStatusEnum {
  NONE(0, "none"),
  EFFECTIVE(1, "effective"),
  SUPER_EFFECTIVE(2, "super_effective"),
  NON_EFFECTIVE(3, "non_effective"),
  IMMUNE(4, "immune");

  @Getter
  private int id;

  @Getter
  private String name;

  TypeEffectStatusEnum(int id, String name)
  {
    this.id = id;
    this.name = name;
  }

  /*
   * Variable used to store names of enum.
   */
  private static final Map<String, TypeEffectStatusEnum> FIND_BY_DB_NAME = new HashMap<>();
  static {
    for (TypeEffectStatusEnum status : EnumSet.allOf(TypeEffectStatusEnum.class)) {
      FIND_BY_DB_NAME.put(status.getName(), status);
    }
  }

  /**
   * Function used to identify a TypeEffectStatusEnum by it's name.
   * @param name
   * @return TypeEffectStatusEnum | null
   *
   */
  public static TypeEffectStatusEnum identifyStatusByName(String name) {
    return FIND_BY_DB_NAME.containsKey(name) ? FIND_BY_DB_NAME.get(name) : null;
  }

  /*
   * Variable used t ostore ids of enum.
   */
  private static final Map<Integer, TypeEffectStatusEnum> FIND_BY_DB_ID = new HashMap<>();
  static {
    for (TypeEffectStatusEnum status : EnumSet.allOf(TypeEffectStatusEnum.class)) {
      FIND_BY_DB_ID.put(status.getId(), status);
    }
  }

  /**
   * Function used to identify a TypeEffectStatusEnum by it's id.
   * @param id
   * @return TypeEffectStatusEnum | null
   */
  public static TypeEffectStatusEnum identifyStatusById(int id)
  {
    return FIND_BY_DB_ID.containsKey(id) ? FIND_BY_DB_ID.get(id) : null;
  }

}
