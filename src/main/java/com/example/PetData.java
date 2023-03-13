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

    //Recolor ids first color to find, second half color to replace

    //dks
    DAGANNOTH_SUPREME_JR("Dagannoth Supreme Jr.","Dagannoth Supreme Jr.",ItemID.PET_DAGANNOTH_SUPREME,Lists.newArrayList(9941,9943),2850,2849,2849,60,-1,-1,null,false,null),
    DAGANNOTH_PRIME_JR("Dagannoth Prime Jr.","Dagannoth Prime Jr.",ItemID.PET_DAGANNOTH_PRIME,Lists.newArrayList(9940,9943,9942),2850,2849,2849,60,30,30,Lists.newArrayList((short)11930,(short)27144,(short)16536,(short)16540, (short)5931,(short)1688,(short)21530,(short)21534),false,null),
    DAGANNOTH_REX_JR("Dagannoth Rex Jr.","Dagannoth Rex Jr.",ItemID.PET_DAGANNOTH_REX,Lists.newArrayList(9941),2850,2849,2849,60,30,30,Lists.newArrayList((short)16536,(short)16540,(short)27144,(short)2477, (short)7322,(short)7326,(short)10403,(short)2595),false,null),


    ABYSSAL_ORPHAN("Abyssal Orphan","Abyssal Orphan",ItemID.ABYSSAL_ORPHAN,Lists.newArrayList(29631),7125,7124,7124,-1,-1,-1,null,false,null),
    CHAOS_ELEMENTAL_JR("Chaos Elemental Jr.","Chaos Elemental Jr.",ItemID.PET_CHAOS_ELEMENTAL,Lists.newArrayList(28256),3144,3145,3145,-1,-1,-1,null,false,null),

    //zulrah
    SNAKELING_BLUE("Snakeling Blue","Snakeling",ItemID.PET_SNAKELING_12940,Lists.newArrayList(10414),1721,2405,2405,-1,-1,-1,null,true,null),
    SNAKELING_RED("Snakeling Red","Snakeling",ItemID.PET_SNAKELING_12939,Lists.newArrayList(10416),1721,2405,2405,-1,-1,-1,null,true,null),
    SNAKELING_GREEN("Snakeling Green","Snakeling",ItemID.PET_SNAKELING,Lists.newArrayList(10413),1721,2405,2405,-1,-1,-1,null,true,null),

    KREEARRA_JR("Kree'arra Jr.","Kree'arra Jr.",ItemID.PET_KREEARRA,Lists.newArrayList(28019,28021,28020),7166,7167,7167,30,30,30,null,false,null),
    LITTLE_NIGHTMARE("Little Nightmare","Little Nightmare",ItemID.LITTLE_NIGHTMARE,Lists.newArrayList(39196),8593,8634,8634,30,-1,-1,null,true,null),
    GENERAL_GRAARDOR_JR("General Graardor Jr.","General Graardor Jr.",ItemID.PET_GENERAL_GRAARDOR,Lists.newArrayList(27660,27665),7017,7016,7016,30,30,30,null,false,"GRRRRRRRR"),

    //inferno
    JAL_NIB_REK("Jal-Nib-Rek","Jal-Nib-Rek",ItemID.JALNIBREK,Lists.newArrayList(33005),7573,7572,7572,-1,30,30,null,true,"GRRRRRRRR"),
    TZREK_ZUK("TzRek-Zuk","TzRek-Zuk",ItemID.TZREKZUK,Lists.newArrayList(34586),7975,7977,7977,18,30,30,null,true,"GRRRRRRRR"),

    //Rc
    RIFT_GUARDIAN("Rift guardian","Rift guardian",ItemID.RIFT_GUARDIAN,Lists.newArrayList(32204),7307,7306,7306,-1,-1,-1,null,true,"GRRRRRRRR"),
    RIFT_GUARDIAN_7338("Rift guardian 7338","Rift guardian",ItemID.RIFT_GUARDIAN_20667,Lists.newArrayList(32204),7307,7306,7306,-1,-1,-1,Lists.newArrayList((short)939,(short)960,(short)60595  ,(short)103,(short)127,(short)74),true,"GRRRRRRRR"),
    RIFT_GUARDIAN_7339("Rift guardian 7339","Rift guardian",ItemID.RIFT_GUARDIAN_20669,Lists.newArrayList(32204),7307,7306,7306,-1,-1,-1,Lists.newArrayList((short)939,(short)960,(short)60595  ,(short)0,(short)5056,(short)5551),true,"GRRRRRRRR"),
    RIFT_GUARDIAN_7340("Rift guardian 7340","Rift guardian",ItemID.RIFT_GUARDIAN_20671,Lists.newArrayList(32204),7307,7306,7306,-1,-1,-1,Lists.newArrayList((short)939,(short)960,(short)60595  ,(short)39849,(short)38866,(short)38086),true,"GRRRRRRRR"),
    RIFT_GUARDIAN_7341("Rift guardian 7341","Rift guardian",ItemID.RIFT_GUARDIAN_20673,Lists.newArrayList(32204),7307,7306,7306,-1,-1,-1,Lists.newArrayList((short)939,(short)960,(short)60595  ,(short)6036,(short)6942,(short)6319),true,"GRRRRRRRR"),
    RIFT_GUARDIAN_7342("Rift guardian 7342","Rift guardian",ItemID.RIFT_GUARDIAN_20675,Lists.newArrayList(32204),7307,7306,7306,-1,-1,-1,Lists.newArrayList((short)939,(short)960,(short)60595  ,(short)43961,(short)0,(short)43313),true,"GRRRRRRRR"),
    RIFT_GUARDIAN_7343("Rift guardian 7343","Rift guardian",ItemID.RIFT_GUARDIAN_20677,Lists.newArrayList(32204),7307,7306,7306,-1,-1,-1,Lists.newArrayList((short)939,(short)960,(short)60595  ,(short)10469,(short)11200,(short)10425),true,"GRRRRRRRR"),
    RIFT_GUARDIAN_7344("Rift guardian 7344","Rift guardian",ItemID.RIFT_GUARDIAN_20679,Lists.newArrayList(32204),7307,7306,7306,-1,-1,-1,Lists.newArrayList((short)939,(short)960,(short)60595  ,(short)7104,(short)127,(short)5551),true,"GRRRRRRRR"),
    RIFT_GUARDIAN_7345("Rift guardian 7345","Rift guardian",ItemID.RIFT_GUARDIAN_20681,Lists.newArrayList(32204),7307,7306,7306,-1,-1,-1,Lists.newArrayList((short)939,(short)960,(short)60595  ,(short)22430,(short)22461,(short)21698),true,"GRRRRRRRR"),
    RIFT_GUARDIAN_7346("Rift guardian 7346","Rift guardian",ItemID.RIFT_GUARDIAN_20683,Lists.newArrayList(32204),7307,7306,7306,-1,-1,-1,Lists.newArrayList((short)939,(short)960,(short)60595  ,(short)43945,(short)43968,(short)43313),true,"GRRRRRRRR"),
    RIFT_GUARDIAN_7347("Rift guardian 7347","Rift guardian",ItemID.RIFT_GUARDIAN_20685,Lists.newArrayList(32204),7307,7306,7306,-1,-1,-1,Lists.newArrayList((short)939,(short)960,(short)60595  ,(short)127,(short)0,(short)74),true,"GRRRRRRRR"),
    RIFT_GUARDIAN_7348("Rift guardian 7348","Rift guardian",ItemID.RIFT_GUARDIAN_20687,Lists.newArrayList(32204),7307,7306,7306,-1,-1,-1,Lists.newArrayList((short)939,(short)960,(short)60595  ,(short)43484,(short)46040,(short)45361),true,"GRRRRRRRR"),
    RIFT_GUARDIAN_7349("Rift guardian 7349","Rift guardian",ItemID.RIFT_GUARDIAN_20689,Lists.newArrayList(32204),7307,7306,7306,-1,-1,-1,Lists.newArrayList((short)939,(short)960,(short)60595  ,(short)54503,(short)54742,(short)54449),true,"GRRRRRRRR"),
    RIFT_GUARDIAN_7350("Rift guardian 7350","Rift guardian",ItemID.RIFT_GUARDIAN_20691,Lists.newArrayList(32204),7307,7306,7306,-1,-1,-1,Lists.newArrayList((short)939,(short)960,(short)60595  ,(short)920,(short)910,(short)57),true,"GRRRRRRRR"),
    RIFT_GUARDIAN_7351("Rift guardian 7351","Rift guardian",ItemID.RIFT_GUARDIAN_21990,Lists.newArrayList(32204),7307,7306,7306,-1,-1,-1,Lists.newArrayList((short)939,(short)960,(short)60595  ,(short)4,(short)962,(short)43059),true,"GRRRRRRRR"),
    GREATISH_GUARDIAN("Greatish guardian","Greatish guardian",ItemID.GREATISH_GUARDIAN,Lists.newArrayList(44061),9379,9378,9378,32,20,20,null,true,"GRRRRRRRR"),

    //farming
    TANGLEROOT("Tangleroot","Tangleroot",ItemID.TANGLEROOT,Lists.newArrayList(32202),7312,7313,7313,-1,-1,-1,null,true,"GRRRRRRRR"),
    TANGLEROOT_9492("Tangleroot 9492","Tangleroot",ItemID.TANGLEROOT_24555,Lists.newArrayList(39573),7312,7313,7313,-1,30,-1,null,true,"GRRRRRRRR"),
    TANGLEROOT_9493("Tangleroot 9493","Tangleroot",ItemID.TANGLEROOT_24557,Lists.newArrayList(39571),7312,7313,7313,-1,-1,-1,null,true,"GRRRRRRRR"),
    TANGLEROOT_9494("Tangleroot 9494","Tangleroot",ItemID.TANGLEROOT_24559,Lists.newArrayList(39572),7312,7313,7313,-1,-1,-1,null,true,"GRRRRRRRR"),
    TANGLEROOT_9495("Tangleroot 9495","Tangleroot",ItemID.TANGLEROOT_24561,Lists.newArrayList(39574),7312,7313,7313,-1,-1,-1,null,true,"GRRRRRRRR"),
    TANGLEROOT_9496("Tangleroot 9496","Tangleroot",ItemID.TANGLEROOT_24563,Lists.newArrayList(39575),7312,7313,7313,-1,-1,-1,null,true,"GRRRRRRRR"),

    //agility
    GIANT_SQUIRREL("Giant Squirrel","Giant Squirrel",ItemID.GIANT_SQUIRREL,Lists.newArrayList(32206),7309,7310,7310,110,-1,-1,null,true,"GRRRRRRRR"),
    DARK_SQUIRREL("Dark Squirrel","Dark Squirrel",ItemID.DARK_SQUIRREL,Lists.newArrayList(32206),7309,7310,7310,110,-1,-1,Lists.newArrayList((short)38160,(short)38156,(short)3633,(short)3290,(short)3623,(short)4430  ,(short)24,(short)12,(short)668,(short)24,(short)673,(short)12),true,"GRRRRRRRR"),













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
    final ArrayList<Short> recolorIDs;
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
        //zulrah
        morphModel.put("Snakeling Red",SNAKELING_GREEN);
        morphModel.put("Snakeling Blue",SNAKELING_RED);
        morphModel.put("Snakeling Green",SNAKELING_BLUE);

        //Inferno
        morphModel.put("TzRek-Zuk",JAL_NIB_REK);
        morphModel.put("Jal-Nib-Rek",TZREK_ZUK);

        //Rc
        morphModel.put("Rift guardian",RIFT_GUARDIAN_7338);
        morphModel.put("Rift guardian 7338",RIFT_GUARDIAN_7339);
        morphModel.put("Rift guardian 7339",RIFT_GUARDIAN_7340);
        morphModel.put("Rift guardian 7340",RIFT_GUARDIAN_7341);
        morphModel.put("Rift guardian 7341",RIFT_GUARDIAN_7342);
        morphModel.put("Rift guardian 7342",RIFT_GUARDIAN_7343);
        morphModel.put("Rift guardian 7343",RIFT_GUARDIAN_7344);
        morphModel.put("Rift guardian 7344",RIFT_GUARDIAN_7345);
        morphModel.put("Rift guardian 7345",RIFT_GUARDIAN_7346);
        morphModel.put("Rift guardian 7346",RIFT_GUARDIAN_7347);
        morphModel.put("Rift guardian 7347",RIFT_GUARDIAN_7348);
        morphModel.put("Rift guardian 7348",RIFT_GUARDIAN_7349);
        morphModel.put("Rift guardian 7349",RIFT_GUARDIAN_7350);
        morphModel.put("Rift guardian 7350",RIFT_GUARDIAN_7351);
        morphModel.put("Rift guardian 7351",GREATISH_GUARDIAN);
        morphModel.put("Greatish guardian",RIFT_GUARDIAN);

        //Farming
        morphModel.put("Tangleroot",TANGLEROOT_9492);
        morphModel.put("Tangleroot 9492",TANGLEROOT_9493);
        morphModel.put("Tangleroot 9493",TANGLEROOT_9494);
        morphModel.put("Tangleroot 9494",TANGLEROOT_9495);
        morphModel.put("Tangleroot 9495",TANGLEROOT_9496);
        morphModel.put("Tangleroot 9496",TANGLEROOT);

        morphModel.put("Giant Squirrel",DARK_SQUIRREL);
        morphModel.put("Giant Squirrel 9637",GIANT_SQUIRREL);
    }


}
