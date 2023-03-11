package com.example;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.ItemID;

import java.util.*;

@AllArgsConstructor
@Getter
public enum PetData {

    DAGANNOTH_SUPREME_JR("Dagannoth Supreme Jr.","Dagannoth Supreme Jr.",ItemID.PET_DAGANNOTH_SUPREME,Lists.newArrayList(9941,9943),2850,2849,2849,60,-1,-1,false,null),
    ABYSSAL_ORPHAN("Abyssal Orphan","Abyssal Orphan",ItemID.ABYSSAL_ORPHAN,Lists.newArrayList(29631),7125,7124,7124,-1,-1,-1,false,null),
    CHAOS_ELEMENTAL_JR("Chaos Elemental Jr.","Chaos Elemental Jr.",ItemID.PET_CHAOS_ELEMENTAL,Lists.newArrayList(28256),3144,3145,3145,-1,-1,-1,false,null),
    SNAKELING_BLUE("Snakeling Blue","Snakeling",ItemID.PET_SNAKELING_12940,Lists.newArrayList(10414),1721,2405,2405,-1,-1,-1,true,null),
    SNAKELING_RED("Snakeling Red","Snakeling",ItemID.PET_SNAKELING_12939,Lists.newArrayList(10416),1721,2405,2405,-1,-1,-1,true,null),
    SNAKELING_GREEN("Snakeling Green","Snakeling",ItemID.PET_SNAKELING,Lists.newArrayList(10413),1721,2405,2405,-1,-1,-1,true,null),
    KREEARRA_JR("Kree'arra Jr.","Kree'arra Jr.",ItemID.PET_KREEARRA,Lists.newArrayList(28019,28021,28020),7166,7167,7167,30,30,30,false,null),
    LITTLE_NIGHTMARE("Little Nightmare","Little Nightmare",ItemID.LITTLE_NIGHTMARE,Lists.newArrayList(39196),8593,8634,8634,30,-1,-1,true,null),
    GENERAL_GRAARDOR_JR("General Graardor Jr.","General Graardor Jr.",ItemID.PET_GENERAL_GRAARDOR,Lists.newArrayList(27660,27665),7017,7016,7016,30,30,30,false,"GRRRRRRRR"),
    JAL_NIB_REK("Jal-Nib-Rek","Jal-Nib-Rek",ItemID.JALNIBREK,Lists.newArrayList(33005),7573,7572,7572,-1,30,30,true,"GRRRRRRRR"),
    TZREK_ZUK("TzRek-Zuk","TzRek-Zuk",ItemID.TZREKZUK,Lists.newArrayList(34586),7975,7977,7977,18,30,30,true,"GRRRRRRRR"),


    ;

    final String identifier;
    final String name;
    final int iconID;
    final ArrayList<Integer> modelIDs;
    final int idleAnim;
    final int walkAnim;
    final int runAnim;
    final int scale;
    final int ambient;
    final int contrast;
    final boolean metamorph;
    final String examine;

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

        morphModel.put("TzRek-Zuk",JAL_NIB_REK);
        morphModel.put("Jal-Nib-Rek",TZREK_ZUK);

    }


}
