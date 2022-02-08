package my.uum;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.sql.SQLException;

/**
 * This class is used to run the Telegram bot API and register bot.
 *
 * @author H'ng Chew Teng
 */
public class App {

    /**
     * This is the main method for running the Telegram bot API and register bot
     *
     */
    public static void main(String[] args) {

        try {

            new Main().main();

            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new telegramBot());

            System.out.println("\n Telegram Bot is now ready to be used!\n");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@&%%#%%@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" +
                    "@@@@@@@@@@@@@@@@@@@%(*,*/((((/,..    .*(&@@@@@@@@@@@@@@@@@@@\n" +
                    "@@@@@@@@@@@@@@@@,.**,,..  ....,***/(,    ,(@@@@@@@@@@@@@@@@@\n" +
                    "@@@@@@@@@@@@#.                 . .*(###*  ..(@@@@@@@@@@@@@@@\n" +
                    "@@@@@@@@@@, .                 .....   ,/#&. ..%@@@@@@@@@@@@@\n" +
                    "@&#///*,...     ..                         ,.  ,@@@@@@@@@@@@\n" +
                    "@@@@@@, .      .,...                     #&(  /* %@@@@@@@@@@\n" +
                    "@%(/,*..      ..**.,                  .  /#, ...# *@@@@@@@@@\n" +
                    "@@@@@,.       //*(/.*                 .   *, .,,*%  @@@@@@@@\n" +
                    "@@@@@ .    .  /((//*/, . .,.   ..      .  *,..*(#&. ..(&@@@@\n" +
                    "@@@@@.. ..... /###(,,#.*,  ,* ,  .     .. *...*%&%. @@@@@@@@\n" +
                    "@@@@@.. ......   /###**%#(#**(%%,      ... .,.,/, ./@@@@@@@@\n" +
                    "@@@@@% ...,..,.(.%*#%##%#%%%&&%%%..  . ,.      .   #@@@@@@@@\n" +
                    "@@@@@@# ...**./(##/(%%%%%%%%%%%##/, ...,..    ..     *@@@@@@\n" +
                    "@@@@@@@#.%   .,./(/#(/,#%%%%%%###(* *,*,    . ..       .@@@@\n" +
                    "@@@@@@@@@#&.. ..*//(((#%%%%(#%##((.,/(,    ..,     ...   #@@\n" +
                    "@@@@@@@@@@@&   . ,//((.,(#(####(/*,*/.     ,    .,,, ,.  &@@\n" +
                    "@@@@@@@@@@@@/  .*, .///((((##((***,*.  .   ..,.,, .    (@@@@\n" +
                    "@@@@@@@@@@@@/@ ./@@  @&/(#((/(/**,,   .  .,   ,,.    &@@@@@@\n" +
                    "@@@@@@@&%#(&@@(@(%@@*@@@@*    */,...      .,.    .(@@@@@@@@@\n" +
                    "@@@@@@@@@@@@@@@@@@@@@@@@         ...           #@@@@@@@@@@@@\n" +
                    "@@@@@@@@@@@@@@@@@@@@@@&     ......        ,(&@@@@@@@@@@@@@@@\n" +
                    "@@@@@@@@@@@@@@@@@@@@@@@.  ...  ..     (@@@@@@@@@@@@@@@@@@@@@\n" +
                    "@@@@@@@@@@@@@@@@@@@@@@@@@#    .*/#@@@@@@@@@@@@@@@@@@@@@@@@@@\n");

        } catch (TelegramApiException | SQLException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
    }
}
