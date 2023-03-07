package com.example;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Map;

@AllArgsConstructor
@Getter
public enum PetData {

    DAGANNOTH_SUPREME_JR("Dagannoth Supreme Jr.",Lists.newArrayList(9941,9943),2850,2849,2849,60,-1,-1,false),
    ABYSSAL_ORPHAN("Abyssal Orphan",Lists.newArrayList(29631),7125,7124,7124,-1,-1,-1,false),
    CHAOS_ELEMENTAL_JR("Chaos Elemental Jr.",Lists.newArrayList(28256),3144,3145,3145,-1,-1,-1,false),
    SNAKELING("Snakeling",Lists.newArrayList(10414),1721,2405,2405,-1,-1,-1,true),
    ;

    final String name;
    final ArrayList<Integer> modelIDs;
    final int idleAnim;
    final int walkAnim;
    final int runAnim;
    final int scale;
    final int ambient;
    final int contrast;
    final boolean metamorph;

    static
    {
        ImmutableMap.Builder<String,PetData> builder = new ImmutableMap.Builder<>();

        for (PetData petData : values())
        {
            builder.put(petData.getName(), petData);
        }
        pets = builder.build();
    }

    public static final Map<String, PetData> pets;






}
