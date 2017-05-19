package com.acmerocket.fireside;

import java.util.Scanner;

/**
 * Unit test for simple App.
 */
public class TestWaWa {
	public static void main(String[] args) {
		Thesaurus thes = Thesaurus.instance();

		Scanner scanner = new Scanner(TestWaWa.class.getResourceAsStream("/rapunzel.txt"));
		StringBuffer orig = new StringBuffer();
		StringBuffer retold = new StringBuffer();
		while (scanner.hasNext()) {
			String next = scanner.next();
			
			orig.append(next).append(" ");
			retold.append(thes.get(next)).append(" ");
		}
		scanner.close();
		
		System.out.println(orig.toString());
		System.out.println(retold.toString());

	}
}

/* --- NOTES ---

There were once a man and a woman who had long in vain wished for a child. 
At length the woman hoped that God was about to grant her desire. 
These people had a little window at the back of their house from which a splendid garden could be seen, 
which was full of the most beautiful flowers and herbs. 
It was, however, surrounded by a high wall, and no one dared to go into it because it belonged 
to an enchantress, who had great power and was dreaded by all the world. One day the woman was
standing by this window and looking down into the garden, when she saw a bed which was planted with 
the most beautiful rampion (rapunzel), and it looked so fresh and green that she longed for it, 
she quite pined away, and began to look pale and miserable. Then her husband was alarmed, and asked: 
'What ails you, dear wife?' 'Ah,' she replied, 'if I can't eat some of the rampion, which is in the 
garden behind our house, I shall die.' The man, who loved her, thought: 'Sooner than let your wife die, 
bring her some of the rampion yourself, let it cost what it will.' At twilight, he clambered down over 
the wall into the garden of the enchantress, hastily clutched a handful of rampion, and took it to his 
wife. She at once made herself a salad of it, and ate it greedily. It tasted so good to her--so very good, 
that the next day she longed for it three times as much as before. If he was to have any rest, her husband 
must once more descend into the garden. In the gloom of evening therefore, he let himself down again; but 
when he had clambered down the wall he was terribly afraid, for he saw the enchantress standing before him. 
'How can you dare,' said she with angry look, 'descend into my garden and steal my rampion like a thief? 
You shall suffer for it!' 'Ah,' answered he, 'let mercy take the place of justice, I only made up my mind 
to do it out of necessity. My wife saw your rampion from the window, and felt such a longing for it that 
she would have died if she had not got some to eat.' Then the enchantress allowed her anger to be softened, 
and said to him: 'If the case be as you say, I will allow you to take away with you as much rampion as you 
will, only I make one condition, you must give me the child which your wife will bring into the world; it 
shall be well treated, and I will care for it like a mother.' The man in his terror consented to everything, 
and when the woman was brought to bed, the enchantress appeared at once, gave the child the name of Rapunzel, 
and took it away with her. 

There were at any time designer bub shoplift developer womankind who arid hunger in agreement with idle wished 
amid manipulator child. lutetium diameter the womanliness hoped ally the Supreme Soul was close at hand midst 
supply her desire. These tons straightlaced manipulator opposed lantern in favor of the bosky with their 
perihelion on the surface which wire-puller striking classical could live through seen, which was deviative 
on top of the lift titillative festivity palm herbs. It was, however, intertied all up manipulator out of it 
wall, extort most assuredly encyclopedic dared about dispense fittingly better self grounds herself belonged 
spite of envisagement enchantress, who staunch significant first place snatch was astronomical concluded Old 
World the world. One solar year the ripe age was angle of vision zapped this oriel walk off with grandfather 
clock light air with it the garden, hitherto better self proverbial saying wire-puller hobbles which was 
pocked not to mention the extreme limit dissolute rampion (rapunzel), pilfer you looked quite kinetic snitch 
puerile second self I longed along with it, my humble self voting pined away, poach began hereby guise beset 
crib miserable. Then yours truly make no sign was alarmed, defraud asked: 'What ails you, deserved wife?' 'Ah,' 
superego replied, 'if alter can't detract dexterous up against the rampion, which is in line with the quotidian 
antedated our house, oneself low die.' The man, who cherished her, thought: 'Sooner than pour your legalis homo 
die, wreck I satisfactory by way of the rampion yourself, allot inner man esteem far from it yours truly will.' 
B twilight, superego clambered thistledown someday the sweat in line the garden as regards the enchantress, of 
a sudden clutched a smitch as respects rampion, hook took alter partnered with male person wife. She in favor 
of upon which ready-made superego entrepreneur lush speaking of it, win hands down ate it greedily. It tasted 
highly exquisite in despite of her--so utter good, aforementioned the in the sequel fiscal year alter ego longed 
thereby yourselves trialogue affairs albeit biosphere seeing as how before. If ego was amongst listen to reason 
comprehension rest, he bosom drag whenever all included debase compatibly the garden. ferrous the shadiness to 
sext therefore, inner self confer he gentle wind again; notwithstanding albeit inner man cheapskate clambered 
feathers the combine ourselves was practically afraid, among she wisdom literature the hellcat situation again 
him. 'How toilet I dare,' vocoid number one as well as whipped up look, 'descend trendy my homely snitch twirl 
my rampion devotion enterpriser thief? You testify against swell as well as it!' 'Ah,' answered he, 'let whip 
give the open fire re justice, you absolutely fabricated crime my prankster with perpetrate subliminal self 
cold wherewith necessity. My mature man precept your rampion without the window, appropriate alpaca combine 
strategian dollar hereby alter pendant themselves would be willing died assuming that himself severe not a bit 
got workmanlike wherewithal eat.' Then the blot earned it asperity thereby happen to be softened, scrounge light 
amid him: 'If the departed spirit tide over boundary condition him say, you utterance string not oppose yours 
truly regardless of cost drop round about among I myself the while Western Hemisphere rampion as superego will, 
in all respects yours truly net divisions condition, it swine get along without them the birth which your man 
newsletter realize modish the world; oneself tell secrets get by praxis treated, appropriate subliminal self 
release passionateness spite of alter ego flame developer mother.' The sugar daddy attended by inanimate gallant 
consented in line with everything, win hands down to this day the driving age was brought on bed, the crone 
appeared along with once, gave the young fry the unexceptionable towards Rapunzel, pilfer took yourselves 
against the grain wherewithal her. 

*/