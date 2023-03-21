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

    //RAIDS
    //SLAYER
    //GWD
    //OTHER BOSS PETS
    //SKILLING PETS

    //Recolor ids first color to find, second half color to replace

    //COX----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    OLMLET("Olmlet","Olmlet",ItemID.OLMLET,Lists.newArrayList(32697),1,7396,7395,7395,64,-1,-1,null,true,"GRRRRRRRR"),
    PUPPADILE("Puppadile","Puppadile",ItemID.PUPPADILE,Lists.newArrayList(32681),1,7417,7982,7982,45,-1,-1,null,true,"GRRRRRRRR"),
    TEKTINY("Tektiny","Tektiny",ItemID.TEKTINY,Lists.newArrayList(32682),1,7476,7983,7983,25,10,5,null,true,"GRRRRRRRR"),
    ENRAGED_TEKTINY("Enraged Tektiny","Enraged Tektiny",ItemID.ENRAGED_TEKTINY,Lists.newArrayList(32682),1,7485,8637,8637,25,10,5,null,true,"GRRRRRRRR"),
    VANGUARD("Vanguard","Vanguard",ItemID.VANGUARD,Lists.newArrayList(32684),1,7430,7984,7984,40,-1,-1,null,true,"GRRRRRRRR"),
    VASA_MINIRIO("Vasa Minirio","Vasa Minirio",ItemID.VASA_MINIRIO,Lists.newArrayList(32680),1,7416,7985,7985,20,-1,-1,null,true,"GRRRRRRRR"),
    VESPINA("Vespina","Vespina",ItemID.VESPINA,Lists.newArrayList(32689),1,7449,7986,7986,20,-1,-1,null,true,"GRRRRRRRR"),
    FLYING_VESPINA("Flying Vespina","Flying Vespina",ItemID.FLYING_VESPINA,Lists.newArrayList(32689),1,8639,8639,8639,20,-1,-1,null,true,"GRRRRRRRR"),

    //TOB----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    LIL_ZIK("Lil' Zik","Lil' Zik",ItemID.LIL_ZIK,Lists.newArrayList(35381),1,8120,8122,8122,20,-1,-1,null,true,"GRRRRRRRR"),
    LIL_MAIDEN("Lil' Maiden","Lil' Maiden",ItemID.LIL_MAIDEN,Lists.newArrayList(42280),1,8090,8090,8090,30,-1,-1,null,true,"GRRRRRRRR"),
    LIL_BLOAT("Lil' Bloat","Lil' Bloat",ItemID.LIL_BLOAT,Lists.newArrayList(35404),1,8080,9031,9031,25,-1,-1,null,true,"GRRRRRRRR"),
    LIL_NYLO("Lil' Nylo","Lil' Nylo",ItemID.LIL_NYLO,Lists.newArrayList(35183),1,8002,8003,8003,35,-1,-1,null,true,"GRRRRRRRR"),
    LIL_SOT("Lil' Sot","Lil' Sot",ItemID.LIL_SOT,Lists.newArrayList(35403),1,8137,9032,9032,30,-1,-1,null,true,"GRRRRRRRR"),
    LIL_XARP("Lil' Xarp","Lil' Xarp",ItemID.LIL_XARP,Lists.newArrayList(35383),1,9033,9033,9033,20,-1,-1,null,true,"GRRRRRRRR"),

    //TOA----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    TUMEKENS_GUARDIAN("Tumeken's Guardian","Tumeken's Guardian",ItemID.TUMEKENS_GUARDIAN,Lists.newArrayList(46337),1,9655,9651,9651,65,-1,-1,null,true,"GRRRRRRRR"),
    TUMEKENS_DAMAGED_GUARDIAN("Tumeken's Damaged Guardian","Tumeken's Damaged Guardian",ItemID.TUMEKENS_DAMAGED_GUARDIAN,Lists.newArrayList(46333),1,9420,9420,9420,65,-1,-1,null,true,"GRRRRRRRR"),
    ELIDINIS_GUARDIAN("Elidinis' Guardian","Elidinis' Guardian",ItemID.ELIDINIS_GUARDIAN,Lists.newArrayList(46332),1,9656,9652,9652,65,-1,-1,null,true,"GRRRRRRRR"),
    ELIDINIS_DAMAGED_GUARDIAN("Elidinis' Damaged Guardian","Elidinis' Damaged Guardian",ItemID.ELIDINIS_DAMAGED_GUARDIAN,Lists.newArrayList(46332),1,9420,9420,9420,65,-1,-1,null,true,"GRRRRRRRR"),
    //check for 180 rotate for below
    AKKHITO("Akkhito","Akkhito",ItemID.AKKHITO,Lists.newArrayList(46360,46356,46357),1,9760,9421,9421,58,-1,-1,null,true,"GRRRRRRRR"),
    BABI("Babi","Babi",ItemID.BABI,Lists.newArrayList(46352,46350),1,9741,9739,9739,36,-1,-1,null,true,"GRRRRRRRR"),
    KEPHRITI("Kephriti","Kephriti",ItemID.KEPHRITI,Lists.newArrayList(46417),1,9572,9419,9419,38,-1,40,null,true,"GRRRRRRRR"),
    ZEBO("Zebo","Zebo",ItemID.ZEBO,Lists.newArrayList(46509),2,2037,2036,2036,112,-1,-1,null,true,"GRRRRRRRR"),


    //SLAYER----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    ABYSSAL_ORPHAN("Abyssal Orphan","Abyssal Orphan",ItemID.ABYSSAL_ORPHAN,Lists.newArrayList(29631),1,7125,7124,7124,-1,-1,-1,null,false,null),
    HELLPUPPY("Hellpuppy","Hellpuppy",ItemID.HELLPUPPY,Lists.newArrayList(29240),1,6561,6560,6560,-1,-1,-1,null,false,"GRRRRRRRR"),

    NOON("Noon","Noon",ItemID.NOON,Lists.newArrayList(34183),1,7768,7768,7768,34,-1,-1,null,true,"GRRRRRRRR"),
    MIDNIGHT("Midnight","Midnight",ItemID.MIDNIGHT,Lists.newArrayList(34187),1,7807,7806,7806,34,-1,-1,null,true,"GRRRRRRRR"),

    IKKLE_HYDRA("Ikkle Hydra","Ikkle Hydra",ItemID.IKKLE_HYDRA,Lists.newArrayList(36185),1,8233,8296,8296,20,-1,-1,null,true,"GRRRRRRRR"),
    IKKLE_HYDRA_22748("Ikkle Hydra 22748","Ikkle Hydra",ItemID.IKKLE_HYDRA_22748,Lists.newArrayList(36192),1,8298,8297,8297,20,-1,-1,null,true,"GRRRRRRRR"),
    IKKLE_HYDRA_22750("Ikkle Hydra 22750","Ikkle Hydra",ItemID.IKKLE_HYDRA_22750,Lists.newArrayList(36188),1,8247,8299,8299,20,-1,-1,null,true,"GRRRRRRRR"),
    IKKLE_HYDRA_22752("Ikkle Hydra 22752","Ikkle Hydra",ItemID.IKKLE_HYDRA_22752,Lists.newArrayList(36191),1,8254,8300,8300,20,-1,-1,null,true,"GRRRRRRRR"),

    PET_SMOKE_DEVIL("Pet Smoke Devil","Pet Smoke Devil",ItemID.PET_SMOKE_DEVIL,Lists.newArrayList(28442),1,1829,1828,1828,60,25,25,null,true,"GRRRRRRRR"),
    PET_SMOKE_DEVIL_6655("Pet Smoke Devil 6655","Pet Smoke Devil",ItemID.PET_SMOKE_DEVIL_22663,Lists.newArrayList(36012),1,1829,1828,1828,35,25,25,null,true,"GRRRRRRRR"),

    KRAKEN("Kraken","Kraken",ItemID.PET_KRAKEN,Lists.newArrayList(28231),1,3989,3989,3989,15,30,30,null,false,"GRRRRRRRR"),

    //GWD----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    GENERAL_GRAARDOR_JR("General Graardor Jr.","General Graardor Jr.",ItemID.PET_GENERAL_GRAARDOR,Lists.newArrayList(27660,27665),1,7017,7016,7016,30,30,30,null,false,"GRRRRRRRR"),
    KREEARRA_JR("Kree'arra Jr.","Kree'arra Jr.",ItemID.PET_KREEARRA,Lists.newArrayList(28019,28021,28020),1,7166,7167,7167,30,30,30,null,false,null),
    ZILYANA_JR("Zilyana Jr.","Zilyana Jr.",ItemID.PET_ZILYANA,Lists.newArrayList(27989,27937,27985,27968,27990),1,6966,6965,6965,60,30,30,null,false,"GRRRRRRRR"),
    KRIL_TSUTSAROTH_JR("K'ril Tsutsaroth Jr.","K'ril Tsutsaroth Jr.",ItemID.PET_KRIL_TSUTSAROTH,Lists.newArrayList(27683,27681,27692,27682,27690),1,6935,4070,4070,20,30,30,null,false,"GRRRRRRRR"),
    NEXLING("Nexling","Nexling",ItemID.NEXLING,Lists.newArrayList(43209),1,9177,9176,9176,48,-1,-1,null,false,"GRRRRRRRR"),


    //Other Boss pets----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //inferno
    JAL_NIB_REK("Jal-Nib-Rek","Jal-Nib-Rek",ItemID.JALNIBREK,Lists.newArrayList(33005),1,7573,7572,7572,-1,30,30,null,true,"GRRRRRRRR"),
    TZREK_ZUK("TzRek-Zuk","TzRek-Zuk",ItemID.TZREKZUK,Lists.newArrayList(34586),1,7975,7977,7977,18,30,30,null,true,"GRRRRRRRR"),

    //jad
    TZREK_JAD("TzRek-Jad","TzRek-Jad",ItemID.TZREKJAD,Lists.newArrayList(9319),1,2650,5805,5805,20,60,-1,null,true,"GRRRRRRRR"),
    JALREK_JAD("JalRek-Jad","JalRek-Jad",ItemID.JALREKJAD,Lists.newArrayList(33012),1,7589,8857,8857,20,-10,-1,null,true,"GRRRRRRRR"),

    //Guantlet
    YOUNGLLEF("Youngllef","Youngllef",ItemID.YOUNGLLEF,Lists.newArrayList(38596),1,8417,8428,8428,25,-1,-1,null,true,"GRRRRRRRR"),
    CORRUPTED_YOUNGLLEF("Corrupted Youngllef","Corrupted Youngllef",ItemID.CORRUPTED_YOUNGLLEF,Lists.newArrayList(38597),1,8417,8428,8428,25,-1,-1,null,true,"GRRRRRRRR"),

    //corp
    DARK_CORE("Dark core","Dark core",ItemID.PET_DARK_CORE,Lists.newArrayList(11069),1,7980,2417,2417,83,30,30,null,true,"GRRRRRRRR"),
    CORPOREAL_CRITTER("Corporeal Critter","Corporeal Critter",ItemID.PET_CORPOREAL_CRITTER,Lists.newArrayList(11056),1,1678,7974,7974,64,30,30,null,true,"GRRRRRRRR"),

    //zulrah
    SNAKELING_BLUE("Snakeling Blue","Snakeling",ItemID.PET_SNAKELING_12940,Lists.newArrayList(10414),1,1721,2405,2405,-1,-1,-1,null,true,null),
    SNAKELING_RED("Snakeling Red","Snakeling",ItemID.PET_SNAKELING_12939,Lists.newArrayList(10416),1,1721,2405,2405,-1,-1,-1,null,true,null),
    SNAKELING_GREEN("Snakeling Green","Snakeling",ItemID.PET_SNAKELING,Lists.newArrayList(10413),1,1721,2405,2405,-1,-1,-1,null,true,null),

    //nm
    LITTLE_NIGHTMARE("Little Nightmare","Little Nightmare",ItemID.LITTLE_NIGHTMARE,Lists.newArrayList(39196),1,8593,8634,8634,30,-1,-1,null,true,null),
    LITTLE_PARASITE("Little Parasite","Little Parasite",ItemID.LITTLE_PARASITE,Lists.newArrayList(39210),1,8553,8553,8553,40,-1,-1,null,true,"GRRRRRRRR"),

    //mole
    BABY_MOLE("Baby Mole","Baby Mole",ItemID.BABY_MOLE,Lists.newArrayList(42012),1,3309,3313,3313,90,30,30,null,true,"GRRRRRRRR"),
    BABY_MOLE_RAT("Baby Mole-rat","Baby Mole-rat",ItemID.BABY_MOLERAT,Lists.newArrayList(42012),1,3309,3313,3313,90,30,30,Lists.newArrayList((short)5388,(short)5392,(short)5268,(short)5272,(short)5276,(short)4558  ,(short)317,(short)322,(short)326,(short)328,(short)332,(short)63706),true,"GRRRRRRRR"),

    //kq
    KALPHITE_PRINCESS("Kalphite Princess","Kalphite Princess",ItemID.KALPHITE_PRINCESS,Lists.newArrayList(24597,24598),2,6239,6238,4635,45,30,30,null,true,"GRRRRRRRR"),
    KALPHITE_PRINCESS_6637("Kalphite Princess 6637","Kalphite Princess",ItemID.KALPHITE_PRINCESS_12654,Lists.newArrayList(24602,24605,24606),1,6236,6236,6236,45,30,30,null,true,"GRRRRRRRR"),

    //Muphin
    MUPHIN("Muphin","Muphin",ItemID.MUPHIN,Lists.newArrayList(47149),1,9913,9915,9915,25,-1,-1,null,true,"GRRRRRRRR"),
    MUPHIN_27592("Muphin 27592","Muphin",ItemID.MUPHIN_27592,Lists.newArrayList(47147),1,9913,9915,9915,25,-1,-1,null,true,"GRRRRRRRR"),
    MUPHIN_27593("Muphin 27593","Muphin",ItemID.MUPHIN_27593,Lists.newArrayList(47156),1,9913,9915,9915,25,-1,-1,null,true,"GRRRRRRRR"),


    //Sarachnis
    SRARACHA("Sraracha","Sraracha",ItemID.SRARACHA,Lists.newArrayList(37292),1,8320,8319,8319,48,30,30,null,true,"GRRRRRRRR"),
    SRARACHA_25842("Sraracha 25842","Sraracha",ItemID.SRARACHA_25842,Lists.newArrayList(37291),1,8320,8319,8319,48,30,30,Lists.newArrayList((short)229,(short)348,(short)412,(short)555,(short)670  ,(short)36069,(short)35041,(short)3505,(short)5945,(short)4007),true,"GRRRRRRRR"),
    SRARACHA_25843("Sraracha 25843","Sraracha",ItemID.SRARACHA_25843,Lists.newArrayList(37290),1,8320,8319,8319,48,30,30,Lists.newArrayList((short)229,(short)348,(short)412,(short)555,(short)670  ,(short)36069,(short)35041,(short)39219,(short)39611,(short)39719),true,"GRRRRRRRR"),

    SKOTOS("Skotos","Skotos",ItemID.SKOTOS,Lists.newArrayList(31653),1,6935,4070,4070,20,30,30,null,false,"GRRRRRRRR"),

    VORKI("Vorki","Vorki",ItemID.VORKI,Lists.newArrayList(35023),1,7948,7959,7959,16,-1,-1,null,false,"GRRRRRRRR"),

    //dks
    DAGANNOTH_SUPREME_JR("Dagannoth Supreme Jr.","Dagannoth Supreme Jr.",ItemID.PET_DAGANNOTH_SUPREME,Lists.newArrayList(9941,9943),1,2850,2849,2849,60,-1,-1,null,false,null),
    DAGANNOTH_PRIME_JR("Dagannoth Prime Jr.","Dagannoth Prime Jr.",ItemID.PET_DAGANNOTH_PRIME,Lists.newArrayList(9940,9943,9942),1,2850,2849,2849,60,30,30,Lists.newArrayList((short)11930,(short)27144,(short)16536,(short)16540, (short)5931,(short)1688,(short)21530,(short)21534),false,null),
    DAGANNOTH_REX_JR("Dagannoth Rex Jr.","Dagannoth Rex Jr.",ItemID.PET_DAGANNOTH_REX,Lists.newArrayList(9941),1,2850,2849,2849,60,30,30,Lists.newArrayList((short)16536,(short)16540,(short)27144,(short)2477, (short)7322,(short)7326,(short)10403,(short)2595),false,null),

    //WILDY-----------------------------------------------------------------------------------------------------------------------------------------------------------------

    PRINCE_BLACK_DRAGON("Prince Black Dragon","Prince Black Dragon",ItemID.PRINCE_BLACK_DRAGON,Lists.newArrayList(17414,17415,17429,17422,17423),1,90,4635,4635,40,30,30,null,false,"GRRRRRRRR"),
    CHAOS_ELEMENTAL_JR("Chaos Elemental Jr.","Chaos Elemental Jr.",ItemID.PET_CHAOS_ELEMENTAL,Lists.newArrayList(28256),1,3144,3145,3145,-1,-1,-1,null,false,null),

    //Venenatis
    VENENATIS_SPIDERLING("Venenatis spiderling","Venenatis spiderling",ItemID.VENENATIS_SPIDERLING,Lists.newArrayList(47393),1,9986,9987,9987,58,30,30,null,true,"GRRRRRRRR"),
    VENENATIS_SPIDERLING_27648("Venenatis spiderling 27648","Venenatis spiderling",ItemID.VENENATIS_SPIDERLING_27648,Lists.newArrayList(28294,28295),1,5326,5325,5325,60,30,30,null,true,"GRRRRRRRR"),

    //callisto
    CALLISTO_CUB("Callisto cub","Callisto cub",ItemID.CALLISTO_CUB,Lists.newArrayList(47396),1,10011,10010,10010,16,30,30,null,true,"GRRRRRRRR"),
    CALLISTO_CUB_27649("Callisto cub 27649","Callisto cub",ItemID.CALLISTO_CUB_27649,Lists.newArrayList(28298),1,4919,4923,4923,35,30,30,null,true,"GRRRRRRRR"),

    //vetion
    VETION_JR("Vet'ion Jr.","Vet'ion Jr.",ItemID.VETION_JR,Lists.newArrayList(47387,47384),1,9965,9967,9967,54,30,30,null,true,"GRRRRRRRR"),
    VETION_JR_13180("Vet'ion Jr. 13180","Vet'ion Jr.",ItemID.VETION_JR_13180,Lists.newArrayList(47383,47385,47388,47389),1,9965,9967,9967,54,30,30,Lists.newArrayList((short)55184,(short)54926,(short)54693,(short)55190,(short)54571,(short)54804  ,(short)4019,(short)4007,(short)4007,(short)3879,(short)4023,(short)2966),true,"GRRRRRRRR"),
    VETION_JR_27650("Vet'ion Jr. 27650","Vet'ion Jr.",ItemID.VETION_JR_27650,Lists.newArrayList(28299),1,5505,5497,5497,45,30,30,null,true,"GRRRRRRRR"),
    VETION_JR_27651("Vet'ion Jr. 27651","Vet'ion Jr.",ItemID.VETION_JR_27651,Lists.newArrayList(28299),1,5505,5497,5497,45,30,30,Lists.newArrayList((short)55184,(short)54926,(short)54693,(short)55190,(short)54571,(short)54804  ,(short)4019,(short)4007,(short)4007,(short)3879,(short)4023,(short)2966),true,"GRRRRRRRR"),

    SCORPIAS_OFFSPRING("Scorpia's offspring","Scorpia's offspring",ItemID.SCORPIAS_OFFSPRING,Lists.newArrayList(29193),2,6258,6257,6257,280,30,30,Lists.newArrayList((short)142,(short)4525,(short)4636,(short)4884,(short)4645  ,(short)28,(short)16,(short)16,(short)16,(short)16),false,"GRRRRRRRR"),

    //SKILLING-----------------------------------------------------------------------------------------------------------------------------------------------------------------

    //farming
    TANGLEROOT("Tangleroot","Tangleroot",ItemID.TANGLEROOT,Lists.newArrayList(32202),1,7312,7313,7313,-1,-1,-1,null,true,"GRRRRRRRR"),
    TANGLEROOT_9492("Tangleroot 9492","Tangleroot",ItemID.TANGLEROOT_24555,Lists.newArrayList(39573),1,7312,7313,7313,-1,30,-1,null,true,"GRRRRRRRR"),
    TANGLEROOT_9493("Tangleroot 9493","Tangleroot",ItemID.TANGLEROOT_24557,Lists.newArrayList(39571),1,7312,7313,7313,-1,-1,-1,null,true,"GRRRRRRRR"),
    TANGLEROOT_9494("Tangleroot 9494","Tangleroot",ItemID.TANGLEROOT_24559,Lists.newArrayList(39572),1,7312,7313,7313,-1,-1,-1,null,true,"GRRRRRRRR"),
    TANGLEROOT_9495("Tangleroot 9495","Tangleroot",ItemID.TANGLEROOT_24561,Lists.newArrayList(39574),1,7312,7313,7313,-1,-1,-1,null,true,"GRRRRRRRR"),
    TANGLEROOT_9496("Tangleroot 9496","Tangleroot",ItemID.TANGLEROOT_24563,Lists.newArrayList(39575),1,7312,7313,7313,-1,-1,-1,null,true,"GRRRRRRRR"),

    //agility
    GIANT_SQUIRREL("Giant Squirrel","Giant Squirrel",ItemID.GIANT_SQUIRREL,Lists.newArrayList(32206),1,7309,7310,7310,110,-1,-1,null,true,"GRRRRRRRR"),
    DARK_SQUIRREL("Dark Squirrel","Dark Squirrel",ItemID.DARK_SQUIRREL,Lists.newArrayList(32206),1,7309,7310,7310,110,-1,-1,Lists.newArrayList((short)38160,(short)38156,(short)3633,(short)3290,(short)3623,(short)4430  ,(short)24,(short)12,(short)668,(short)24,(short)673,(short)12),true,"GRRRRRRRR"),

    //Rc
    RIFT_GUARDIAN("Rift guardian","Rift guardian",ItemID.RIFT_GUARDIAN,Lists.newArrayList(32204),1,7307,7306,7306,-1,-1,-1,null,true,"GRRRRRRRR"),
    RIFT_GUARDIAN_7338("Rift guardian 7338","Rift guardian",ItemID.RIFT_GUARDIAN_20667,Lists.newArrayList(32204),1,7307,7306,7306,-1,-1,-1,Lists.newArrayList((short)939,(short)960,(short)60595  ,(short)103,(short)127,(short)74),true,"GRRRRRRRR"),
    RIFT_GUARDIAN_7339("Rift guardian 7339","Rift guardian",ItemID.RIFT_GUARDIAN_20669,Lists.newArrayList(32204),1,7307,7306,7306,-1,-1,-1,Lists.newArrayList((short)939,(short)960,(short)60595  ,(short)0,(short)5056,(short)5551),true,"GRRRRRRRR"),
    RIFT_GUARDIAN_7340("Rift guardian 7340","Rift guardian",ItemID.RIFT_GUARDIAN_20671,Lists.newArrayList(32204),1,7307,7306,7306,-1,-1,-1,Lists.newArrayList((short)939,(short)960,(short)60595  ,(short)39849,(short)38866,(short)38086),true,"GRRRRRRRR"),
    RIFT_GUARDIAN_7341("Rift guardian 7341","Rift guardian",ItemID.RIFT_GUARDIAN_20673,Lists.newArrayList(32204),1,7307,7306,7306,-1,-1,-1,Lists.newArrayList((short)939,(short)960,(short)60595  ,(short)6036,(short)6942,(short)6319),true,"GRRRRRRRR"),
    RIFT_GUARDIAN_7342("Rift guardian 7342","Rift guardian",ItemID.RIFT_GUARDIAN_20675,Lists.newArrayList(32204),1,7307,7306,7306,-1,-1,-1,Lists.newArrayList((short)939,(short)960,(short)60595  ,(short)43961,(short)0,(short)43313),true,"GRRRRRRRR"),
    RIFT_GUARDIAN_7343("Rift guardian 7343","Rift guardian",ItemID.RIFT_GUARDIAN_20677,Lists.newArrayList(32204),1,7307,7306,7306,-1,-1,-1,Lists.newArrayList((short)939,(short)960,(short)60595  ,(short)10469,(short)11200,(short)10425),true,"GRRRRRRRR"),
    RIFT_GUARDIAN_7344("Rift guardian 7344","Rift guardian",ItemID.RIFT_GUARDIAN_20679,Lists.newArrayList(32204),1,7307,7306,7306,-1,-1,-1,Lists.newArrayList((short)939,(short)960,(short)60595  ,(short)7104,(short)127,(short)5551),true,"GRRRRRRRR"),
    RIFT_GUARDIAN_7345("Rift guardian 7345","Rift guardian",ItemID.RIFT_GUARDIAN_20681,Lists.newArrayList(32204),1,7307,7306,7306,-1,-1,-1,Lists.newArrayList((short)939,(short)960,(short)60595  ,(short)22430,(short)22461,(short)21698),true,"GRRRRRRRR"),
    RIFT_GUARDIAN_7346("Rift guardian 7346","Rift guardian",ItemID.RIFT_GUARDIAN_20683,Lists.newArrayList(32204),1,7307,7306,7306,-1,-1,-1,Lists.newArrayList((short)939,(short)960,(short)60595  ,(short)43945,(short)43968,(short)43313),true,"GRRRRRRRR"),
    RIFT_GUARDIAN_7347("Rift guardian 7347","Rift guardian",ItemID.RIFT_GUARDIAN_20685,Lists.newArrayList(32204),1,7307,7306,7306,-1,-1,-1,Lists.newArrayList((short)939,(short)960,(short)60595  ,(short)127,(short)0,(short)74),true,"GRRRRRRRR"),
    RIFT_GUARDIAN_7348("Rift guardian 7348","Rift guardian",ItemID.RIFT_GUARDIAN_20687,Lists.newArrayList(32204),1,7307,7306,7306,-1,-1,-1,Lists.newArrayList((short)939,(short)960,(short)60595  ,(short)43484,(short)46040,(short)45361),true,"GRRRRRRRR"),
    RIFT_GUARDIAN_7349("Rift guardian 7349","Rift guardian",ItemID.RIFT_GUARDIAN_20689,Lists.newArrayList(32204),1,7307,7306,7306,-1,-1,-1,Lists.newArrayList((short)939,(short)960,(short)60595  ,(short)54503,(short)54742,(short)54449),true,"GRRRRRRRR"),
    RIFT_GUARDIAN_7350("Rift guardian 7350","Rift guardian",ItemID.RIFT_GUARDIAN_20691,Lists.newArrayList(32204),1,7307,7306,7306,-1,-1,-1,Lists.newArrayList((short)939,(short)960,(short)60595  ,(short)920,(short)910,(short)57),true,"GRRRRRRRR"),
    RIFT_GUARDIAN_7351("Rift guardian 7351","Rift guardian",ItemID.RIFT_GUARDIAN_21990,Lists.newArrayList(32204),1,7307,7306,7306,-1,-1,-1,Lists.newArrayList((short)939,(short)960,(short)60595  ,(short)4,(short)962,(short)43059),true,"GRRRRRRRR"),
    GREATISH_GUARDIAN("Greatish guardian","Greatish guardian",ItemID.GREATISH_GUARDIAN,Lists.newArrayList(44061),1,9379,9378,9378,32,20,20,null,true,"GRRRRRRRR"),

    //Mining
    ROCK_GOLEM("Rock Golem","Rock Golem",ItemID.ROCK_GOLEM,Lists.newArrayList(29755),1,7180,7181,7181,-1,-1,10,null,true,"GRRRRRRRR"),
    ROCK_GOLEM_21187("Rock Golem 21187","Rock Golem",ItemID.ROCK_GOLEM_21187,Lists.newArrayList(29755),1,7180,7181,7181,-1,-1,10,Lists.newArrayList((short)6823,(short)6697,(short)6819,(short)6814,(short)6682,(short)5656  ,(short)66,(short)61,(short)49,(short)53,(short)53,(short)49),true,"GRRRRRRRR"),
    ROCK_GOLEM_21188("Rock Golem 21188","Rock Golem",ItemID.ROCK_GOLEM_21188,Lists.newArrayList(29755),1,7180,7181,7181,-1,-1,10,Lists.newArrayList((short)6823,(short)6697,(short)6819,(short)6814,(short)6682,(short)5656  ,(short)4044,(short)3912,(short)3906,(short)3901,(short)3897,(short)4021),true,"GRRRRRRRR"),
    ROCK_GOLEM_21189("Rock Golem 21189","Rock Golem",ItemID.ROCK_GOLEM_21189,Lists.newArrayList(29755),1,7180,7181,7181,-1,-1,10,Lists.newArrayList((short)6823,(short)6697,(short)6819,(short)6814,(short)6682,(short)5656  ,(short)2337,(short)2332,(short)2328,(short)2452,(short)3346,(short)3470),true,"GRRRRRRRR"),
    ROCK_GOLEM_21190("Rock Golem 21190","Rock Golem",ItemID.ROCK_GOLEM_21190,Lists.newArrayList(29755),1,7180,7181,7181,-1,-1,10,Lists.newArrayList((short)6823,(short)6697,(short)6819,(short)6814,(short)6682,(short)5656  ,(short)43235,(short)43233,(short)43486,(short)43482,(short)43862,(short)43730),true,"GRRRRRRRR"),
    ROCK_GOLEM_21191("Rock Golem 21191","Rock Golem",ItemID.ROCK_GOLEM_21191,Lists.newArrayList(29755),1,7180,7181,7181,-1,-1,10,Lists.newArrayList((short)6823,(short)6697,(short)6819,(short)6814,(short)6682,(short)5656  ,(short)43105,(short)43100,(short)43096,(short)43092,(short)43088,(short)43084),true,"GRRRRRRRR"),
    ROCK_GOLEM_21192("Rock Golem 21192","Rock Golem",ItemID.ROCK_GOLEM_21192,Lists.newArrayList(29755),1,7180,7181,7181,-1,-1,10,Lists.newArrayList((short)6823,(short)6697,(short)6819,(short)6814,(short)6682,(short)5656  ,(short)10388,(short)10512,(short)10508,(short)10378,(short)8,(short)4),true,"GRRRRRRRR"),
    ROCK_GOLEM_21193("Rock Golem 21193","Rock Golem",ItemID.ROCK_GOLEM_21193,Lists.newArrayList(29755),1,7180,7181,7181,-1,-1,10,Lists.newArrayList((short)6823,(short)6697,(short)6819,(short)6814,(short)6682,(short)5656  ,(short)8134,(short)8128,(short)7104,(short)7101,(short)7099,(short)7097),true,"GRRRRRRRR"),
    ROCK_GOLEM_21194("Rock Golem 21194","Rock Golem",ItemID.ROCK_GOLEM_21194,Lists.newArrayList(29755),1,7180,7181,7181,-1,-1,10,Lists.newArrayList((short)6823,(short)6697,(short)6819,(short)6814,(short)6682,(short)5656  ,(short)43181,(short)43177,(short)43173,(short)43297,(short)43292,(short)43288),true,"GRRRRRRRR"),
    ROCK_GOLEM_21195("Rock Golem 21195","Rock Golem",ItemID.ROCK_GOLEM_21195,Lists.newArrayList(29755),1,7180,7181,7181,-1,-1,10,Lists.newArrayList((short)6823,(short)6697,(short)6819,(short)6814,(short)6682,(short)5656  ,(short)4550,(short)4548,(short)4544,(short)4539,(short)4535,(short)2487),true,"GRRRRRRRR"),
    ROCK_GOLEM_21196("Rock Golem 21196","Rock Golem",ItemID.ROCK_GOLEM_21196,Lists.newArrayList(29755),1,7180,7181,7181,-1,-1,10,Lists.newArrayList((short)6823,(short)6697,(short)6819,(short)6814,(short)6682,(short)5656  ,(short)21675,(short)21671,(short)21667,(short)21662,(short)21658,(short)21782),true,"GRRRRRRRR"),
    ROCK_GOLEM_21197("Rock Golem 21197","Rock Golem",ItemID.ROCK_GOLEM_21197,Lists.newArrayList(29755),1,7180,7181,7181,-1,-1,10,Lists.newArrayList((short)6823,(short)6697,(short)6819,(short)6814,(short)6682,(short)5656  ,(short)36145,(short)36141,(short)36137,(short)36133,(short)36257,(short)36252),true,"GRRRRRRRR"),
    ROCK_GOLEM_21198("Rock Golem 21198","Rock Golem",ItemID.ROCK_GOLEM_21340,Lists.newArrayList(29755),1,7180,7181,7181,-1,-1,10,Lists.newArrayList((short)6823,(short)6697,(short)6819,(short)6814,(short)6682,(short)5656  ,(short)63830,(short)62800,(short)63692,(short)60624,(short)63675,(short)63663),true,"GRRRRRRRR"),
    ROCK_GOLEM_21199("Rock Golem 21199","Rock Golem",ItemID.ROCK_GOLEM_21358,Lists.newArrayList(29755),1,7180,7181,7181,-1,-1,10,Lists.newArrayList((short)6823,(short)6697,(short)6819,(short)6814,(short)6682,(short)5656  ,(short)805,(short)929,(short)798,(short)796,(short)790,(short)912),true,"GRRRRRRRR"),
    ROCK_GOLEM_21200("Rock Golem 21200","Rock Golem",ItemID.ROCK_GOLEM_21359,Lists.newArrayList(29755),1,7180,7181,7181,-1,-1,10,Lists.newArrayList((short)6823,(short)6697,(short)6819,(short)6814,(short)6682,(short)5656  ,(short)50999,(short)50995,(short)50993,(short)49967,(short)50087,(short)51098),true,"GRRRRRRRR"),
    ROCK_GOLEM_21201("Rock Golem 21201","Rock Golem",ItemID.ROCK_GOLEM_21360,Lists.newArrayList(29755),1,7180,7181,7181,-1,-1,10,Lists.newArrayList((short)6823,(short)6697,(short)6819,(short)6814,(short)6682,(short)5656  ,(short)31531,(short)31655,(short)31651,(short)31518,(short)31640,(short)30612),true,"GRRRRRRRR"),

    //fishing
    HERON("Heron","Heron",ItemID.HERON,Lists.newArrayList(29756),1,6772,6774,6774,-1,-1,-1,null,true,"GRRRRRRRR"),
    GREAT_BLUE_HERON("Great blue heron","Great blue heron",ItemID.GREAT_BLUE_HERON,Lists.newArrayList(41628),1,6772,6774,6774,-1,-1,-1,null,true,"GRRRRRRRR"),

    BEAVER("Beaver","Beaver",ItemID.BEAVER,Lists.newArrayList(29754),1,7177,7178,7178,-1,-1,-1,null,false,"GRRRRRRRR"),

    //chin
    BABY_CHINCHOMPA("Baby Chinchompa","Baby Chinchompa",ItemID.BABY_CHINCHOMPA,Lists.newArrayList(19371),1,5182,5181,5181,-1,-1,-1,null,true,"GRRRRRRRR"),
    BABY_CHINCHOMPA_13324("Baby Chinchompa 13324","Baby Chinchompa",ItemID.BABY_CHINCHOMPA_13324,Lists.newArrayList(19371),1,5182,5181,5181,-1,-1,-1,Lists.newArrayList((short)5169,(short)7343,(short)7335,(short)7339,(short)7343,(short)5165  ,(short)3988,(short)3988,(short)3982,(short)3986,(short)5014,(short)3988),true,"GRRRRRRRR"),
    BABY_CHINCHOMPA_13325("Baby Chinchompa 13325","Baby Chinchompa",ItemID.BABY_CHINCHOMPA_13325,Lists.newArrayList(19371),1,5182,5181,5181,-1,-1,-1,Lists.newArrayList((short)5169,(short)7343,(short)7335,(short)7339,(short)7343,(short)5165  ,(short)20,(short)33,(short)12,(short)37,(short)45,(short)49),true,"GRRRRRRRR"),
    BABY_CHINCHOMPA_13326("Baby Chinchompa 13326","Baby Chinchompa",ItemID.BABY_CHINCHOMPA_13326,Lists.newArrayList(29757),1,5182,5181,5181,-1,-1,-1,null,true,"GRRRRRRRR"),

    //theiving
    ROCKY("Rocky","Rocky",ItemID.ROCKY,Lists.newArrayList(32203),1,7315,7316,7316,110,-1,-1,null,true,"GRRRRRRRR"),
    RED("Red","Red",ItemID.RED,Lists.newArrayList(37361),1,7315,7316,7316,110,-1,-1,null,true,"GRRRRRRRR"),
    ZIGGY("Ziggy","Ziggy",ItemID.ZIGGY,Lists.newArrayList(14390),1,7315,7316,7316,110,-1,-1,null,true,"GRRRRRRRR"),

    //WT
    PHOENIX("Phoenix","Phoenix",ItemID.PHOENIX,Lists.newArrayList(26852),1,6809,6808,6808,80,40,-1,null,true,"GRRRRRRRR"),
    PHOENIX_24483("Phoenix 24483","Phoenix",ItemID.PHOENIX_24483,Lists.newArrayList(39148),1,6809,6808,6808,80,40,-1,null,true,"GRRRRRRRR"),
    PHOENIX_24484("Phoenix 24484","Phoenix",ItemID.PHOENIX_24484,Lists.newArrayList(39146),1,6809,6808,6808,80,40,-1,Lists.newArrayList((short)4894,(short)4647,(short)5669,(short)6053,(short)5066,(short)5053  ,(short)43943,(short)41907,(short)39855,(short)38715,(short)39855,(short)38860),true,"GRRRRRRRR"),
    PHOENIX_24485("Phoenix 24485","Phoenix",ItemID.PHOENIX_24485,Lists.newArrayList(39149),1,6809,6808,6808,80,40,-1,Lists.newArrayList((short)4894,(short)4647,(short)5669,(short)6053,(short)5066,(short)5053  ,(short)20,(short)33,(short)49,(short)20,(short)74,(short)86),true,"GRRRRRRRR"),
    PHOENIX_24486("Phoenix 24486","Phoenix",ItemID.PHOENIX_24486,Lists.newArrayList(39147),1,6809,6808,6808,80,40,-1,Lists.newArrayList((short)4894,(short)4647,(short)5669,(short)6053,(short)5066,(short)5053  ,(short)48819,(short)48844,(short)48844,(short)50006,(short)48844,(short)50904),true,"GRRRRRRRR"),

    HERBI("Herbi","Herbi",ItemID.HERBI,Lists.newArrayList(33890),1,7694,7695,7695,110,-1,-1,Lists.newArrayList((short)19992,(short)20364,(short)19988,(short)20422  ,(short)6049,(short)6040,(short)4781,(short)4038),false,"GRRRRRRRR"),

    SMOLCANO("Smolcano","Smolcano",ItemID.SMOLCANO,Lists.newArrayList(38592),1,8429,8447,8447,30,-1,-1,null,false,"GRRRRRRRR"),

    TINY_TEMPOR("Tiny Tempor","Tiny Tempor",ItemID.TINY_TEMPOR,Lists.newArrayList(41812),1,8895,8895,8895,24,-1,-1,null,false,"GRRRRRRRR"),

    ABYSSAL_PROTECTOR("Abyssal protector","Abyssal protector",ItemID.ABYSSAL_PROTECTOR,Lists.newArrayList(44070),1,2185,2184,2184,80,-1,-1,null,false,"GRRRRRRRR"),

    //MISC-----------------------------------------------------------------------------------------------------------------------------------------------------------------
    PENANCE_PET("Penance Pet","Penance Pet",ItemID.PET_PENANCE_QUEEN,Lists.newArrayList(20717,20715,20714,20709,20713,20712,20711,20710,20716),1,5410,5409,5409,29,30,30,null,false,"GRRRRRRRR"),

    BLOODHOUND("Bloodhound","Bloodhound",ItemID.BLOODHOUND,Lists.newArrayList(31740),1,7269,7280,7280,-1,-1,-1,null,false,"GRRRRRRRR"),

    CHOMPY_CHICK("Chompy chick","Chompy chick",ItemID.CHOMPY_CHICK,Lists.newArrayList(26861),1,6764,6765,6765,83,30,30,null,false,"GRRRRRRRR"),

    LIL_CREATOR("Lil' Creator","Lil' Creator",ItemID.LIL_CREATOR,Lists.newArrayList(41240),1,8842,8846,8846,24,-1,-1,null,true,"GRRRRRRRR"),
    LIL_DESTRUCTOR("Lil' Destructor","Lil' Destructor",ItemID.LIL_DESTRUCTOR,Lists.newArrayList(41242),1,3079,8847,8847,24,-1,-1,null,true,"GRRRRRRRR"),


    ;

    final String identifier;
    final String name;
    final int iconID;
    final ArrayList<Integer> modelIDs;
    final int size;
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

    public static final Map<PetData, PetData> morphModel = new HashMap<>();

    //RAIDS
    //SLAYER
    //GWD
    //OTHER BOSS PETS
    //SKILLING PETS
    //MISC

    public static final List<PetData> petsToShow = Arrays.asList(

            //RAIDS----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            OLMLET,
            LIL_ZIK,
            TUMEKENS_GUARDIAN,

            //SLAYER----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            ABYSSAL_ORPHAN,
            HELLPUPPY,
            NOON,
            IKKLE_HYDRA,
            PET_SMOKE_DEVIL_6655,
            KRAKEN,

            //GWD----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            GENERAL_GRAARDOR_JR,
            KREEARRA_JR,
            ZILYANA_JR,
            KRIL_TSUTSAROTH_JR,
            NEXLING,

            //Other Boss pets----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

            JAL_NIB_REK,
            TZREK_JAD,
            YOUNGLLEF,
            CORPOREAL_CRITTER,
            SNAKELING_GREEN,
            LITTLE_NIGHTMARE,
            BABY_MOLE,
            KALPHITE_PRINCESS,
            MUPHIN,
            SRARACHA,
            SKOTOS,
            VORKI,
            DAGANNOTH_SUPREME_JR,
            DAGANNOTH_PRIME_JR,
            DAGANNOTH_REX_JR,

            //WILDY-----------------------------------------------------------------------------------------------------------------------------------------------------------------

            PRINCE_BLACK_DRAGON,
            CHAOS_ELEMENTAL_JR,
            VENENATIS_SPIDERLING,
            CALLISTO_CUB,
            VETION_JR,
            VETION_JR_27650,
            SCORPIAS_OFFSPRING,

            //SKILLING-----------------------------------------------------------------------------------------------------------------------------------------------------------------

            TANGLEROOT,
            GIANT_SQUIRREL,
            RIFT_GUARDIAN,
            GREATISH_GUARDIAN,
            ROCK_GOLEM,
            HERON,
            BEAVER,
            BABY_CHINCHOMPA,
            ROCKY,
            PHOENIX,
            HERBI,
            SMOLCANO,
            TINY_TEMPOR,
            ABYSSAL_PROTECTOR,

            //MISC-----------------------------------------------------------------------------------------------------------------------------------------------------------------
            PENANCE_PET,
            BLOODHOUND,
            CHOMPY_CHICK,
            LIL_CREATOR

            );



    static
    {
        //zulrah
        morphModel.put(SNAKELING_RED,SNAKELING_GREEN);
        morphModel.put(SNAKELING_BLUE,SNAKELING_RED);
        morphModel.put(SNAKELING_GREEN,SNAKELING_BLUE);

        //Inferno
        morphModel.put(TZREK_ZUK,JAL_NIB_REK);
        morphModel.put(JAL_NIB_REK,TZREK_ZUK);

        //Rc
        morphModel.put(RIFT_GUARDIAN,RIFT_GUARDIAN_7338);
        morphModel.put(RIFT_GUARDIAN_7338,RIFT_GUARDIAN_7339);
        morphModel.put(RIFT_GUARDIAN_7339,RIFT_GUARDIAN_7340);
        morphModel.put(RIFT_GUARDIAN_7340,RIFT_GUARDIAN_7341);
        morphModel.put(RIFT_GUARDIAN_7341,RIFT_GUARDIAN_7342);
        morphModel.put(RIFT_GUARDIAN_7342,RIFT_GUARDIAN_7343);
        morphModel.put(RIFT_GUARDIAN_7343,RIFT_GUARDIAN_7344);
        morphModel.put(RIFT_GUARDIAN_7344,RIFT_GUARDIAN_7345);
        morphModel.put(RIFT_GUARDIAN_7345,RIFT_GUARDIAN_7346);
        morphModel.put(RIFT_GUARDIAN_7346,RIFT_GUARDIAN_7347);
        morphModel.put(RIFT_GUARDIAN_7347,RIFT_GUARDIAN_7348);
        morphModel.put(RIFT_GUARDIAN_7348,RIFT_GUARDIAN_7349);
        morphModel.put(RIFT_GUARDIAN_7349,RIFT_GUARDIAN_7350);
        morphModel.put(RIFT_GUARDIAN_7350,RIFT_GUARDIAN_7351);
        morphModel.put(RIFT_GUARDIAN_7351,GREATISH_GUARDIAN);
        morphModel.put(GREATISH_GUARDIAN,RIFT_GUARDIAN);

        //Farming
        morphModel.put(TANGLEROOT,TANGLEROOT_9492);
        morphModel.put(TANGLEROOT_9492,TANGLEROOT_9493);
        morphModel.put(TANGLEROOT_9493,TANGLEROOT_9494);
        morphModel.put(TANGLEROOT_9494,TANGLEROOT_9495);
        morphModel.put(TANGLEROOT_9495,TANGLEROOT_9496);
        morphModel.put(TANGLEROOT_9496,TANGLEROOT);

        //Agility
        morphModel.put(GIANT_SQUIRREL,DARK_SQUIRREL);
        morphModel.put(DARK_SQUIRREL,GIANT_SQUIRREL);

        //Mining
        morphModel.put(ROCK_GOLEM,ROCK_GOLEM_21187);
        morphModel.put(ROCK_GOLEM_21187,ROCK_GOLEM_21188);
        morphModel.put(ROCK_GOLEM_21188,ROCK_GOLEM_21189);
        morphModel.put(ROCK_GOLEM_21189,ROCK_GOLEM_21190);
        morphModel.put(ROCK_GOLEM_21190,ROCK_GOLEM_21191);
        morphModel.put(ROCK_GOLEM_21191,ROCK_GOLEM_21192);
        morphModel.put(ROCK_GOLEM_21192,ROCK_GOLEM_21193);
        morphModel.put(ROCK_GOLEM_21193,ROCK_GOLEM_21194);
        morphModel.put(ROCK_GOLEM_21194,ROCK_GOLEM_21195);
        morphModel.put(ROCK_GOLEM_21195,ROCK_GOLEM_21196);
        morphModel.put(ROCK_GOLEM_21196,ROCK_GOLEM_21197);
        morphModel.put(ROCK_GOLEM_21197,ROCK_GOLEM_21198);
        morphModel.put(ROCK_GOLEM_21198,ROCK_GOLEM_21199);
        morphModel.put(ROCK_GOLEM_21199,ROCK_GOLEM_21200);
        morphModel.put(ROCK_GOLEM_21200,ROCK_GOLEM_21201);
        morphModel.put(ROCK_GOLEM_21201,ROCK_GOLEM);

        //mole
        morphModel.put(BABY_MOLE,BABY_MOLE_RAT);
        morphModel.put(BABY_MOLE_RAT,BABY_MOLE_RAT);

        //muphin
        morphModel.put(MUPHIN,MUPHIN_27592);
        morphModel.put(MUPHIN_27592,MUPHIN_27593);
        morphModel.put(MUPHIN_27593,MUPHIN);

        //TOA
        morphModel.put(TUMEKENS_GUARDIAN,TUMEKENS_DAMAGED_GUARDIAN);
        morphModel.put(TUMEKENS_DAMAGED_GUARDIAN,ELIDINIS_GUARDIAN);
        morphModel.put(ELIDINIS_GUARDIAN,ELIDINIS_DAMAGED_GUARDIAN);
        morphModel.put(ELIDINIS_DAMAGED_GUARDIAN,AKKHITO);
        morphModel.put(AKKHITO,BABI);
        morphModel.put(BABI,KEPHRITI);
        morphModel.put(KEPHRITI,ZEBO);
        morphModel.put(ZEBO,TUMEKENS_GUARDIAN);

        //Soul Wars
        morphModel.put(LIL_CREATOR,LIL_DESTRUCTOR);
        morphModel.put(LIL_DESTRUCTOR,LIL_CREATOR);

        //Gauntlet
        morphModel.put(YOUNGLLEF,CORRUPTED_YOUNGLLEF);
        morphModel.put(CORRUPTED_YOUNGLLEF,YOUNGLLEF);

        //Sarachnis
        morphModel.put(SRARACHA,SRARACHA_25842);
        morphModel.put(SRARACHA_25842,SRARACHA_25843);
        morphModel.put(SRARACHA_25843,SRARACHA);

        //Hydra
        morphModel.put(IKKLE_HYDRA,IKKLE_HYDRA_22748);
        morphModel.put(IKKLE_HYDRA_22748,IKKLE_HYDRA_22750);
        morphModel.put(IKKLE_HYDRA_22750,IKKLE_HYDRA_22752);
        morphModel.put(IKKLE_HYDRA_22752,IKKLE_HYDRA);

        //tob
        morphModel.put(LIL_ZIK,LIL_MAIDEN);
        morphModel.put(LIL_MAIDEN,LIL_BLOAT);
        morphModel.put(LIL_BLOAT,LIL_NYLO);
        morphModel.put(LIL_NYLO,LIL_SOT);
        morphModel.put(LIL_SOT,LIL_XARP);
        morphModel.put(LIL_XARP,LIL_ZIK);

        //nm
        morphModel.put(LITTLE_NIGHTMARE,LITTLE_PARASITE);
        morphModel.put(LITTLE_PARASITE,LITTLE_NIGHTMARE);

        //GG's
        morphModel.put(NOON,MIDNIGHT);
        morphModel.put(MIDNIGHT,NOON);

        //cox
        morphModel.put(OLMLET,PUPPADILE);
        morphModel.put(PUPPADILE,TEKTINY);
        morphModel.put(TEKTINY,ENRAGED_TEKTINY);
        morphModel.put(ENRAGED_TEKTINY,VANGUARD);
        morphModel.put(VANGUARD,VASA_MINIRIO);
        morphModel.put(VASA_MINIRIO,VESPINA);
        morphModel.put(VESPINA,FLYING_VESPINA);
        morphModel.put(FLYING_VESPINA,OLMLET);

        //Phoenix
        morphModel.put(PHOENIX,PHOENIX_24483);
        morphModel.put(PHOENIX_24483,PHOENIX_24484);
        morphModel.put(PHOENIX_24484,PHOENIX_24485);
        morphModel.put(PHOENIX_24485,PHOENIX_24486);
        morphModel.put(PHOENIX_24486,PHOENIX);

        //rocky
        morphModel.put(ROCKY,RED);
        morphModel.put(RED,ZIGGY);
        morphModel.put(ZIGGY,ROCKY);

        //Chin pet
        morphModel.put(BABY_CHINCHOMPA,BABY_CHINCHOMPA_13324);
        morphModel.put(BABY_CHINCHOMPA_13324,BABY_CHINCHOMPA_13325);
        morphModel.put(BABY_CHINCHOMPA_13325,BABY_CHINCHOMPA_13326);
        morphModel.put(BABY_CHINCHOMPA_13326,BABY_CHINCHOMPA);

        //Fishing pet
        morphModel.put(HERON,GREAT_BLUE_HERON);
        morphModel.put(GREAT_BLUE_HERON,HERON);

        //vetion
        morphModel.put(VETION_JR,VETION_JR_13180);
        morphModel.put(VETION_JR_13180,VETION_JR_27650);
        morphModel.put(VETION_JR_27650,VETION_JR_27651);
        morphModel.put(VETION_JR_27651,VETION_JR);

        //callisto
        morphModel.put(CALLISTO_CUB,CALLISTO_CUB_27649);
        morphModel.put(CALLISTO_CUB_27649,CALLISTO_CUB);

        //venenatis
        morphModel.put(VENENATIS_SPIDERLING,VENENATIS_SPIDERLING_27648);
        morphModel.put(VENENATIS_SPIDERLING_27648,VENENATIS_SPIDERLING);

        //kq
        morphModel.put(KALPHITE_PRINCESS,KALPHITE_PRINCESS_6637);
        morphModel.put(KALPHITE_PRINCESS_6637,KALPHITE_PRINCESS);

        //thermy
        morphModel.put(PET_SMOKE_DEVIL,PET_SMOKE_DEVIL_6655);
        morphModel.put(PET_SMOKE_DEVIL_6655,PET_SMOKE_DEVIL);

        //corp
        morphModel.put(DARK_CORE,CORPOREAL_CRITTER);
        morphModel.put(CORPOREAL_CRITTER,DARK_CORE);


    }


}
