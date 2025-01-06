package jcs_project;

import java.awt.Color;
import java.util.ArrayList;

public class Scheme {
	private static Color font = new Color(0, 0, 0);
	
	private static Color primary = new Color(0, 0, 0);
	private static Color primaryaccent1 = new Color(0, 0, 0);
	private static Color primaryaccent2 = new Color(0, 0, 0);
	
	private static Color secondary = new Color(0, 0, 0);
	private static Color secondaryaccent1 = new Color(0, 0, 0);
	private static Color secondaryaccent2 = new Color(0, 0, 0);
	
	private static Color tertiary = new Color(0, 0, 0);
	private static Color tertiaryaccent1 = new Color(0, 0, 0);
	private static Color tertiaryaccent2 = new Color(0, 0, 0);
	
	private static Color quaternary = new Color(0, 0, 0);
	private static Color quaternaryaccent1 = new Color(0, 0, 0);
	private static Color quaternaryaccent2 = new Color(0, 0, 0);
	
	private static Color lightmode = new Color(0, 0, 0);
	
	
	
	public static Color DARK_MODE() {
		return new Color(27, 27, 27);
	}
	
	public static Color LIGHT_MODE() {
		return Color.WHITE;
	}
	
	public static ArrayList<Color> getCoffeePallette() {
		ArrayList<Color> pallette = new ArrayList();
		primary = Color.decode("#322720");
		primaryaccent1 = Color.decode("#846654");
		primaryaccent2 = Color.decode("#655e5a");
		
		secondary = Color.decode("#514843");
		secondaryaccent1 = Color.decode("#b29d8f");
		secondaryaccent2 = Color.decode("#655e5a");
		
		tertiary = primary;
		tertiaryaccent1 = primaryaccent1;;
		tertiaryaccent2 = primaryaccent2;
		
		quaternary = secondary;
		quaternaryaccent1 = secondaryaccent1;
		quaternaryaccent2 = secondaryaccent2;
		
		font = LIGHT_MODE(); 
		
		pallette.add(primary); pallette.add(primaryaccent1); pallette.add(primaryaccent2);
		pallette.add(secondary); pallette.add(secondaryaccent1); pallette.add(secondaryaccent2);
		pallette.add(tertiary); pallette.add(tertiaryaccent1); pallette.add(tertiaryaccent2);
		pallette.add(quaternary); pallette.add(quaternaryaccent1); pallette.add(quaternaryaccent2); pallette.add(font);
		
		return pallette;
	}
	
	public static ArrayList<Color> getTropicalPallette() {
		ArrayList<Color> pallette = new ArrayList();
		primary = Color.decode("#ec6a00");
		primaryaccent1 = Color.decode("#dc6300");
		primaryaccent2 = Color.decode("#e3a46c");
		
		secondary = Color.decode("#f0b200");
		secondaryaccent1 = Color.decode("#dfa600");
		secondaryaccent2 = Color.decode("#fee8ab");
		
		tertiary = Color.decode("#d10d3f");
		tertiaryaccent1 = Color.decode("#9d072f");
		tertiaryaccent2 = Color.decode("#c20b3a");
		
		quaternary = Color.decode("#ec6a00");
		quaternaryaccent1 = Color.decode("#dc6300");
		quaternaryaccent2 = Color.decode("#e3a46c");
		
		font = DARK_MODE(); 
		
		pallette.add(primary); pallette.add(primaryaccent1); pallette.add(primaryaccent2);
		pallette.add(secondary); pallette.add(secondaryaccent1); pallette.add(secondaryaccent2);
		pallette.add(tertiary); pallette.add(tertiaryaccent1); pallette.add(tertiaryaccent2);
		pallette.add(quaternary); pallette.add(quaternaryaccent1); pallette.add(quaternaryaccent2);pallette.add(font);
		
		return pallette;
	}
	
