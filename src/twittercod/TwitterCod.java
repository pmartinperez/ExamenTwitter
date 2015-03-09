package twittercod;

import javax.swing.JOptionPane;
import twitter4j.TwitterException;

/**
 * Clase principal del proyecto donde encontramos un menu
 * @author Patripon
 * @version 1.0
 */
public class TwitterCod {

    /**
     * Menu con distintas opciones con la que podemos llamar a los metodos que necesitamos
     * @param args the command line arguments
     * @throws twitter4j.TwitterException
     */
    public static void main(String[] args) throws TwitterException {
        MetodosTwitter metodos1 = new MetodosTwitter();

        String[] opciones = {"Mostrar TimeLine", "Buscar Tweet", "Tweetear", "Cerrar"};
        int opcion;
        do {
            opcion = JOptionPane.showOptionDialog(null, "Que quieres hacer?", "Opciones", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, opciones, null);

            switch (opcion) {
                case 0:
                    metodos1.getTimeLine();
                    break;
                case 1:
                    String buscar = JOptionPane.showInputDialog("Introducir dato a buscar");
                    metodos1.searchTweets(buscar);
                case 2:
                    String texto = JOptionPane.showInputDialog("Introducir tweet");
                    metodos1.postTweet(texto);
                case 3:
                    System.exit(0);
            }
        } while (opcion != 4);

    }

}
