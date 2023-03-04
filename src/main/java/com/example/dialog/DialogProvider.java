package com.example.dialog;

import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.NpcID;

public class DialogProvider
{

	private static final int PLAYER_TALK_1 = 567;

	private static final String ABYSSAL_ORPHAN_TITLE = "Abyssal Orphan";
	private static final int ABYSSAL_ORPHAN_ANIMATION = -1; // todo, don't have this pet
	
	private static final String LIL_ZIK_TITLE = "Lil' Zik";
	private static final int LIL_ZIK_ANIMATION = 610;

	@Inject
	private Client client;

	// todo confirm line break placements
	public final DialogNode ABYSSAL_ORPHAN =
		DialogNode.builder()
			.npc(NpcID.ABYSSAL_ORPHAN_5884)
			.title(ABYSSAL_ORPHAN_TITLE)
			.animationId(ABYSSAL_ORPHAN_ANIMATION)
			.body("You killed my father.")
			.onContinue(() ->
			{
				// todo is this a dialogue option or randomly chosen?
				if (Math.random() < 0.5)
				{
					return DialogNode.builder()
						.player()
						.animationId(PLAYER_TALK_1) // todo confirm
						.body("Yeah, don't take it personally.")
						.next(DialogNode.builder()
							.npc(NpcID.ABYSSAL_ORPHAN_5884)
							.title(ABYSSAL_ORPHAN_TITLE)
							.animationId(ABYSSAL_ORPHAN_ANIMATION)
							.body("In his dying moment, my father poured<br>" +
								  "his last ounce of strength into my creation.<br>" +
								  "My being is formed from his remains.")
							.next(DialogNode.builder()
								.npc(NpcID.ABYSSAL_ORPHAN_5884)
								.title(ABYSSAL_ORPHAN_TITLE)
								.animationId(ABYSSAL_ORPHAN_ANIMATION)
								.body("When your own body is consumed to<br>" +
									  "nourish the Nexus, and an army of<br>" +
									  "scions arises from your corpse, I<br>" +
									  "trust you will not take it personally either.")
								.build())
							.build())
						.build();
				}
				else
				{
					return DialogNode.builder()
						.player()
						.animationId(PLAYER_TALK_1) // todo confirm
						.body("No, I am your father.")
						.onContinue(() ->
						{
							if (client.getLocalPlayer().getPlayerComposition().getGender() == 1)
							{
								return DialogNode.builder()
									.npc(NpcID.ABYSSAL_ORPHAN_5884)
									.title(ABYSSAL_ORPHAN_TITLE)
									.animationId(ABYSSAL_ORPHAN_ANIMATION)
									.body("Human biology may be unfamiliar to me,<br>" +
										  "but nevertheless I doubt that very much.")
									.build();
							}
							else
							{
								return DialogNode.builder()
									.npc(NpcID.ABYSSAL_ORPHAN_5884)
									.title(ABYSSAL_ORPHAN_TITLE)
									.animationId(ABYSSAL_ORPHAN_ANIMATION)
									.body("No, you are not.")
									.build();
							}
						})
						.build();
				}
			})
			.build();

	public final DialogNode LIL_ZIK_4 =
		DialogNode.builder()
			.player()
			.animationId(PLAYER_TALK_1)
			.body("Hi, I'm here for my reward!")
			.next(DialogNode.builder()
				.npc(NpcID.LIL_ZIK_8337)
				.title(LIL_ZIK_TITLE)
				.body("Not again...")
				.animationId(LIL_ZIK_ANIMATION)
				.build()
			).build();

}