	public static ArrayList<Color> getCoralPallette() {
		ArrayList<Color> pallette = new ArrayList();
		primary = Color.decode("#fcd0a9");
		primaryaccent1 = Color.decode("#faba82");
		primaryaccent2 = Color.decode("#fcdbbd");
		
		secondary = Color.decode("#9bdabe");
		secondaryaccent1 = Color.decode("#78caa4");
		secondaryaccent2 = Color.decode("#afe1cb");
		
		tertiary = Color.decode("#97bfd6");
		tertiaryaccent1 = Color.decode("#71a7c5");
		tertiaryaccent2 = Color.decode("#abccdf");
		
		quaternary = Color.decode("#96d3cf");
		quaternaryaccent1 = Color.decode("#71c1bb");
		quaternaryaccent2 = Color.decode("#abdcd9");
		
		font = DARK_MODE(); 
		
		pallette.add(primary); pallette.add(primaryaccent1); pallette.add(primaryaccent2);
		pallette.add(secondary); pallette.add(secondaryaccent1); pallette.add(secondaryaccent2);
		pallette.add(tertiary); pallette.add(tertiaryaccent1); pallette.add(tertiaryaccent2);
		pallette.add(quaternary); pallette.add(quaternaryaccent1); pallette.add(quaternaryaccent2); pallette.add(font);
		
		return pallette;
	}
	
	public static ArrayList<Color> getHazeBluePallette() {
		ArrayList<Color> pallette = new ArrayList();
		primary = Color.decode("#9489e0");
		primaryaccent1 = Color.decode("#705dfb");
		primaryaccent2 = Color.decode("#8071eb");
		
		secondary = Color.decode("#bab4df");
		secondaryaccent1 = Color.decode("#adaab9");
		secondaryaccent2 = Color.decode("#8071eb");
		
		tertiary = primary;
		tertiaryaccent1 = primaryaccent1;
		tertiaryaccent2 = primaryaccent2;
		
		quaternary = secondary;
		quaternaryaccent1 = primaryaccent1;
		quaternaryaccent2 = primaryaccent1;
		
		font = LIGHT_MODE();
		
		pallette.add(primary); pallette.add(primaryaccent1); pallette.add(primaryaccent2);
		pallette.add(secondary); pallette.add(secondaryaccent1); pallette.add(secondaryaccent2);
		pallette.add(tertiary); pallette.add(tertiaryaccent1); pallette.add(tertiaryaccent2);
		pallette.add(quaternary); pallette.add(quaternaryaccent1); pallette.add(quaternaryaccent2); pallette.add(font);

		return pallette;
	}
	
	public static ArrayList<Color> getRosePallette() {
		ArrayList<Color> pallette = new ArrayList();
		primary = Color.decode("#f9a29b");
		primaryaccent1 = Color.decode("#f76151");
		primaryaccent2 = Color.decode("#f77e73");
		
		secondary = Color.decode("#f9ac9a");
		secondaryaccent1 = Color.decode("#f77351");
		secondaryaccent2 = Color.decode("#f88c72");
		
		tertiary = Color.decode("#f79da1");
		tertiaryaccent1 = Color.decode("#f65a5e");
		tertiaryaccent2 = Color.decode("#f6777c");
		
		quaternary = Color.decode("#f9a29b");
		quaternaryaccent1 = Color.decode("#f77e73");
		quaternaryaccent2 = Color.decode("#f76151");
		
		font = DARK_MODE();
		
		pallette.add(primary); pallette.add(primaryaccent1); pallette.add(primaryaccent2);
		pallette.add(secondary); pallette.add(secondaryaccent1); pallette.add(secondaryaccent2);
		pallette.add(tertiary); pallette.add(tertiaryaccent1); pallette.add(tertiaryaccent2);
		pallette.add(quaternary); pallette.add(quaternaryaccent1); pallette.add(quaternaryaccent2); pallette.add(font);
		
		return pallette;
	}
	
	public static ArrayList<Color> getCottagePallette() {
		ArrayList<Color> pallette = new ArrayList();
		primary = new Color(229, 211, 194);
		primaryaccent1 = new Color(211, 192, 177);
		primaryaccent2 = Color.decode("#b69981");
		
		secondary = primary;
		secondaryaccent1 = primaryaccent1;
		secondaryaccent2 = primaryaccent2;
		
		tertiary = primary;
		tertiaryaccent1 = primaryaccent1;
		tertiaryaccent2 = primaryaccent2;
		
		font = DARK_MODE();
		
		quaternary = Color.decode("#7a8e8c");
		quaternaryaccent1 = Color.decode("#53716e");
		quaternaryaccent2 = Color.decode("#6f8281");
		pallette.add(primary); pallette.add(primaryaccent1); pallette.add(primaryaccent2);
		pallette.add(secondary); pallette.add(secondaryaccent1); pallette.add(secondaryaccent2);
		pallette.add(tertiary); pallette.add(tertiaryaccent1); pallette.add(tertiaryaccent2);
		pallette.add(quaternary); pallette.add(quaternaryaccent1); pallette.add(quaternaryaccent2); pallette.add(font);
		
		return pallette;
	}
}