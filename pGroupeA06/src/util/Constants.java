package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface Constants {
	public static final double 	INITIAL_VOLUME = 0,
								VOLUME_FACTOR = 0.001;
	
	public static final int NB_QUESTIONS_MAX = 4,
							SIZE_MAX_QUESTION = 65,
							ANIMATION_TIME_START = 1000, //3000
							ANIMATION_TIME_RATING = 1000,//2500
							ANIMATION_TIME_ERROR = 1000, //3000
							ANIMATION_TIME_TURN = 2000,
							ANIMATION_TIME_MESSAGE = 3500,
							ANIMATION_TIME_ANSWER=1500,
							TIMER_START = 35,
							TIMER_LIMIT = 10,
							STRING_PERCENTAGE_ERROR_ANSWER=20,
							NUMBER_PERCENTAGE_ERROR_ANSWER=2; 
	
	public static final String 	DECK_PATH = "/res/deck.JSON",
								BOARD_PATH= "/res/boardTest.JSON",
								RULE_PATH= "/res/GameRule.txt";
	
	// Size Players	
	public static final double 	PLAYER_HEIGHT = 100, PLAYER_WIDTH = 100;
	
}
