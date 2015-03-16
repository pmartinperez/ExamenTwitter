
package twittercod;


import java.util.List;
import twitter4j.DirectMessage;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;

import twitter4j.TwitterException;
import twitter4j.TwitterFactory;


import twitter4j.conf.ConfigurationBuilder;
/**
 * Clase con distintos metodos para utilizar Twitter
 * @author Patripon
 * @version 1.0
 */
public class MetodosTwitter {

    Twitter twitter;
    
   
   public MetodosTwitter() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("mHKck1YDvlTzDJsCkJZcl52Wn") 
                .setOAuthConsumerSecret("SHK3B2SLd69cB6UbSZYwY1mw5GhOBXkBaYNrDwtzIrgAmwhx7N") 
                .setOAuthAccessToken("963423895-i74zIBSoeDOHdx45Lao7ReiXtdhOP7SAOKFOyWk7") 
                .setOAuthAccessTokenSecret("31Rsy82hgxJwwtpt5DO3uvyiFrQvxlrWOAtMuziKodcnl");
        twitter = new TwitterFactory(cb.build()).getInstance();
       
    }
    
   
    
    
    /**
     * Metodo que nos muestra el timeline de Twitter
     * @throws TwitterException 
     */
    public void getTimeLine() throws TwitterException {
        List<Status> statuses = twitter.getHomeTimeline();
        System.out.println("Showing home timeline.");
        for (Status status : statuses) {
            System.out.println(status.getUser().getName() + ":" + status.getText());
        }

    }
    
    /**
     * Metodo para buscar informacion en Twitter
     * @param buscar texto que introduce el usuario y el que vamos a buscar
     * @throws TwitterException 
     */
    public void searchTweets(String buscar) throws TwitterException {
        Query query = new Query(buscar);
        QueryResult result = twitter.search(query);
        //le damos otro nombre a status porque ya existe en el codigo anterior
        for (Status status2 : result.getTweets()) {
            System.out.println("@" + status2.getUser().getScreenName() + ":" + status2.getText());
        }
    }

    /**
     * Metodo para escribir un tweet
     * @param texto texto que introduce el usuario y el que se escribira en Twitter Se ha hecho 
     * @throws TwitterException 
     */
    public void postTweet(String texto) throws TwitterException {
        Status status3 = twitter.updateStatus(texto);
        System.out.println("Successfully updated the status to [" + status3.getText() + "].");
    }
    
    //SENDING, RECEIVING DIRECT MESSAGES
    public void senRecTweet(String nombre, String mensaje) throws TwitterException{
    //Twitter sender = TwitterFactory.getSingleton();
    DirectMessage message = twitter.sendDirectMessage(nombre, mensaje);
    System.out.println("Sent: " + message.getText() + " to @" + message.getRecipientScreenName());
    }
}
