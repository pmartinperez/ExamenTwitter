
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
 * @author Patricia Martin
 * @version 1.0
 */
public class MetodosTwitter {
/**
     * twitter atributo de tipo Twitter
     */
    Twitter twitter;
    
    /**
    * Constructor de la clase. Determinamos la configuracion y autorizacion de la aplicacion.
    */
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
     *
     * @throws TwitterException
     */
    public void getTimeLine() throws TwitterException {
        List<Status> statuses = twitter.getHomeTimeline();
        System.out.println("Mostrar timeline");
        for (Status status : statuses) {
            System.out.println(status.getUser().getName() + ":" + status.getText());
        }

    }
    
    /**
     * Metodo para buscar un texto en Twitter
     *
     * @param buscarTexto texto que introduce el usuario y que vamos a buscar
     * @throws TwitterException
     */
    public void searchTweets(String buscarTexto) throws TwitterException {
        Query query = new Query(buscarTexto);
        QueryResult result = twitter.search(query);
        //le damos otro nombre a status porque ya existe en el codigo anterior
        for (Status status2 : result.getTweets()) {
            System.out.println("@" + status2.getUser().getScreenName() + ":" + status2.getText());
        }
    }

    /**
     * Metodo para escribir un tweet
     *
     * @param textoTweet texto que introduce el usuario y que se escribira en Tweeter
     * @throws TwitterException
     */
    public void postTweet(String textoTweet) throws TwitterException {
        Status status3 = twitter.updateStatus(textoTweet);
        System.out.println("Successfully updated the status to [" + status3.getText() + "].");
    }
    
   
}
