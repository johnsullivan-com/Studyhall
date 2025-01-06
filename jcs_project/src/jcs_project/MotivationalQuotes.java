package jcs_project;

import java.util.ArrayList;

public class MotivationalQuotes {
	static String getQuote() {
		String[] quotes = { "Life is 10% what happens to you and 90% how you react to it.",
				"Quality is not an act, it is a habit.",
				"A good plan violently executed now is better than a perfect plan executed next week.",
				"If you're going through hell, keep going.",
				"Good, better, best. Never let it rest. 'Til your good is better and your better is best.",
				"Our greatest weakness lies in giving up. The most certain way to succeed is always to try just one more time.",
				"It always seems impossible until it's done.",
				"It does not matter how slowly you go as long as you do not stop.",
				"An investment in knowledge pays the best interest.", "Some people die at 25 and aren't buried until 75." };
		int x = (int) (Math.random() * quotes.length);
		System.out.println("Class MotivationalQuotes Session ID Number: " + x);
		return quotes[x];
	}
}