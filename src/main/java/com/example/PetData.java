package com.example;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;

@AllArgsConstructor
@Getter
public enum PetData {

    DAGANNOTH_SUPREME_JR("Dagannoth Supreme Jr.","Dagannoth Supreme Jr.",Lists.newArrayList(9941,9943),2850,2849,2849,60,-1,-1,false),
    ABYSSAL_ORPHAN("Abyssal Orphan","Abyssal Orphan",Lists.newArrayList(29631),7125,7124,7124,-1,-1,-1,false),
    CHAOS_ELEMENTAL_JR("Chaos Elemental Jr.","Chaos Elemental Jr.",Lists.newArrayList(28256),3144,3145,3145,-1,-1,-1,false),
    SNAKELING_BLUE("Snakeling Blue","Snakeling",Lists.newArrayList(10414),1721,2405,2405,-1,-1,-1,true),
    SNAKELING_RED("Snakeling Red","Snakeling",Lists.newArrayList(10416),1721,2405,2405,-1,-1,-1,true),
    SNAKELING_GREEN("Snakeling Green","Snakeling",Lists.newArrayList(10413),1721,2405,2405,-1,-1,-1,true),
    KREEARRA_JR("Kree'arra Jr.","Kree'arra Jr.",Lists.newArrayList(28019,28021,28020),7166,7167,7167,30,30,30,false),
    LITTLE_NIGHTMARE("Little Nightmare","Little Nightmare",Lists.newArrayList(39196),8593,8634,8634,30,-1,-1,true),


    ;

    final String identifier;
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
            builder.put(petData.getIdentifier(), petData);
        }
        pets = builder.build();
    }

    public static final Map<String, PetData> pets;

    public static final Map<String, PetData> morphModel = new HashMap<>();

    static
    {
        morphModel.put("Snakeling Red",SNAKELING_GREEN);
        morphModel.put("Snakeling Blue",SNAKELING_RED);
        morphModel.put("Snakeling Green",SNAKELING_BLUE);

    }


}
