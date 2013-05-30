package bobblesbot;

import java.io.IOException;
import org.pircbotx.PircBotX;
import org.pircbotx.exception.IrcException;
import org.pircbotx.hooks.Listener;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

/**
 *
 * @author Bobbles
 * 
 */
public class BobblesBot extends ListenerAdapter implements Listener
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        try   
        {
            PircBotX bot = new PircBotX();
            bot.getListenerManager().addListener(new BobblesBot());
            bot.setName("BobblesBot");
            bot.connect("irc.freenode.net",8001);
            bot.joinChannel("#bobbles");
            } 
        catch (IOException ex) 
        {
                System.out.println("IO Exception: "+ex.getMessage());
        } 
        catch (IrcException ex) 
        {
                System.out.println("IRC Exception: "+ex.getMessage());
            
        }
    }
    
     @Override
        public void onMessage(MessageEvent event) throws Exception 
     {
         if (event.getMessage().startsWith("!hello"))
                        event.respond("Hello!");
         
          if (event.getMessage().startsWith("!commands"))
              event.respond("!commands, !hello ");
     }   
}
