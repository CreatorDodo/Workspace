package sistMovie.util;

import java.util.Scanner;

public abstract class Pub {
	public static String id; 
	public static Scanner scan = new Scanner(System.in);
}

interface Heading {
	String ADMIN_MENU 			= "\n======= Member only ADMIN MENU  =====";
	String MEMBER_MENU 		 	= "\n======= Member only MEMBER MENU =====";
	String SURVEY_MEMBER_MENU 	= "\n========= SURVEY MEMBER MENU ========";
}