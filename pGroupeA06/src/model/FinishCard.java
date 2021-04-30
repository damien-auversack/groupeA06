package model;

import application.SceneManager;
import enumerations.Theme;
import javafx.animation.Animation;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.util.Duration;
import util.Constants;


/**
 * A SpecialCard which is used at the end of the game.
 * @author Martin*/
public class FinishCard extends SpecialCard{

	
	/**
	 * Calls the function animationLastTurn() from the GameOperation
	 * @param transitions	A table containing the previous animations which needs to be played before the ones this method creates
	 * */
	@Override
	public void action(Animation[] transitions) {
		Animation[] a = animCard(transitions);
		SequentialTransition st = new SequentialTransition(a);
		st.play();
	}

	
	/** Creates an animation for the last turn
	 * @return A table containing Animation of the whole turn*/
	@Override
	public Animation[] animCard(Animation[] first) {
		Animation[] tab = new Animation[(first==null)?4:first.length+4];
		Animation[] tabTemp = new Animation[4];
		
		//SceneManager.getSceneRoot().setRoot(SceneManager.getStackGame());
		SceneManager.getRating().setLbTurn(SceneManager.getCurrentGame().getPlayerTurn().getName());
		
		PauseTransition pauseTransition = new PauseTransition(Duration.millis(Constants.ANIMATION_TIME_TURN));
		pauseTransition.setOnFinished(e -> {
			BasicCard tempBasicCard = SceneManager.getCurrentGame().drawCard(Theme.getRandomTheme());
			SceneManager.getCurrentGame().setQuestion(tempBasicCard.getQuestions().get(3));
			SceneManager.getQuestion().getBtnOK().setDisable(false);
			SceneManager.getSceneRoot().setRoot(SceneManager.getStackQuestion());
		});
		
		tabTemp[3]= pauseTransition;
		tabTemp[2] = SceneManager.getCurrentGame().animation(Constants.ANIMATION_TIME_TURN,
				SceneManager.getStackTransititionAnimation(),
				"You have to answer\ncorrectly to this\ndifficult question to win");
		tabTemp[1] = SceneManager.getCurrentGame().animation(Constants.ANIMATION_TIME_TURN,
				SceneManager.getStackTransititionAnimation(),
				"It's " + SceneManager.getCurrentGame().getPlayerTurn().getName() + "'s \nlast turn!");
		tabTemp[0] = SceneManager.getCurrentGame().animation(Constants.ANIMATION_TIME_START,
				SceneManager.getStackGame(), null);
		if(first!=null) {
			for(int i = 0;i<first.length;i++) {
				tab[i]=first[i];
			}
			
			for(int i = first.length;i<first.length+4;i++) {
				tab[i]=tabTemp[i-first.length];
			}
			
			return tab;
		}
		else {
			
			return tabTemp;
		}
	}
}